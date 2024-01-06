package bj11581

import java.io.BufferedReader
import java.io.InputStreamReader

var cycle = false

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().trim().toInt()
    val visited = BooleanArray(n + 1) { false }
    val adj = Array(n + 1) { mutableListOf<Int>() }
    for (i in 1 until n) {
        val m = br.readLine().trim().toInt()
        val next = br.readLine().trim().split(" ")
        for(j in 0 until m){
            adj[i].add(next[j].toInt())
        }
    }
    dfs(visited, adj, 1)
    if (cycle) {
        println("CYCLE")
    } else {
        println("NO CYCLE")
    }
}

fun dfs(
    visited: BooleanArray,
    adj: Array<MutableList<Int>>,
    v: Int,
) {
    visited[v] = true
    for (i in adj[v]) {
        if (!visited[i]) {
            dfs(visited, adj, i)
        } else {
            cycle = true
            return
        }
    }
    visited[v] = false
}
