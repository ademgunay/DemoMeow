package com.gunaya.demo.demomeow.data.entities

import com.google.gson.annotations.SerializedName

data class Cat(
    val id: String,
    @SerializedName("url")
    val imageUrl: String
)
/* Cat response example
  {
    "id": "89f",
    "url": "https://25.media.tumblr.com/tumblr_lznbbvPuZy1r63pb5o1_250.gif",
    "breeds": [],
    "categories": []
  }
 */
