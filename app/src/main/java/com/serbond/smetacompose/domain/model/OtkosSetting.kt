package com.serbond.smetacompose.domain.model

data class OtkosSetting(
    var areaFloorAdd: Boolean = false,
    var perimeterFloorRemove: Boolean = false,
    var perimeterFloorAdd: Int = 0,             // 0 - не прибавлять , 1 - прибавить ширину , 2 - прибавить 2 ширины
    var perimeterCellRemove: Boolean = false,
    var perimeterCellAdd: Int = 0,              // 0 - не прибавлять , 1 - прибавить ширину , 2 - прибавить 2 ширины
    var areaCellAdd: Boolean = false,
    var areaWallAdd: Boolean = false
)
