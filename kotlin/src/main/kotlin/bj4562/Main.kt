package bj4562

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        if (x >= y) {
            println("MMM BRAINS")
        } else {
            println("NO BRAINS")
        }
    }
}
