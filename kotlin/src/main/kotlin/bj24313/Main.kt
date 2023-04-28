package bj24313

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a1, a2) = br.readLine().split(" ").map { it.toInt() }
    val c = br.readLine().toInt()
    val n0 = br.readLine().toInt()
    if (a1 <= c && a2 <= (c - a1) * n0) {
        println("1")
    } else {
        println("0")
    }
    br.close()
}
