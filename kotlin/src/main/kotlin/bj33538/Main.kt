package bj33538

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val l = br.readLine().toInt()
    val n = br.readLine().toInt()
    val t = br.readLine().toDouble()
    var hasHope = false
    repeat(n) {
        val (f, b) = br.readLine().split(" ").map { it.toDouble() }
        val time = l / f + l / b
        if (time < t) {
            hasHope = true
        }
    }
    println(if (hasHope) "HOPE" else "DOOMED")
}
