package com.serbond.smetacompose.domain.model

import androidx.room.Embedded
import androidx.room.Relation
import java.util.Date

data class Obj(
    val id: Long,
    var name: String,
    val dataStart: Date,
    val dataFinish: Date,
    var archive: Boolean,
    val info: InfoObject
)

data class InfoObject(
    var address: String = "",
    var fio: String = "",
    var tel: String = "",
    var email: String = "",
    var note: String = ""
)

data class ObjData(
    var name: String,
    var areaWall: Double,
    var areaFloor: Double,
    val dataStart: Int,
)
data class ObjWithLevel(
   // @Embedded
    val obj: Obj,
   // @Relation(parentColumn = "id", entityColumn = "objId", entity = RoomObj::class)
    var levelList: List<Level>
)
