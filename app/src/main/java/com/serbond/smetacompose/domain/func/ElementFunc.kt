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
                if (e.element.action) areaElement(e) else -areaElement(e)
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
        fun areaSideAddFloor(){

        }
        fun areaSideAddCeil(){

        }
    }
}