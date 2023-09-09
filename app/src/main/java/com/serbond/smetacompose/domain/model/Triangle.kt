package com.serbond.smetacompose.domain.model

import kotlin.math.pow
import kotlin.math.sqrt

data class Triangle (
    val id: Long ,
    val wallId: Long = 0,
    val slabId: Long = 0,
    var type: String = "",
    var typeElement: String = "",
    var area: Double = 0.0,
    var a: Double,
    var b: Double,
    val c: Double
)

class TriangleFunc{
    companion object{
        fun tri1(a: Double, c: Double): Double{
            val b= sqrt(c.pow(2.0) - a.pow(2.0))
            val s= (a*b)/2
            //val p= a+b+c
            return s
        }
        fun tri2(a: Double, b: Double): Double{
            val c= sqrt(a.pow(2.0) + b.pow(2.0))
            val s= (a*b)/2
           // val p= a+b+c
            return s
        }
        fun tri3(a: Double, b: Double, c: Double): Double{
            val p= a+b+c
            val s = sqrt(p / 2 * (p / 2 - a) * (p / 2 - b) * (p / 2 - c))
            return s
        }
    }
}