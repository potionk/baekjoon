package bj25644

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    val prices = br.readLine().split(" ").map { it.toInt() }

    var minPrice = Int.MAX_VALUE
    var maxProfit = 0

    for (price in prices) {
        minPrice = minOf(minPrice, price)
        maxProfit = maxOf(maxProfit, price - minPrice)
    }

    println(maxProfit)
}
