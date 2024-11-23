package bj29881

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, String>()
    for (i in 0 until n) {
        val (a, b) = br.readLine().split(" ")
        map[a] = b
    }
    for (i in 0 until n) {
        val (a, b) = br.readLine().split(" ")
        println("${map[a]} ${b}")
    }
}
