package bj33541

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val x = br.readLine().toInt()
    var year = x + 1
    while (year <= 9999) {
        val sum = year / 100 + year % 100
        if (sum * sum == year) {
            println(year)
            return
        }
        year++
    }
    println(-1)
}
