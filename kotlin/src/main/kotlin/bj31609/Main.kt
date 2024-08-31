package bj31609

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val set = mutableSetOf<Int>()
    br.readLine().split(" ").map { it.toInt() }.forEach { set.add(it) }
    set.toList().sorted().forEach { println(it) }
}
