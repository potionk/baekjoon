package bj32314

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine().toInt()
    val (w, v) = br.readLine().split(" ").map { it.toInt() }
    if (a <= w / v) println("1")
    else println("0")
}
