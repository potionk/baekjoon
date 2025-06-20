package bj4573

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var testNum = 1
    while (true) {
        val input = br.readLine() ?: break
        if (input == "0") break
        val n = input.toInt()
        var bestDiameter = 0
        var bestCost = Double.MAX_VALUE
        for (i in 0 until n) {
            val (diameter, price) = br.readLine().split(" ").map { it.toInt() }
            val cost = price.toDouble() / (Math.PI * (diameter / 2.0) * (diameter / 2.0))
            if (cost < bestCost) {
                bestCost = cost
                bestDiameter = diameter
            }
        }
        println("Menu $testNum: $bestDiameter")
        testNum++
    }
}
