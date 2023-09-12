package bj5354

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        printJBox(br.readLine().toInt())
    }
}

fun printJBox(n: Int) {
    if (n == 1) {
        println("#")
        println()
        return
    }
    println("#".repeat(n))
    for (i in 1 until n - 1) {
        println("#" + "J".repeat(n - 2) + "#")
    }
    println("#".repeat(n))
    println()
}
