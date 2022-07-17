package com.serbond.smetacompose.domain.model

data class Slope(
    val id: Long = 0,
    val childElementId: Long,
    var length: Double = 0.0,
    var width: Double = 0.0,
    var active : Boolean = false,
    var arc: Boolean = false,
    val setting: SlopeSetting
)
