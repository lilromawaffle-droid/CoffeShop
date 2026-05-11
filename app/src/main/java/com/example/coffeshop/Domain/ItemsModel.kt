package com.example.coffeshop.Domain

import java.io.Serializable

data class ItemsModel(
    var title:String ="",
    var description:String ="",
    var picUrl: ArrayList<String> = ArrayList(),
    var price: Double = 0.0,
    var rating: Double = 0.0,
    var numInCart:Int =0,
    var extra : String = ""
) : Serializable
