package bj15971

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, start, end) = br.readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
    repeat(n - 1) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        map.computeIfAbsent(a) { mutableListOf() }.add(Pair(b, c))
        map.computeIfAbsent(b) { mutableListOf() }.add(Pair(a, c))
    }
    map.forEach { (_, v) ->
        v.sortBy { it.second }
    }
    println(bfs(map, start, end))
}

fun bfs(map: Map<Int, List<Pair<Int, Int>>>, start: Int, end: Int): Int {
    val visited = mutableSetOf<Int>()
    val queue = mutableListOf<Triple<Int, Int, Int>>()
    queue.add(Triple(start, 0, 0))
    while (queue.isNotEmpty()) {
        val (current, distance, max) = queue.removeAt(0)
        if (current == end) {
            return distance - max
        }
        visited.add(current)
        map[current]?.forEach {
            if (it.first !in visited) {
                queue.add(Triple(it.first, distance + it.second, maxOf(max, it.second)))
            }
        }
    }
    return -1
}
