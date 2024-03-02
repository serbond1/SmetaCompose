package com.serbond.smetacompose.domain.func

import androidx.compose.runtime.withFrameNanos
import com.serbond.smetacompose.domain.model.CEIL
import com.serbond.smetacompose.domain.model.ElementWithSide
import com.serbond.smetacompose.domain.model.FLOOR
import com.serbond.smetacompose.domain.model.INNER
import com.serbond.smetacompose.domain.model.OUTER
import com.serbond.smetacompose.domain.model.PlaneWithElement
import com.serbond.smetacompose.domain.model.PlaneWithSide
import com.serbond.smetacompose.domain.model.Side
import com.serbond.smetacompose.domain.model.WALL

class PlaneFunc {
    companion object{
        fun areaPlane(planeWithSide: PlaneWithSide): Double{

             if (planeWithSide.plane.rect) {
                 return Round.double2(planeWithSide.listSide[0].side.length * planeWithSide.listSide[1].side.length)
            } else {
                 val list = mutableListOf<Side>()
                 val listRadiusSide = arrayListOf<Side>()
                 var action = true
                 planeWithSide.listSide.forEach {
                     list.add(it.side)
                     if (it.side.horda) listRadiusSide.add(it.side)
                     if (it.side.radius) listRadiusSide.add(it.side)
                     if (it.side.radius && it.side.cornerType == INNER) action = false

                 }
                 var areaSegment = 0.0
                 if (listRadiusSide.isNotEmpty() && action) areaSegment = Round.double2(AreaFunc.areaForm(SEGMENT, listRadiusSide))
                 else if (listRadiusSide.isNotEmpty() ) areaSegment = - Round.double2(AreaFunc.areaForm(SEGMENT, listRadiusSide))
                return Point.newArea(Point.newPoint(list) ) + areaSegment

            }
        }
        fun planeAddElementArea(planeWithElement: PlaneWithElement,listAreaSideAdd: List<ElementWithSide>): Double{
            var area = areaPlane(planeWithElement.planeWithSide)
            planeWithElement.listElementWithSide.forEach {
                area += ElementFunc.areaElementActive(it)

            }
            listAreaSideAdd.forEach {
                when (planeWithElement.planeWithSide.plane.type) {
                    WALL -> {
                        area += ElementFunc.areaSideAddWall(it.listSide)
                    }
                    FLOOR -> area += ElementFunc.areaSideAddFloor(it.listSide)
                    CEIL -> area += ElementFunc.areaSideAddCeil(it.listSide)
                }



            }
            return area
        }
    }
}