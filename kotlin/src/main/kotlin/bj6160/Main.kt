package bj6160

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().trim().split(" ").map { it.toInt() }
    val list = mutableListOf<Triple<Int, Int, Int>>()
    for (i in 1..n) {
        val (a, b) = br.readLine().trim().split(" ").map { it.toInt() }
        list.add(Triple(a, b, i))
    }
    println(list.sortedBy { it.first }.reversed().dropLast(n - k).maxByOrNull { it.second }!!.third)
}
