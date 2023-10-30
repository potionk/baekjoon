package bj26146

import java.io.*
import java.util.*

var dfsOrder = 1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (v, e) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(v + 1) { mutableListOf<Int>() }
    val d = IntArray(v + 1)
    val isFinished = BooleanArray(v + 1)
    val stack = Stack<Int>()
    val result = LinkedList<LinkedList<Int>>()

    for (i in 0 until e) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
    }

    for (i in 1..v) {
        if (d[i] == 0) {
            dfs(i, graph, d, stack, isFinished, result)
        }
    }

    println(if (result.size == 1) "Yes" else "No")
}

fun dfs(
    curVertex: Int,
    graph: Array<MutableList<Int>>,
    d: IntArray,
    stack: Stack<Int>,
    isFinished: BooleanArray,
    result: LinkedList<LinkedList<Int>>
): Int {
    stack.push(curVertex)
    d[curVertex] = dfsOrder++
    var parent = d[curVertex]

    for (next in graph[curVertex]) {
        parent = when {
            d[next] == 0 -> minOf(parent, dfs(next, graph, d, stack, isFinished, result))
            !isFinished[next] -> minOf(parent, d[next])
            else -> parent
        }
    }

    if (parent == d[curVertex]) {
        val list = LinkedList<Int>()
        while (true) {
            val p = stack.pop()
            list.add(p)
            isFinished[p] = true
            if (curVertex == p) break
        }
        result.add(list)
    }
    return parent
}
