package bj14218

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val adj = Array(n + 1) { mutableListOf<Int>() }
    for (i in 0 until m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        adj[a].add(b)
        adj[b].add(a)
    }
    val q = br.readLine().toInt()
    repeat(q) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        adj[a].add(b)
        adj[b].add(a)
        val countArray = IntArray(n + 1) { -1 }
        dfs(adj, 1, countArray)
        bw.write("${countArray.drop(1).joinToString(" ")}\n")
    }
    bw.close()
}

fun dfs(
    adj: Array<MutableList<Int>>,
    v: Int,
    countArray: IntArray
) {
    val visited = BooleanArray(adj.size) { false }
    val q = mutableListOf<Int>()
    q.add(v)
    visited[v] = true
    countArray[v] = 0
    while (q.isNotEmpty()) {
        val now = q.removeAt(0)
        for (i in adj[now]) {
            if (!visited[i]) {
                visited[i] = true
                countArray[i] = countArray[now] + 1
                q.add(i)
            }
        }
    }
}
