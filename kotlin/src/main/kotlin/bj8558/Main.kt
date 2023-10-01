package bj8558

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var result = 1
    for (i in 2..n) {
        result *= i
        result %= 10
    }
    println(result)
}
