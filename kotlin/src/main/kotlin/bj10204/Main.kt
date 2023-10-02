package bj10204

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().trim().toInt()
    repeat(n) {
        val info = br.readLine().trim().split(" ")
        val start = info.last()
        val graph = mutableMapOf<String, MutableSet<String>>()
        for (i in 2 until info.size - 1 step 2) {
            val v1 = info[i]
            val v2 = info[i + 1]
            if (graph[v1] == null) {
                graph[v1] = mutableSetOf()
            }
            if (graph[v2] == null) {
                graph[v2] = mutableSetOf()
            }
            graph[v1]!!.add(v2)
            graph[v2]!!.add(v1)
        }
        bw.write("The number of supervillains in 2-hop neighborhood of $start is ${bfs(graph, start)}\n")
    }
    bw.close()
}

fun bfs(graph: Map<String, Set<String>>, start: String): Int {
    val queue = mutableListOf<String>()
    val visited = mutableSetOf<String>()
    queue.add(start)
    visited.add(start)
    var depth = 0
    var count = 0
    while (queue.isNotEmpty()) {
        if (depth >= 2) {
            break
        }
        val size = queue.size
        for (i in 0 until size) {
            val current = queue.removeFirst()
            if (graph[current] != null) {
                for (next in graph[current]!!) {
                    if (next !in visited) {
                        queue.add(next)
                        visited.add(next)
                        count++
                    }
                }
            }
        }
        depth++
    }
    return count
}
