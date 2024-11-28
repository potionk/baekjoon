package bj26876

import java.io.*

val nextMin = listOf(1, 60)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine().trim().split(":").map { it.toInt() }
    val aMin = a[0] * 60 + a[1]
    val b = br.readLine().trim().split(":").map { it.toInt() }
    val bMin = b[0] * 60 + b[1]
    println(bfs(aMin, bMin))
}

fun bfs(a: Int, b: Int): Int {
    val queue = mutableListOf(a)
    val visited = mutableSetOf(a)
    var count = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        repeat(size) {
            val current = queue.removeFirst()
            if (current == b) {
                return count
            }
            for (i in nextMin) {
                var next = current + i
                if (next >= 1440) {
                    next -= 1440
                }
                if (next !in visited) {
                    visited.add(next)
                    queue.add(next)
                }
            }
        }
        count++
    }
    return -1
}
