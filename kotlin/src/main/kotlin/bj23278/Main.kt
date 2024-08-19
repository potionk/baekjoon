package bj23278

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, l, h) = br.readLine().split(" ").map { it.toInt() }
    val scores = br.readLine().split(" ").map { it.toInt() }
    println(scores.sorted().drop(l).dropLast(h).average())
}
