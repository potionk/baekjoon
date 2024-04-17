package bj15051

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    val c = br.readLine().toInt()
    val case1 = a * 2 + b
    val case2 = a + c
    val case3 = b + c * 2
    println(case1.coerceAtMost(case2).coerceAtMost(case3) * 2)
}
