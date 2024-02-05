package bj15624

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var a = 0L
    var b = 1L
    repeat(n) {
        val c = (a + b) % 1_000_000_007
        a = b
        b = c
    }
    println(a)
}
