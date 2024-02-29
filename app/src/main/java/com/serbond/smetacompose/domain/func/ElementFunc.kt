package com.serbond.smetacompose.domain.func

import com.serbond.smetacompose.domain.model.ElementWithSide
import com.serbond.smetacompose.domain.model.Side
import com.serbond.smetacompose.domain.model.side_element.SideElement

class ElementFunc {
    companion object{
        fun areaElement(e: ElementWithSide): Double{
            val list = mutableListOf<Side>()
            e.listSide.forEach {
                list.add(it.side)
            }
            return Round.double2(AreaFunc.areaForm(e.element.form,list))
        }
        fun areaElementActive(e: ElementWithSide): Double{
            return if (e.element.active) {
                if (e.element.action) Round.double2(areaElement(e)) else -Round.double2(areaElement(e))
            } else 0.0
        }
        fun lengthSideElementRadiusActive(listSide: List<SideElement>): Double{
            var length = 0.0
            listSide.forEach {
                if (it.active && it.side.radius) {
                    length += it.side.length
                }
            }
            return Round.double2(length)
        }
        fun lengthSideElementActive(listSide: List<SideElement>): Double{
            var length = 0.0
            listSide.forEach {
                if (it.active) length += it.side.length
            }
            return Round.double2(length)
        }
        fun areaSideElementActive(listSide: List<SideElement>): Double{
            var area = 0.0
            listSide.forEach {
                if (it.active ) area += it.side.length * it.width
            }
            return Round.double2(area)
        }
        fun areaSideElementRadiusActive(listSide: List<SideElement>): Double{
            var area = 0.0
            listSide.forEach {
                if (it.active && it.side.radius) area += it.side.length * it.width
            }
            return Round.double2(area)
        }
        fun areaSideAddFloor(listSide: List<SideElement>): Double{
            var area = 0.0
            listSide.forEach {
                if (it.setting.areaFloorAdd) area += it.side.length * it.width
                if (it.setting.areaFloorRemove) area -= it.side.length * it.width
            }
            return Round.double2(area)
        }
        fun areaSideAddCeil(listSide: List<SideElement>): Double{
            var area = 0.0
            listSide.forEach {
                if (it.setting.areaCellAdd) area += it.side.length * it.width
                if (it.setting.areaCellRemove) area -= it.side.length * it.width
            }
            return Round.double2(area)
        }
        fun areaSideAddWall(listSide: List<SideElement>): Double{
            var area = 0.0
            listSide.forEach {
                if (it.setting.areaWallAdd) area += it.side.length * it.width
                if (it.setting.areaWallRemove) area -= it.side.length * it.width
            }
            return Round.double2(area)
        }
        fun perimeterAddCeil(listSide: List<SideElement>): Double{
            var length = 0.0
            listSide.forEach {
                if (it.setting.perimeterCellAdd == 1) length += it.width
                if (it.setting.perimeterCellAdd == 2) length += it.width * 2
                if (it.setting.perimeterCellRemove) length -= it.side.length
            }
            return Round.double2(length)
        }
        fun perimeterAddFloor(listSide: List<SideElement>): Double{
            var length = 0.0
            listSide.forEach {
                if (it.setting.perimeterFloorAdd == 1) length += it.width
                if (it.setting.perimeterFloorAdd == 2) length += it.width * 2
                if (it.setting.perimeterFloorRemove) length -= it.side.length
            }
            return Round.double2(length)
        }
    }
}