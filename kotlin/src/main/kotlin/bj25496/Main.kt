package bj25496

import java.io.*

const val MAX = 200

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (p, n) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }.sorted()
    var count = 0
    arr.forEach {
        if (p >= MAX) {
            return@forEach
        }
        p += it
        count++
    }
    println(count)
}
