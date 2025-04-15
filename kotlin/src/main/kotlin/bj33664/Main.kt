package bj33664

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (b, n, m) = br.readLine().split(" ").map { it.toLong() }
    val priceMap = mutableMapOf<String, Long>()
    repeat(n.toInt()) {
        val (name, price) = br.readLine().split(" ")
        priceMap[name] = price.toLong()
    }

    var totalPrice = 0L
    repeat(m.toInt()) {
        val itemName = br.readLine()
        totalPrice += priceMap[itemName] ?: 0L
    }

    println(if (totalPrice <= b) "acceptable" else "unacceptable")
}
