package bj27971

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, a, b) = br.readLine().split(" ").map { it.toInt() }
    val filterNumber = mutableSetOf<Int>()
    repeat(m) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        for (i in start..end) {
            filterNumber.add(i)
        }
    }
    println(bfs(n, a, b, filterNumber))
}

fun bfs(end: Int, aMagic: Int, bMagic: Int, filterNumber: Set<Int>): Int {
    val queue = ArrayDeque<Int>()
    queue.add(0)
    val visited = mutableSetOf<Int>()
    visited.addAll(filterNumber)
    var count = 0
    val next = listOf(aMagic, bMagic)
    while (queue.isNotEmpty()) {
        val size = queue.size
        repeat(size) {
            val current = queue.removeFirst()
            if (current == end) {
                return count
            }
            for (i in next) {
                val nextNumber = current + i
                if (nextNumber <= end && nextNumber !in visited) {
                    queue.add(nextNumber)
                    visited.add(nextNumber)
                }
            }
        }
        count++
    }
    return -1
}
