package bj9713

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val l = br.readLine().toInt()
        val n = l / 2 + 1
        println(n * n)
    }
}
