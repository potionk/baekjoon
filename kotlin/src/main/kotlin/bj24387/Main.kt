package bj24387

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b, c) = br.readLine().split(" ").map { it.toLong() }.sorted()
    val (d, e, f) = br.readLine().split(" ").map { it.toLong() }.sorted()
    println(f * c + e * b + d * a)
}
