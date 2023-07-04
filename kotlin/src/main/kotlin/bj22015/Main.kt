package bj22015

import java.io.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
    println("${max(max(a, b), c) * 3 - (a + b + c)}")
    br.close()
}
