package bj18691

import java.io.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val (g, c, e) = br.readLine().split(" ").map { it.toInt() }
        val kmPerCandy = when (g) {
            1 -> 1
            2 -> 3
            3 -> 5
            else -> 0
        }
        println((max((e - c), 0)) * kmPerCandy)
    }
}
