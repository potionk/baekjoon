package bj15340

import java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val (c, d) = br.readLine().split(" ").map { it.toInt() }
        if (c == 0 && d == 0) {
            break
        }
        val a = c * 30 + d * 40
        val b = c * 35 + d * 30
        val e = c * 40 + d * 20
        println(min(min(a, b), e))
    }
}
