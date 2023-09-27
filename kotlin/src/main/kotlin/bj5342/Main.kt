package bj5342

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val map = mapOf(
        "Paper" to 57.99,
        "Printer" to 120.50,
        "Planners" to 31.25,
        "Binders" to 22.50,
        "Calendar" to 10.95,
        "Notebooks" to 11.20,
        "Ink" to 66.95
    )
    var result = 0.0
    while (true) {
        val input = br.readLine()
        if (input == "EOI") {
            break
        }
        result += map[input]!!
    }
    println("$$result")
}
