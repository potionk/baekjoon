package bj30310

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }.sorted()
    println(list.subList(0, 2).sum())
}
