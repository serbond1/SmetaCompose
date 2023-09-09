package com.serbond.smetacompose.domain.func

import kotlin.math.sqrt

class AreaFunc {
    class AreaFunc {
        companion object{
            fun tri1(a: Double, c: Double): List<Double>{
                val b= Math.sqrt(Math.pow(c, 2.0) - Math.pow(a, 2.0))
                val s= (a*b)/2
                val p= a+b+c
                val list= arrayListOf<Double>()
                list.add(s)
                list.add(p)
                return list
            }
            fun tri2(a: Double, b: Double): List<Double>{
                val c= Math.sqrt(Math.pow(a, 2.0) + Math.pow(b, 2.0))
                val s= (a*b)/2
                val p= a+b+c
                val list= arrayListOf<Double>()
                list.add(s)
                list.add(p)
                return list
            }
            fun tri3(a: Double, b: Double, c: Double): List<Double>{
                val p= a+b+c
                val s = sqrt(p / 2 * (p / 2 - a) * (p / 2 - b) * (p / 2 - c))
                val list= arrayListOf<Double>()
                list.add(s)
                list.add(p)
                return list
            }
            fun rect1(a: Double, b: Double): List<Double>{
                val s= a*b
                val p= (a+b)*2
                val list= arrayListOf<Double>()
                list.add(s)
                list.add(p)
                return list
            }
            fun rect2(a: Double, b: Double, c: Double, d: Double): List<Double>{
                val p= a+b+c+d
                val x= Math.pow((Math.pow(b - a, 2.0) + Math.pow(c, 2.0) - Math.pow(d, 2.0)) / (2 * (b - a)), 2.0)
                val s = (a+b)/2*(Math.sqrt(Math.pow(c, 2.0) - x)); // РїР»РѕС‰Р°РґСЊ С‚СЂР°РїРµС†РёРё
                val list= arrayListOf<Double>()
                list.add(s)
                list.add(p)
                return list
            }
            fun rect3(a: Double, b: Double, c: Double, d: Double, d1: Double, d2: Double): List<Double>{
                val p= a+b+c+d
                val x= (p/2-a)*(p/2-b)*(p/2-c)*(p/2-d)
                val y= 1/4*(a*c+b*d+d1*d2)*(a*c+b*d-d1*d2)
                val s= Math.sqrt(x - y)
                val list= arrayListOf<Double>()
                list.add(s)
                list.add(p)
                return list
            }
            fun circ(r: Double): List<Double>{
                val s = Math.PI*Math.pow(r, 2.0)
                val p= 2*r*Math.PI
                val list= arrayListOf<Double>()
                list.add(s)
                list.add(p)
                return list
            }
            fun segment(a: Double, l: Double): List<Double>{
                val uR = segmentRadian(a, l)
                val u = Math.toDegrees(uR)
                val r = l/uR
                val h = r * 2.0 * Math.sin(Math.toRadians(u * 0.25)) * Math.sin(Math.toRadians(u * 0.25))
                val s = (l*r-a*(r-h))/2
                val p = a+l
                val list = arrayListOf<Double>()
                list.add(s)
                list.add(p)
                return list
            }
            fun sector(r: Double, l: Double): List<Double>{
                val s = (r*l)/2
                val p= r*2+l
                val list= arrayListOf<Double>()
                list.add(s)
                list.add(p)
                return list
            }
            fun segmentRadian(a: Double, l: Double): Double {
                var x = 6.29
                while (x > 0.0) {
                    val f = x * a - 2.0 * l * Math.sin(x / 2.0)
                    if (f > -1.0E-4 && f < 1.0E-4) {
                        return x
                    }
                    x -= 1.0E-5
                }
                return 0.0
            }
//            fun areaS(area: Area):Double{
//                var ar = 0.0
//                val a = area.size[0]
//                val b = area.size[1]
//                val c = area.size[2]
//                val d = area.size[3]
//                val d1 = area.size[4]
//                val d2 = area.size[5]
//                when(area.type){
//                    "TRI1" -> ar = tri1(a,c)[0]
//                    "TRI2" -> ar = tri2(a,b)[0]
//                    "TRI3" -> ar = tri3(a,b,c)[0]
//                    "RECT1" -> ar = rect1(a,b)[0]
//                    "RECT2" -> ar = rect2(a,b,c,d)[0]
//                    "RECT3" -> ar = rect3(a,b,c,d,d1,d2)[0]
//                    "CIRC" -> ar = circ(a)[0]
//                    "SEGMENT" -> ar = segment(a,b)[0]
//                    "SECTOR" -> ar = sector(a,b)[0]
//                }
//                return ar
//            }
        }
    }
}