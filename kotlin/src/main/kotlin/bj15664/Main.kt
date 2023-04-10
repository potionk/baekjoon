package bj15664

import java.io.*
import java.util.*

val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }.sorted().toIntArray()
    val visited = BooleanArray(n)
    for (i in 0 until n) {
        visited[i] = true
        val stack = Stack<Int>()
        stack.push(arr[i])
        dfs(arr, visited, stack, 0, n, m)
        visited[i] = false
    }
    br.close()
    bw.close()
}

fun dfs(arr: IntArray, visited: BooleanArray, stack: Stack<Int>, depth: Int, n: Int, m: Int) {
    when (depth) {
        m -> {
            return
        }
        m - 1 -> {
            stack.forEach { bw.write("$it ") }
            bw.write("\n")
        }
        else -> {
            for (i in 0 until n) {
                if (!visited[i]) {
                    visited[i] = true
                    stack.push(arr[i])
                    dfs(arr, visited, stack, depth + 1, n, m)
                    visited[i] = false
                    stack.pop()
                }
            }
        }
    }
}
