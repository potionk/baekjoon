package bj11322

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val n = br.readLine().toInt()
        println(bfs(n))
    }
}

fun bfs(n: Int): Long {
    val queue = LinkedList<Pair<Long, Int>>()
    val visited = BooleanArray(n) { false }

    queue.add(Pair(1, 1 % n))
    visited[1 % n] = true

    while (queue.isNotEmpty()) {
        val current = queue.poll()

        if (current.second == 0) {
            return current.first
        }

        val next1 = Pair(current.first * 10, (current.second * 10) % n)
        val next2 = Pair(current.first * 10 + 1, (current.second * 10 + 1) % n)

        if (!visited[next1.second]) {
            queue.add(next1)
            visited[next1.second] = true
        }

        if (!visited[next2.second]) {
            queue.add(next2)
            visited[next2.second] = true
        }
    }

    return -1
}
