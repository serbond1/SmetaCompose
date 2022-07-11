package com.serbond.smetacompose.domain.model

data class Otkos(
    val id: Long = 0,
    val windowsId: Long,
    val dimensions: Dimensions,
//    var length: Double = 0.0,
//    var width: Double = 0.0,
    var active : Boolean = false,
    var arc: Boolean = false,
    val setting: OtkosSetting,
    var note: String = ""
)
