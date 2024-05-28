package bj21152

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val map = mutableMapOf<String, String>()
    val n = br.readLine().toInt()
    repeat(n) {
        val (name, haas, wants) = br.readLine().split(" ")
        map[haas] = wants
    }
    var max = 0
    val visited = mutableSetOf<String>()
    for (haas in map.keys) {
        if (haas in visited) continue
        val result = dfs(haas, map, visited, 0)
        if (result != -1) {
            max = maxOf(max, result)
            visited.addAll(visited)
        }
    }
    if (max == 0) println("No trades possible")
    else println(max)
}

fun dfs(haas: String, map: Map<String, String>, visited: MutableSet<String>, count: Int): Int {
    if (haas !in map) return -1
    if (haas in visited) return count
    visited.add(haas)
    return dfs(map[haas]!!, map, visited, count + 1)
}
