package com.serbond.smetacompose.domain.func

import com.serbond.smetacompose.domain.model.INNER
import com.serbond.smetacompose.domain.model.OUTER
import com.serbond.smetacompose.domain.model.PlaneWithSide
import com.serbond.smetacompose.domain.model.Side

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
    }
}