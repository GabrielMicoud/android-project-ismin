package com.ismin.android

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

private const val ARG_MONUMENTS = "monuments"

class MapsFragment : Fragment() {
    private lateinit var monuments: ArrayList<Monument>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val argMonuments = requireArguments().getSerializable(ARG_MONUMENTS) as ArrayList<Monument>?
        monuments = argMonuments ?: ArrayList()
    }

    private val callback = OnMapReadyCallback { googleMap ->

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        var coordMean1  : Double = 0.0
        var coordMean2 : Double = 0.0

        for(monument in monuments){
            val coord1 = monument.geo_point_2d[0]
            val coord2 = monument.geo_point_2d[1]
            googleMap.addMarker(MarkerOptions().position(LatLng(coord1,coord2)).title(monument.immeuble))
            coordMean1 += coord1
            coordMean2 += coord2
        }
        coordMean1/=monuments.size
        coordMean2/=monuments.size
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(coordMean1,coordMean2)))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.f_maps_map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    companion object {
        @JvmStatic
        fun newInstance(monuments: ArrayList<Monument>) =
            MapsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_MONUMENTS, monuments)
                }
            }
    }
}