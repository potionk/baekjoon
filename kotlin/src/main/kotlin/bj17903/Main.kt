package bj17903

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    println(if (m >= 8) "satisfactory" else "unsatisfactory")
}
