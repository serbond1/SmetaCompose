package com.serbond.smetacompose.domain.model.slope

data class SlopeSetting(
    var areaFloorAdd: Boolean = false,
    var areaFloorRemove: Boolean = false,
    var areaCellAdd: Boolean = false,
    var areaCellRemove: Boolean = false,
    var areaWallAdd: Boolean = false,
    var areaWallRemove: Boolean = false,
    var perimeterFloorRemove: Boolean = false,
    var perimeterFloorAdd: Int = 0,             // 0 - не прибавлять , 1 - прибавить ширину , 2 - прибавить 2 ширины
    var perimeterCellRemove: Boolean = false,
    var perimeterCellAdd: Int = 0,              // 0 - не прибавлять , 1 - прибавить ширину , 2 - прибавить 2 ширины


)
