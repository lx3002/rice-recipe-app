package com.example.myapplication.models;

import androidx.annotation.DrawableRes
import com.example.myapplication.R

data class Recipe (
    val id : Long,
    val title : String,
    val ingredients:List<String>,
    @DrawableRes
    val imageResource:Int,
    val method : List<String>
)

val rice = Recipe (
    1,
    "RICE",
    listOf("4 cups of water\n" +
            "2 cups of Basmati rice\n" +
            "1 table spoon of curry powder\n" +
            "2 tablespoon of salt\n" +
            "2 table spoon of pilau masala\n" +
            "some corriander\n" +
            "2 tablespoon of tomato to paste\n" +
            "1tsp chili flacks\n" ),
    R.drawable.rice, listOf(" rice is an ancient chinese food so requires patience yo prepare\n" +
            "boil the water at 100 decgerss celcius\n" +
            "cut allitle bit of corriander and add to the water\n" +
            "add the salt \n" +
            "add the curry powder\n" +
            "add the tumeric \n" +
            "aloow the water to boil for 45 minutes\n" +
            "add the rice and wait for thirty minutes\n" +
            "by the way do not stir this is where the patience works ")
)
val food = listOf(rice)