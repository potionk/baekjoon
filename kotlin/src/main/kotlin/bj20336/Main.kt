package bj20336

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n - 1) {
        br.readLine()
    }
    println(br.readLine().split(" ").joinToString("\n"))
}
