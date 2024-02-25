package com.serbond.smetacompose.domain.model

import com.serbond.smetacompose.domain.func.AreaFunc
import com.serbond.smetacompose.domain.func.Round
import com.serbond.smetacompose.domain.model.side_element.SideElement

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
    var area: Double = 0.0,
    var slope: Double = 0.0,
    var active: Boolean,  //  false - не учитывать action, true - учитывать action
    var action: Boolean,                //  false - вырезать, true - прибавить
    var note: String = ""

){

}

data class ElementWithSide(
    val element: Element,
    val listSide: List<SideElement>
)

