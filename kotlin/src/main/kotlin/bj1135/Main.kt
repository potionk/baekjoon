package bj1135

import java.io.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val parent = br.readLine().split(" ").map { it.toInt() }
    val childrenMap = mutableMapOf<Int, MutableList<Int>>()
    parent.forEachIndexed { index, value ->
        if (value != -1) {
            childrenMap.computeIfAbsent(value) { mutableListOf() }.add(index)
        }
    }
    println(dfs(childrenMap, 0))

}

fun dfs(childrenMap: Map<Int, List<Int>>, node: Int): Int {
    if (childrenMap[node] == null) {
        return 0
    }
    val children = childrenMap[node]!!.map { dfs(childrenMap, it) + 1 }.sortedDescending()
    var result = 0
    for (i in children.indices) {
        result = max(result, children[i] + i)
    }
    return result
}
