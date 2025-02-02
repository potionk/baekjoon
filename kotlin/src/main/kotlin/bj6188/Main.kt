package bj6188

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, c) = br.readLine().split(" ").map { it.toInt() }
    val graph = mutableMapOf<Int, MutableList<Int>>()
    repeat(c) {
        val (root, child1, child2) = br.readLine().split(" ").map { it.toInt() }
        val list = graph[root] ?: mutableListOf()
        list.add(child1)
        list.add(child2)
        graph[root] = list
    }
    val depthMap = mutableMapOf<Int, Int>()
    fun dfs(node: Int, depth: Int) {
        depthMap[node] = depth
        graph[node]?.forEach {
            dfs(it, depth + 1)
        }
    }
    dfs(1, 1)
    for (i in 1..n) {
        println("${depthMap[i]}")
    }
}
