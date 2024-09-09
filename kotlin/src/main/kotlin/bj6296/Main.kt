package bj6296

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, nc) = br.readLine().split(" ").map { it.toInt() }
    val set = mutableSetOf<String>()
    val text = br.readLine()
    for (i in 0 until text.length - n + 1) {
        set.add(text.substring(i, i + n))
    }
    println(set.size)
}
