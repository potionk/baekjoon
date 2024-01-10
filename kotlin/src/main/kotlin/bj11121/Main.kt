package bj11121

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    repeat(br.readLine().toInt()) {
        val (a, b) = br.readLine().split(" ")
        println(if (a == b) "OK" else "ERROR")
    }
}
