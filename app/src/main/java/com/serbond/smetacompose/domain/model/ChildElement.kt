package com.serbond.smetacompose.domain.model

const val WINDOWS = "окно"
const val DOOR = "дверь"
const val BLOCK = "балконный блок"
const val BEAM = "балка"
const val OPENING = "проем"
const val NICHE = "ниша"
const val AREA = "участок"


data class ChildElement(
    val id: Long ,
    val baseElementId: Long,
    var type: String = "",
    var area: Double = 0.0,
    var perimeter: Double = 0.0,
    //var podokonnik: Boolean = false,
    //var duplicate: Boolean = false,
    //var duplicateId: Long = 0,
    var areaRemove: Boolean = true,
    var note: String = ""
    //var arc: Boolean = false
)
