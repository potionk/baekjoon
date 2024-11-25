package bj17204

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val graph = mutableMapOf<Int, Int>()
    for (i in 0 until n) {
        val a = br.readLine().toInt()
        graph[i] = a
    }
    var result = -1
    fun dfs(start: Int, visited: MutableSet<Int>, count: Int = 0) {
        if (visited.contains(start) || result != -1) {
            return
        }
        if (start == k) {
            result = count
            return
        }
        visited.add(start)
        dfs(graph[start]!!, visited, count + 1)
    }
    dfs(0, mutableSetOf())
    println(result)
}
