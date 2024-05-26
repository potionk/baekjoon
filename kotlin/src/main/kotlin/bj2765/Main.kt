package bj2765

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var count = 1
    val pi = 3.1415927
    while (true) {
        val (diameter, rotation, time) = br.readLine().split(" ").map { it.toDouble() }
        if (rotation == 0.0) break
        val distance = diameter * pi * rotation / 5280 / 12
        val speed = distance / (time / 3600)
        println("Trip #$count: ${"%.2f".format(distance)} ${"%.2f".format(speed)}")
        count++
    }
}
