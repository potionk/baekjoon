package bj13237

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val graph = mutableMapOf<Int, List<Int>>()
    var rootIdx = -1
    for (i in 0 until n) {
        val parentIdx = br.readLine().toInt() - 1
        if (parentIdx == -2) {
            rootIdx = i
        } else {
            graph[parentIdx] = graph.getOrDefault(parentIdx, emptyList()) + i
        }
    }
    val depthMap = mutableMapOf<Int, Int>()
    fun dfs(node: Int, depth: Int) {
        depthMap[node] = depth
        graph[node]?.forEach { child ->
            dfs(child, depth + 1)
        }
    }
    dfs(rootIdx, 0)
    for (i in 0 until n) {
        println(depthMap[i] ?: -1)
    }
}
