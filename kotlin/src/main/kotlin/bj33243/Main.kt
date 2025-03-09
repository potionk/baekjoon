package bj33243

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val tree = mutableMapOf<String, MutableList<String>>()
    val root = br.readLine()
    repeat(n - 1) {
        val (parent, child) = br.readLine().split(" - ")
        val children = tree.getOrPut(parent) { mutableListOf() }
        children.add(child)
    }
    val depthMap = mutableMapOf<Int, MutableList<String>>()
    fun dfs(node: String, depth: Int) {
        val list = depthMap.getOrPut(depth) { mutableListOf() }
        list.add(node)
        val children = tree[node] ?: return
        children.forEach { dfs(it, depth + 1) }
    }
    dfs(root, 0)
    println(depthMap.values.maxOf { it.size })
}
