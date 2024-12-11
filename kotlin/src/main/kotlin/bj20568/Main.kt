package bj20568

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().trim().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }.sorted()
    var count = 0
    for (i in 0 until n - 1) {
        if (list[i] >= list[i + 1]) {
            count++
        }
    }
    println(count)
}
