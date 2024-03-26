package com.serbond.smetacompose.domain.func

import com.serbond.smetacompose.domain.model.CEIL
import com.serbond.smetacompose.domain.model.CEIL_MANSARD
import com.serbond.smetacompose.domain.model.ElementWithSide
import com.serbond.smetacompose.domain.model.FLOOR
import com.serbond.smetacompose.domain.model.PARTITION
import com.serbond.smetacompose.domain.model.RoomWithPlane
import com.serbond.smetacompose.domain.model.WALL

class RoomFunc {
    companion object{

        fun areaWallRoom(roomWithPlane: RoomWithPlane): Double{
            var area = 0.0
            roomWithPlane.listPlaneWithElement.forEach {
                if (it.planeWithSide.plane.type == WALL) area += PlaneFunc.areaPlane(it)
            }
            return area
        }
        fun areaFloorRoom(roomWithPlane: RoomWithPlane): Double{
            var area = 0.0
            roomWithPlane.listPlaneWithElement.forEach {
                if (it.planeWithSide.plane.type == FLOOR) area += PlaneFunc.areaPlane(it)
                if (it.planeWithSide.plane.type == PARTITION) {  // вычитание площади перегородки
                    area -= it.planeWithSide.plane.depth * it.planeWithSide.listSide[0].side.length
                }
                it.listElementWithSide.forEach { e ->
                    area += ElementFunc.areaSideAddFloor(e.listSide)
                }
            }
            return area
        }
        fun areaCeilRoom(roomWithPlane: RoomWithPlane): Double{
            var area = 0.0
            roomWithPlane.listPlaneWithElement.forEach {
                if (it.planeWithSide.plane.type == CEIL) area += PlaneFunc.areaPlane(it)
                if (it.planeWithSide.plane.type == PARTITION) {   // вычитание площади перегородки
                    area -= it.planeWithSide.plane.depth * it.planeWithSide.listSide[0].side.length
                }
                it.listElementWithSide.forEach { e ->
                    area += ElementFunc.areaSideAddCeil(e.listSide)
                }
            }
            return area
        }
    }
}