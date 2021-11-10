package com.ismin.android

import java.io.Serializable
import java.util.*

data class Monument (val immeuble : String,//nom monument
                     val dep : String,//nom département
                     val nomcom : String,//code postal commune
                     val datasetid : String,
                     val recordid : String,
                     val insee : String,
                     val objectid_1 : String,
                     val lien_merim : String,
                     val objectid : String,
                     val type_archi : String,
                     val geo_point_2d : FloatArray,//coordonnés
                     val st_lengthshape : String,
                     val protection : String,
                     val date_prot : Date,
                     val st_areashape : String,
                     val ref_merim : String,
                     val type_prot : String,
                     val type : String,
                     val coordinates : FloatArray,
                     val record_timestamp : Date,
                     val favorite : Boolean,):Serializable {}
