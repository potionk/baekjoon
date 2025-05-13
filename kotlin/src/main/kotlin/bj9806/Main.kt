package bj9806

import java.io.*
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val k = br.readLine().toInt()
    val potentials = br.readLine().split(" ").map { it.toDouble() }
    var max = 0
    for (p in potentials) {
        val power = p.pow(k).toInt()
        if (power > 0) {
            max += power
        }
    }
    println(max)
}