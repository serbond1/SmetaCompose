package com.serbond.smetacompose.domain.model

import com.serbond.smetacompose.domain.model.stair.Stair
import com.serbond.smetacompose.domain.model.stair.Stairway
import com.serbond.smetacompose.domain.model.stair.StairwayWithStaircase

data class Level(
    val id: Long,
    val objId: Long,
    var name: String,
    var note: String = ""
)

data class LevelWithRoom(
    val level: Level,
    var roomList: List<RoomWithPlane> ,
    var stairList: List<StairwayWithStaircase>
)
