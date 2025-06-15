package bj6243

import java.io.*
import kotlin.math.max
import kotlin.math.roundToInt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        var input = br.readLine()
        if (input == "#") return
        var totalMileage = 0
        while (true) {
            val (start, end, distance, classCode) = input.split(" ")
            when (classCode) {
                "F" -> totalMileage += distance.toInt() * 2
                "B" -> totalMileage += (distance.toDouble() * 1.5).roundToInt()
                "Y" -> totalMileage += max(500, distance.toInt())
            }
            input = br.readLine()
            if (input == "0") {
                break
            }
        }
        println(totalMileage)
    }
}
