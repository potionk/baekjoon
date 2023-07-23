package bj14912

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, d) = br.readLine().split(" ").map { it.toInt() }
    println(calc(n, d.toString()[0]))
}

fun calc(n: Int, d: Char): Int {
    var result = 0
    for (i in 1..n) {
        val str = i.toString()
        for (j in str.indices) {
            if (str[j] == d) {
                result++
            }
        }
    }
    return result
}
