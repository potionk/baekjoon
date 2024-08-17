package bj26530

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tc = br.readLine().toInt()
    repeat(tc) {
        val n = br.readLine().toInt()
        var total = 0.0
        repeat(n) {
            val (str, num, price) = br.readLine().split(" ")
            total += num.toInt() * price.toDouble()
        }
        println(String.format("$%.2f", total))
    }
}
