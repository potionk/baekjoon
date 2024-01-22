package bj18243

import java.io.*
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val matrix = mutableMapOf<String, MutableSet<String>>()
    repeat(k) {
        val (a, b) = br.readLine().split(" ")
        matrix.getOrPut(a) { mutableSetOf() }.add(b)
        matrix.getOrPut(b) { mutableSetOf() }.add(a)
    }
    var result = true
    for (i in 1..n) {
        if (!bfs(matrix, n, i.toString())) {
            result = false
            break
        }
    }
    if (result) {
        println("Small World!")
    } else {
        println("Big World!")
    }
}

fun bfs(matrix: Map<String, Set<String>>, n: Int, people: String): Boolean {
    val queue = LinkedList<String>()
    val visited = mutableSetOf<String>()
    queue.add(people)
    visited.add(people)
    var count = 0
    while (queue.isNotEmpty()) {
        if (count > 6) {
            return false
        }
        val size = queue.size
        for (i in 0 until size) {
            val current = queue.poll()
            if (matrix[current] != null) {
                for (next in matrix[current]!!) {
                    if (next !in visited) {
                        queue.add(next)
                        visited.add(next)
                    }
                }
            }
        }
        count++
    }
    return visited.size == n
}
