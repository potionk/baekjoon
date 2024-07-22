package bj21194

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val list = mutableListOf<Int>()
    for (i in 0 until n) {
        list.add(br.readLine().toInt())
    }
    list.sort()
    println(list.subList(n - k, n).sum())
}
