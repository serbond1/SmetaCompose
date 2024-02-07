package com.serbond.smetacompose.domain.model.slope

data class Slope(
    val id: Long = 0,
    val elementId: Long,
    var length: Double, //длина
    var width: Double = 0.0, //ширина
    var corner: Int? = null, //угол
    var cornerType: String? = null, //тип угла
    var radius: Boolean = false,
    var radiusType: String? = null,
    var horda: Boolean = false,
    var active : Boolean = false,
    //var arc: Boolean = false,
    val setting: SlopeSetting
)
