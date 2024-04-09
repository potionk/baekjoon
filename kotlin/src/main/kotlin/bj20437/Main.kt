package bj20437

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val w = br.readLine()
        val k = br.readLine().toInt()
        val charToIndices = mutableMapOf<Char, MutableList<Int>>()
        w.forEachIndexed { index, c ->
            charToIndices.computeIfAbsent(c) { mutableListOf() }.add(index)
        }
        val result = charToIndices
            .filter { it.value.size >= k }
            .map { it.value.windowed(size = k, step = 1) }
            .flatten()
            .map { it.last() - it.first() + 1 }
        if (result.isEmpty()) {
            println("-1")
        } else {
            println("${result.minOrNull()} ${result.maxOrNull()}")
        }
    }
}
