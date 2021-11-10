package com.ismin.android

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(){
    private val imei = "1234"
    private val TAG = MainActivity::class.java.simpleName
    private val monumentshelf = Monumentshelf()
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://project-gmd-npl.cleverapps.io/")
        .build()
    val monumentService = retrofit.create(MonumentService::class.java)

    private lateinit var btnList: Button
    private lateinit var btnMap: Button
    private lateinit var btnInfo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnList = findViewById(R.id.a_main_btn_list)
        btnMap = findViewById(R.id.a_main_btn_map)
        btnInfo = findViewById(R.id.a_main_btn_info)

        btnList.setOnClickListener{
            displayMonumentList();
        }

        btnMap.setOnClickListener{
            displayMap();
        }

        btnInfo.setOnClickListener{
            displayInfo();
        }

        loadAllMonuments()
    }

    private fun loadAllMonuments() {
        monumentService.getAllMonuments(imei).enqueue(object : Callback<List<Monument>> {
            override fun onResponse(
                call: Call<List<Monument>>,
                response: Response<List<Monument>>
            ) {
                val allMonuments: List<Monument>? = response.body()

                allMonuments?.forEach {
                    monumentshelf.addMonument(it)
                }
                displayMonumentList();
            }

            override fun onFailure(call: Call<List<Monument>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error when trying to fetch monuments" + t.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }
        )
    }

    private fun displayMonumentList() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = MonumentListFragment.newInstance(monumentshelf.getAllMonuments())
        fragmentTransaction.replace(R.id.a_main_lyt_fragment_container, fragment)
        fragmentTransaction.commit()
    }

    private fun displayMap() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = MapsFragment.newInstance()
        fragmentTransaction.replace(R.id.a_main_lyt_fragment_container, fragment)
        fragmentTransaction.commit()
    }

    private fun displayInfo() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = AppInfoFragment.newInstance("Nicolas")
        fragmentTransaction.replace(R.id.a_main_lyt_fragment_container, fragment)
        fragmentTransaction.commit()
    }

}