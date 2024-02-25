package com.serbond.smetacompose.domain.func

import com.serbond.smetacompose.domain.model.INNER
import com.serbond.smetacompose.domain.model.Side
import java.math.BigDecimal
import java.math.RoundingMode

class Point(val x: Double,val y:Double) {
    companion object{
        fun area(list: List<Point>):Double {
            var area = 0.0
//            var sum= 0.0
            for (i in list.indices){
                if (i<list.size-1)
                {
                    val sum = list[i].x*list[i+1].y - list[i].y*list[i+1].x
                    area += sum
                }
            }
            return (area/2)
        }

        fun newArea(list: List<Point>):Double {
            var area = 0.0
//            var sum= 0.0
            for (i in list.indices){
                if (i<list.size-1)
                {
                    val sum = list[i].x*list[i+1].y - list[i].y*list[i+1].x
                    area += sum
                }
            }
            return Round.double2(area/2)
        }

        fun point(list: List<Double>): List<Point>{
            var az= 90
            var x= 0.0
            var y= 0.0
            val listPoint= mutableListOf<Point>(Point(x,y))

            var l= 0
            var t= 1
            var u= 2
            for (i in 1..list.size/3){
                //Log.d("Point","$x , $y , $az")
                //Log.d("Point","$l , $t , $u")
                if (az==0||az==360){
                    x+= 0.0
                    y+= list[l]
                }
                else if (az==90){
                    y+= 0.0
                    x+= list[l]
                }
                else if (az==180){
                    x+= 0.0
                    y-= list[l]
                }
                else if (az==270){
                    x-= list[l]
                    y-= 0.0
                }
                else if (az>0||az<90){
                    x+= list[l]*Math.cos(Math.toRadians((90-az).toDouble()))
                    y+= list[l]*Math.sin(Math.toRadians((90-az).toDouble()))
                }
                else if (az>90||az<180){
                    x+= list[l]*Math.cos(Math.toRadians((az-90).toDouble()))
                    y-= list[l]*Math.sin(Math.toRadians((az-90).toDouble()))
                }
                else if (az>180||az<270){
                    x-= list[l]*Math.cos(Math.toRadians((270-az).toDouble()))
                    y-= list[l]*Math.sin(Math.toRadians((270-az).toDouble()))
                }
                else if (az>270||az<360){
                    x-= list[l]*Math.cos(Math.toRadians((az-270).toDouble()))
                    y+= list[l]*Math.sin(Math.toRadians((az-270).toDouble()))
                }

                listPoint.add(Point(x,y))

                //Toast.makeText(this.requireContext(), "${x} + $y", Toast.LENGTH_LONG).show()
                if (list[t]==0.0){
                    az-= 180-list[u].toInt()
                }
                else az+= 180-list[u].toInt()

                if (az<0) az+= 360
                if (az>360) az-= 360
                //Log.d("Point","$x , $y , $az")
                l+= 3
                t+= 3
                u+= 3
            }
            listPoint.removeAt(list.size/3)
            return listPoint
        }

        fun areaSlab(list: List<Double>):Double{
            //Log.d("Point","${area(point(list))}")
            return Round.double2(area(point(list)))
        }

//        fun listL(list: List<WallWithWindowsAndArea>): List<Double>{ // лист длинн стен для пола,потолка
//            val listL= mutableListOf<Double>()
//            list.forEach {
//                listL.add(it.wall.length)
//            }
//            return listL
//        }

        fun maxSize(list: List<Point>): List<Double>{ // макс.длина по осям x, y
            var xMax= 0.0
            var yMax= 0.0
            var xMin= 0.0
            var yMin= 0.0
            val listSize= arrayListOf<Double>()
            for (i in list){
                if (i.x > xMax) xMax= i.x
                if (i.x < xMin) xMin= i.x
                if (i.y > yMax) yMax= i.y
                if (i.y < yMin) yMin= i.y
            }
            val x= xMax - xMin
            val y= yMax - yMin
            listSize.add(x)
            listSize.add(y)
//            if (x > y) return x
//            else return y
            return listSize
        }
        fun newPoint(list: List<Side>): List<Point> {
            var az= 90
            var x= 0.0
            var y= 0.0
            val listPoint= mutableListOf(Point(x,y))
            list.forEach {
                if (!it.radius){
                if (az==0||az==360){
                    x+= 0.0
                    y+= it.length
                }
                else if (az==90){
                    y+= 0.0
                    x+= it.length
                }
                else if (az==180){
                    x+= 0.0
                    y-= it.length
                }
                else if (az==270){
                    x-= it.length
                    y-= 0.0
                }
                else if (az>0||az<90){
                    x+= it.length*Math.cos(Math.toRadians((90-az).toDouble()))
                    y+= it.length*Math.sin(Math.toRadians((90-az).toDouble()))
                }
                else if (az>90||az<180){
                    x+= it.length*Math.cos(Math.toRadians((az-90).toDouble()))
                    y-= it.length*Math.sin(Math.toRadians((az-90).toDouble()))
                }
                else if (az>180||az<270){
                    x-= it.length*Math.cos(Math.toRadians((270-az).toDouble()))
                    y-= it.length*Math.sin(Math.toRadians((270-az).toDouble()))
                }
                else if (az>270||az<360){
                    x-= it.length*Math.cos(Math.toRadians((az-270).toDouble()))
                    y+= it.length*Math.sin(Math.toRadians((az-270).toDouble()))
                }

                listPoint.add(Point(x,y))

                if (it.cornerType == INNER){
                    az-= 180-it.corner
                }
                else az+= 180-it.corner

                if (az<0) az+= 360
                if (az>360) az-= 360
            }}
            return listPoint
        }
    }
}
class Round {
    companion object{
        fun double2(d: Double): Double =
            BigDecimal.valueOf(d).setScale(2,RoundingMode.HALF_DOWN).toDouble()//setScale(2, BigDecimal.ROUND_HALF_DOWN).toDouble()
    }
}