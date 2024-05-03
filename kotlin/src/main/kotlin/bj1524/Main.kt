package bj1524

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        br.readLine()
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val a = br.readLine().split(" ").map { it.toInt() }.sorted().toMutableList()
        val b = br.readLine().split(" ").map { it.toInt() }.sorted().toMutableList()
        while (a.isNotEmpty() && b.isNotEmpty()) {
            if (a.first() < b.first()) a.removeFirst()
            else b.removeFirst()
        }
        println(if (a.isNotEmpty()) "S" else if (b.isNotEmpty()) "B" else "C")
    }
}
