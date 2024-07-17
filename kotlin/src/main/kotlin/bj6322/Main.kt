package bj6322

import java.io.*
import kotlin.math.roundToInt
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (a, b, c) = br.readLine().split(" ").map { it.toDouble() }
    var count = 1
    while (a != 0.0 || b != 0.0 || c != 0.0) {
        println("Triangle #$count")
        if (a == -1.0) {
            if (c * c - b * b <= 0) {
                print("Impossible.")
            } else {
                print("a = ${sqrtWithThreeDecimalPlaces(c * c - b * b)}")
            }
        } else if (b == -1.0) {
            if (c * c - a * a <= 0) {
                print("Impossible.")
            } else {
                print("b = ${sqrtWithThreeDecimalPlaces(c * c - a * a)}")
            }
        } else {
            print("c = ${sqrtWithThreeDecimalPlaces(a * a + b * b)}")
        }
        count++
        val (a1, b1, c1) = br.readLine().split(" ").map { it.toDouble() }
        a = a1
        b = b1
        c = c1
        if (a != 0.0 || b != 0.0 || c != 0.0) {
            println("\n")
        }
    }
}

fun sqrtWithThreeDecimalPlaces(x: Double): String {
    return String.format("%.3f", (sqrt(x) * 1000).roundToInt() / 1000.0)
}
