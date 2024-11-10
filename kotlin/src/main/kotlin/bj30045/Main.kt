package bj30045

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var count = 0
    repeat(n) {
        val str = br.readLine()
        if (str.contains("01") || str.contains("OI")) {
            count++
        }
    }
    println(count)
}
