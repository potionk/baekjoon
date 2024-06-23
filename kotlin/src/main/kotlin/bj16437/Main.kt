package bj16437

import java.io.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val graph = List(n + 1) { mutableListOf<Int>() }
    val amountMap = mutableMapOf<Int, Long>()
    repeat(n - 1) {
        val (t, a, p) = br.readLine().split(" ")
        val parent = p.toInt()
        val amount = a.toLong()
        if (t == "S") {
            graph[parent].add(it + 2)
            amountMap[it + 2] = amount
        } else {
            graph[parent].add(it + 2)
            amountMap[it + 2] = -amount
        }
    }
    amountMap[1] = 0
    println(dfs(graph, 1, amountMap))
}

fun dfs(graph: List<MutableList<Int>>, node: Int, amountMap: Map<Int, Long>): Long {
    var result = 0L
    for (child in graph[node]) {
        result += dfs(graph, child, amountMap)
    }
    return max(0, result + amountMap.getOrDefault(node, 0))
}
