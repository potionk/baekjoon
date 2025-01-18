package bj13771

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = List(n) { br.readLine().toDouble() }.sorted()
    println("%.2f".format(list[1]))
}
