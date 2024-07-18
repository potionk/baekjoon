package bj9776

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var max = 0.0
    repeat(n) {
        val inputs = br.readLine().split(" ")
        max = when (inputs[0]) {
            "S" -> {
                val r = inputs[1].toDouble()
                val v = (4.0 / 3.0) * Math.PI * r * r * r
                maxOf(max, v)
            }

            "C" -> {
                val r = inputs[1].toDouble()
                val h = inputs[2].toDouble()
                val v = Math.PI * r * r * h
                maxOf(max, v)
            }

            else -> {
                val r = inputs[1].toDouble()
                val h = inputs[2].toDouble()
                val v = (1.0 / 3.0) * Math.PI * r * r * h
                maxOf(max, v)
            }
        }
    }
    println(String.format("%.3f", max))
}
