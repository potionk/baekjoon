package bj25893

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        println("$a $b $c")
        when {
            a >= 10 && b >= 10 && c >= 10 -> println("triple-double")
            a >= 10 && b >= 10 || b >= 10 && c >= 10 || a >= 10 && c >= 10 -> println("double-double")
            a >= 10 || b >= 10 || c >= 10 -> println("double")
            else -> println("zilch")
        }
        if (it != n - 1) {
            println()
        }
    }
}
