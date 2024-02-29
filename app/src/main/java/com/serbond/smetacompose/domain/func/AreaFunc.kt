package com.serbond.smetacompose.domain.func

import com.serbond.smetacompose.domain.model.BLOCK
import com.serbond.smetacompose.domain.model.Side
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

const val TRI1: String = "tri1"
const val TRI2: String = "tri2"
const val TRI3: String = "tri3"
const val RECT1: String = "rect1"
const val RECT2: String = "rect2"
const val RECT3: String = "rect3"
const val CIRCLE: String = "circ"
const val SEGMENT: String = "segment"
const val SECTOR: String = "sector"
const val NORECT: String = "многоугольник"

class AreaFunc {
        companion object{
            fun areaForm (form: String, l: List<Side>): Double{
                when (form) {
                    TRI1 -> {
                        val a = l[0].length // катет 1
                        val c = l[1].length // гипотенуза
                        val b = sqrt(c.pow(2.0) - a.pow(2.0)) // катет 2
                        return (a * b) / 2
                    }
                    TRI2 -> {
                        val a = l[0].length // катет 1
                        val b = l[1].length // катет 2
                        return (a * b) / 2
                    }
                    TRI3 -> {
                        val a = l[0].length
                        val b = l[1].length
                        val c = l[2].length
                        val p = a + b + c
                        return sqrt(p / 2 * (p / 2 - a) * (p / 2 - b) * (p / 2 - c))
                    }
                    RECT1 -> {
                        val a = l[0].length
                        val b = l[1].length
                        return a * b
                    }
                    RECT2 -> {
                        val a = l[0].length
                        val b = l[1].length
                        val c = l[2].length
                        val d = l[3].length
                        val x= (((b - a).pow(2.0) + c.pow(2.0) - d.pow(2.0)) / (2 * (b - a))).pow(2.0)
                        return (a+b)/2*(sqrt(c.pow(2.0) - x))
                    }
                    RECT3 -> {
                        val a = l[0].length
                        val b = l[1].length
                        val c = l[2].length
                        val d = l[3].length
                        val d1 = l[4].length
                        val d2 = l[5].length
                        val p= a+b+c+d
                        val x= (p/2-a)*(p/2-b)*(p/2-c)*(p/2-d)
                        val y= 1/4*(a*c+b*d+d1*d2)*(a*c+b*d-d1*d2)
                        return sqrt(x - y)
                    }
                    CIRCLE -> {
                        val r = l[0].length // радиус
                        return Math.PI* r.pow(2.0)
                    }
                    SEGMENT -> {
                        val a = l[0].length // хорда
                        val d = l[1].length // длина дуги
                        val uR = segmentRadian(a, d)
                        val u = Math.toDegrees(uR)
                        val r = d/uR
                        val h = r * 2.0 * sin(Math.toRadians(u * 0.25)) * sin(Math.toRadians(u * 0.25))
                        return (d*r-a*(r-h))/2
                    }
                    SECTOR -> {
                        val r = l[0].length // радиус
                        val d = l[1].length // длина дуги
                        return (r*d)/2
                    }
                    BLOCK -> {
                        val a = l[0].length // ширина блока
                        val b = l[1].length // высота блока
                        val c = l[3].length // высота до подоконника
                        val d = l[4].length // ширина окна
                        return (a*b)-(c*d)
                    }
                    NORECT -> {
                        return Point.newArea(Point.newPoint(l))
                    }

                }

                return 0.0
            }
//            fun tri1(a: Double, c: Double): List<Double>{
//                val b= Math.sqrt(Math.pow(c, 2.0) - Math.pow(a, 2.0))
//                val s= (a*b)/2
//                val p= a+b+c
//                val list= arrayListOf<Double>()
//                list.add(s)
//                list.add(p)
//                return list
//            }
//            fun tri2(a: Double, b: Double): List<Double>{
//                val c= Math.sqrt(Math.pow(a, 2.0) + Math.pow(b, 2.0))
//                val s= (a*b)/2
//                val p= a+b+c
//                val list= arrayListOf<Double>()
//                list.add(s)
//                list.add(p)
//                return list
//            }
//            fun tri3(a: Double, b: Double, c: Double): List<Double>{
//                val p= a+b+c
//                val s = sqrt(p / 2 * (p / 2 - a) * (p / 2 - b) * (p / 2 - c))
//                val list= arrayListOf<Double>()
//                list.add(s)
//                list.add(p)
//                return list
//            }
//            fun rect1(a: Double, b: Double): List<Double>{
//                val s= a*b
//                val p= (a+b)*2
//                val list= arrayListOf<Double>()
//                list.add(s)
//                list.add(p)
//                return list
//            }
//            fun rect2(a: Double, b: Double, c: Double, d: Double): List<Double>{
//                val p= a+b+c+d
//                val x= Math.pow((Math.pow(b - a, 2.0) + Math.pow(c, 2.0) - Math.pow(d, 2.0)) / (2 * (b - a)), 2.0)
//                val s = (a+b)/2*(Math.sqrt(Math.pow(c, 2.0) - x)); // РїР»РѕС‰Р°РґСЊ С‚СЂР°РїРµС†РёРё
//                val list= arrayListOf<Double>()
//                list.add(s)
//                list.add(p)
//                return list
//            }
//            fun rect3(a: Double, b: Double, c: Double, d: Double, d1: Double, d2: Double): List<Double>{
//                val p= a+b+c+d
//                val x= (p/2-a)*(p/2-b)*(p/2-c)*(p/2-d)
//                val y= 1/4*(a*c+b*d+d1*d2)*(a*c+b*d-d1*d2)
//                val s= Math.sqrt(x - y)
//                val list= arrayListOf<Double>()
//                list.add(s)
//                list.add(p)
//                return list
//            }
//            fun circ(r: Double): List<Double>{
//                val s = Math.PI*Math.pow(r, 2.0)
//                val p= 2*r*Math.PI
//                val list= arrayListOf<Double>()
//                list.add(s)
//                list.add(p)
//                return list
//            }
//            fun segment(a: Double, l: Double): List<Double>{
//                val uR = segmentRadian(a, l)
//                val u = Math.toDegrees(uR)
//                val r = l/uR
//                val h = r * 2.0 * Math.sin(Math.toRadians(u * 0.25)) * Math.sin(Math.toRadians(u * 0.25))
//                val s = (l*r-a*(r-h))/2
//                val p = a+l
//                val list = arrayListOf<Double>()
//                list.add(s)
//                list.add(p)
//                return list
//            }
//            fun sector(r: Double, l: Double): List<Double>{
//                val s = (r*l)/2
//                val p= r*2+l
//                val list= arrayListOf<Double>()
//                list.add(s)
//                list.add(p)
//                return list
//            }
            private fun segmentRadian(a: Double, l: Double): Double {
                var x = 6.29
                while (x > 0.0) {
                    val f = x * a - 2.0 * l * sin(x / 2.0)
                    if (f > -1.0E-4 && f < 1.0E-4) {
                        return x
                    }
                    x -= 1.0E-5
                }
                return 0.0
            }

        }
}