package bj26150

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine()
    val tripleList = mutableListOf<Triple<String, Int, Int>>()
    repeat(n.toInt()) {
        val (name, a, b) = br.readLine().split(" ")
        tripleList.add(Triple(name, a.toInt(), b.toInt()))
    }
    tripleList.sortBy { it.second }
    println(String(tripleList.map { it.first[it.third - 1].uppercaseChar() }.toCharArray()))
}
