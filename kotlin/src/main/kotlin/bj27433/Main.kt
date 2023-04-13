package bj27433

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var result = 1L
    for (i in 1..n) {
        result *= i
    }
    println(result)
    br.close()
}
