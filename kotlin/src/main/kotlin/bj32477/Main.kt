package bj32477

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val friendMap = mutableMapOf<Int, MutableList<Int>>()
    for (i in 0 until m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        friendMap.computeIfAbsent(a) { mutableListOf() }.add(b)
        friendMap.computeIfAbsent(b) { mutableListOf() }.add(a)
    }
    fun dfs(node: Int, visited: MutableSet<Int>): Int {
        if (visited.contains(node)) return 0
        visited.add(node)
        var count = 1
        for (friend in friendMap[node] ?: emptyList()) {
            count += dfs(friend, visited)
        }
        return count
    }

    var max = 0
    val visited = mutableSetOf<Int>()
    for (i in 1..n) {
        if (!visited.contains(i)) {
            val count = dfs(i, visited)
            if (count > max) {
                max = count
            }
        }
    }
    println(max)
}
