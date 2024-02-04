package com.serbond.smetacompose.domain.model


data class Wall (
    val id: Long = 0,
    val roomId: Long,
    var name: String,
    var size: List<Any> = listOf(0.0,0.0, INNER,90) , // длина,высота,тип угла,угол,
    var sizeRadius: List<Any>? =  null , //listOf(0.0, OUTER) длина хорды, тип радиуса
    var listSide: List<Any>? = null, // лист сторон стены при неправильной форме
    var area: Double = 0.0,
    var active : Boolean = true,
    var note: String = "",

)