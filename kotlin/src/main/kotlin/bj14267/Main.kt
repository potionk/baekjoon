package bj14267

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val parentNum = br.readLine().split(" ").map { it.toInt() }
    val graph = mutableMapOf<Int, MutableSet<Int>>()
    val score = mutableMapOf<Int, Int>()
    parentNum.forEachIndexed { index, value ->
        if (index == 0) return@forEachIndexed
        val me = index
        val parent = value - 1
        if (graph[parent] == null) graph[parent] = mutableSetOf()
        graph[parent]!!.add(me)
    }
    repeat(m) {
        val (i, w) = br.readLine().split(" ").map { it.toInt() }
        score[i - 1] = score.getOrDefault(i - 1, 0) + w
    }
    dfs(graph, score, 0, 0)
    for (i in 0 until n) {
        bw.write("${score.getOrDefault(i, 0)} ")
    }
    bw.close()
}

fun dfs(graph: Map<Int, Set<Int>>, scoreMap: MutableMap<Int, Int>, me: Int, score: Int) {
    scoreMap[me] = scoreMap.getOrDefault(me, 0) + score
    if (graph[me] == null) return
    graph[me]!!.forEach {
        dfs(graph, scoreMap, it, scoreMap[me]!!)
    }
}
