package bj25828

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (g, p, t) = br.readLine().split(" ").map { it.toInt() }
    val individualTest = g * p
    val groupTest = g + t * p
    println(
        when {
            individualTest < groupTest -> 1
            individualTest > groupTest -> 2
            else -> 0
        }
    )
}
