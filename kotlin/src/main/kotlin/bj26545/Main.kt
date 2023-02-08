package bj26545

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var total = 0
    for (i in 0 until n) {
        total += br.readLine().toInt()
    }
    println(total)
    br.close()
}