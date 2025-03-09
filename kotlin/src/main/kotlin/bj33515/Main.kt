package bj33515

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (t1, t2) = br.readLine().split(" ").map { it.toInt() }
    println(Math.min(t1, t2))
}
