package com.serbond.smetacompose.domain.model.stair

data class Stair (
    val id: Long,
    val stairCaseId: Long,
    //var type: String, //  прямая, забежная, винтовая
    var name: String,
    var height: Double, //высота
    var length: Double, //длина
    var width: Double,//глубина
    var listSide: List<Any>? = null,//лист сторон ступени при неправильной форме
    var note: String = ""
)