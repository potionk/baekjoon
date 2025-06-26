package bj2213

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val weights = br.readLine().split(" ").map { it.toInt() }
    val tree = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        tree[a].add(b)
        tree[b].add(a)
    }

    val visited = BooleanArray(n + 1)
    val dp = Array(n + 1) { IntArray(2) }

    fun dfs(node: Int) {
        visited[node] = true
        dp[node][0] = 0
        dp[node][1] = weights[node - 1]
        for (next in tree[node]) {
            if (!visited[next]) {
                dfs(next)
                dp[node][0] += maxOf(dp[next][0], dp[next][1])
                dp[node][1] += dp[next][0]
            }
        }
    }

    dfs(1)
    println(maxOf(dp[1][0], dp[1][1]))

    val selected = mutableListOf<Int>()
    val traceVisited = BooleanArray(n + 1)

    fun trace(node: Int, isSelected: Boolean) {
        traceVisited[node] = true
        if (isSelected) {
            selected.add(node)
            for (next in tree[node]) {
                if (!traceVisited[next]) {
                    trace(next, false)
                }
            }
        } else {
            for (next in tree[node]) {
                if (!traceVisited[next]) {
                    if (dp[next][1] > dp[next][0]) {
                        trace(next, true)
                    } else {
                        trace(next, false)
                    }
                }
            }
        }
    }

    if (dp[1][1] > dp[1][0]) {
        trace(1, true)
    } else {
        trace(1, false)
    }

    println(selected.sorted().joinToString(" "))
}
