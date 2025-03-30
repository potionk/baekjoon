package bj16503

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (k1, o1, k2, o2, k3) = br.readLine().split(" ")
    val result1 = calculate(calculate(k1.toInt(), o1, k2.toInt()), o2, k3.toInt())
    val result2 = calculate(k1.toInt(), o1, calculate(k2.toInt(), o2, k3.toInt()))
    println("${minOf(result1, result2)}\n${maxOf(result1, result2)}")
}

fun calculate(k1: Int, operator: String, k2: Int): Int {
    return when (operator) {
        "+" -> k1 + k2
        "-" -> k1 - k2
        "*" -> k1 * k2
        "/" -> k1 / k2
        else -> throw IllegalArgumentException()
    }
}
