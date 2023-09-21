package bj21612

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val b = br.readLine().toInt()
    val p = 5 * b - 400
    println(p)
    when {
        p > 100 -> println(-1)
        p < 100 -> println(1)
        else -> println(0)
    }
}
