package bj21354

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, p) = br.readLine().split(" ").map { it.toInt() }
    println(if (a*7 == p*13) "lika" else if (a*7 > p*13) "Axel" else "Petra")
    br.close()
}
