package com.serbond.smetacompose.domain.model.side_element

import com.serbond.smetacompose.domain.model.Side

data class SideElement(
    val id: Long = 0,
    val elementId: Long,
    val side: Side,
    var width: Double = 0.0, //ширина,толщина
    var active : Boolean = false,
    val setting: SideElementSetting
)
