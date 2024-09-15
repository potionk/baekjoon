package bj31280

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = br.readLine().split(" ").map { it.toInt() }
    println(list.sum() - list.min() + 1)
}
