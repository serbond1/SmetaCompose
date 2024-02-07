package com.serbond.smetacompose.domain.model

const val WINDOWS = "окно"
const val DOOR = "дверь"
const val BLOCK = "балконный блок"
const val BEAM = "балка"
const val OPENING = "проем"
const val NICHE = "ниша"
const val AREA = "участок"


data class Element(
    val id: Long ,
    val planeId: Long,
    var name: String,
    var type: String = "", //тип элемента
    var form: String = "", // форма элемента
    //var arc: Boolean = false,
//    var area: Double = 0.0,
//    var perimeter: Double = 0.0,
    var active: Boolean,  //  false - не учитывать action, true - учитывать action
    //var podokonnik: Boolean = false,
    //var duplicate: Boolean = false,
    //var duplicateId: Long = 0,
    var action: Boolean,                //  false - вырезать, true - прибавить
    var note: String = ""

)
