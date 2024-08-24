package bj21955

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine()
    println("${n.substring(0, n.length / 2)} ${n.substring(n.length / 2, n.length)}")
}
