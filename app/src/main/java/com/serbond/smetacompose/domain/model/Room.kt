package com.serbond.smetacompose.domain.model

data class Room(
    val id: Long ,
    var levelId: Long,
    var name: String,
    var rectangle: Boolean,   //  прямоугольник
    var mansard: Boolean,     //  мансарда
    var note: String = ""
)
