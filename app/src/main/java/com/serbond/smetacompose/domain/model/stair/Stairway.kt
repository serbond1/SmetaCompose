package com.serbond.smetacompose.domain.model.stair
const val STAIRWAY_1 = "прямая одномаршевая"
const val STAIRWAY_2 = "Двухмаршевая Г— образная лестница с забежными ступенями и поворотом на 90º"
const val STAIRWAY_3 = "Двухмаршевая лестница с забежными ступенями и поворотом на 180º "
const val STAIRWAY_4 = "Двухмаршевая лестница с поворотом на 180º и промежуточной площадкой"
const val STAIRWAY_5 = "Двухмаршевая Г— образная лестница с промежуточной площадкой и поворотом на 90º"
const val STAIRWAY_6 = "Двухмаршевая прямая лестница с промежуточной площадкой"
const val STAIRWAY_7 = "Двухмаршевая прямая лестница с промежуточной площадкой"
const val STAIRWAY_8 = "Трёхмаршевая Т — образная лестница с промежуточной площадкой"
const val STAIRWAY_9 = "Трёхмаршевая П — образная лестница с двумя промежуточными площадками"
const val STAIRWAY_10 = "Круговая одномаршевая лестница"
const val STAIRWAY_11 = "Одномаршевая винтовая лестница с центральным опорным столбом"
const val STAIRWAY_12 = "Пирамидальная лестница"
const val STAIRWAY_13 = "Коническая лестница"
const val STAIRWAY_14 = "Лестница в виде призмы"
data class Stairway( // лестница
    val id: Long,
    val levelId: Long,
    var name: String,
    var type: String, // тип лестницы
    //var stairs: Int,//кол-во ступеней
    //var platform: Int,//кол-во площадок
    //var height: Double, //высота
   // var width: Double,//ширина
    var note: String = ""
)

data class StairwayWithStaircase(
    val stairway: Stairway,
    var listStairCase: List<StairCaseWithStair>
)

data class StairCaseWithStair (
    val stairCase: StairCase,
    var stairList: List<Stair>
){

}
