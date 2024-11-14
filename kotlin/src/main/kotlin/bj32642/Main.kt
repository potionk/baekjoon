package bj32642

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }
    var rage = 0L
    var result = 0L
    for (i in 0 until n) {
        if (list[i] == 1) {
            rage++
        } else {
            rage--
        }
        result += rage
    }
    println(result)
}
