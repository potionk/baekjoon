package bj17599

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val set = br.readLine().split(" ").map { it.toInt() }.toSet()
    println(set.size)
}
