package bj26561

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()
    for (i in 0 until n) {
        val (p, t) = reader.readLine().split(" ").map { it.toInt() }
        val births = t / 4
        val deaths = t / 7
        println(p + births - deaths)
    }
}
