package bj13023

import java.io.*
import kotlin.system.exitProcess

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val friendship = Array(m) { mutableListOf<Int>() }
    repeat(n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        friendship[a].add(b)
        friendship[b].add(a)
    }
    val visited = BooleanArray(m)
    for (i in 0 until m) {
        dfs(friendship, visited, i, 0)
    }
    println(0)
}

fun dfs(friendship: Array<MutableList<Int>>, visited: BooleanArray, vertex: Int, depth: Int) {
    if (depth == 4) {
        println(1)
        exitProcess(0)
    }
    visited[vertex] = true
    for (i in friendship[vertex]) {
        if (!visited[i]) {
            dfs(friendship, visited, i, depth + 1)
        }
    }
    visited[vertex] = false
}
