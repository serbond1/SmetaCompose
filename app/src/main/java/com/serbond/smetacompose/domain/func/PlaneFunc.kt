package com.serbond.smetacompose.domain.func

import androidx.compose.runtime.withFrameNanos
import com.serbond.smetacompose.domain.model.BLOCK
import com.serbond.smetacompose.domain.model.CEIL
import com.serbond.smetacompose.domain.model.DOOR
import com.serbond.smetacompose.domain.model.ElementWithSide
import com.serbond.smetacompose.domain.model.FLOOR
import com.serbond.smetacompose.domain.model.INNER
import com.serbond.smetacompose.domain.model.OUTER
import com.serbond.smetacompose.domain.model.PARTITION
import com.serbond.smetacompose.domain.model.PlaneWithElement
import com.serbond.smetacompose.domain.model.PlaneWithSide
import com.serbond.smetacompose.domain.model.Side
import com.serbond.smetacompose.domain.model.WALL
import com.serbond.smetacompose.domain.model.WINDOWS

class PlaneFunc {
    companion object{
        fun areaWall(planeWithElement: PlaneWithElement): Double{
            return areaPlane(planeWithElement)
        }
        fun areaPartition(planeWithElement: PlaneWithElement): Double{
            return areaPlane(planeWithElement)*2
        }
        fun areaPlane(planeWithElement: PlaneWithElement): Double {
            var area = 0.0
            area = if (planeWithElement.planeWithSide.plane.rect) {
                Round.double2(planeWithElement.planeWithSide.listSide[0].side.length *
                        planeWithElement.planeWithSide.listSide[1].side.length)
            } else {
                val list = mutableListOf<Side>()
                planeWithElement.planeWithSide.listSide.forEach {
                    list.add(it.side)
                }
                Point.newArea(Point.newPoint(list)) + AreaFunc.addAreaSegment(list)
            }
            if (planeWithElement.planeWithSide.plane.type == PARTITION) area *= 2
            planeWithElement.listElementWithSide.forEach {
                if (planeWithElement.planeWithSide.plane.type == PARTITION) {
                              ////////
                    when (it.element.type) {
                        DOOR, WINDOWS, BLOCK -> area += ElementFunc.areaElementActive(it)
                    }
                }
                area += ElementFunc.areaElementActive(it)
                if (planeWithElement.planeWithSide.plane.type == WALL) area += ElementFunc.areaSideAddWall(it.listSide)
            }
            return area
        }
    }
}