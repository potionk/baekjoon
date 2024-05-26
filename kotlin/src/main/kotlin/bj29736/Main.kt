package bj29736

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    val (k, x) = br.readLine().split(" ").map { it.toInt() }
    val friendable = (a..b).count { abs(it - k) <= x }
    if(friendable > 0) println(friendable)
    else println("IMPOSSIBLE")
}
