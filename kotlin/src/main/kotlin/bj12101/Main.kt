package bj12101

import java.io.*

val num = listOf(1, 2, 3)
var count = 0
var result = ""

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    dfs(n, k, 0, mutableListOf())
    println(result.ifEmpty { -1 })
}

fun dfs(n: Int, k: Int, total: Int, path: MutableList<Int>) {
    if (total == n) {
        count++
        if (count == k) {
            result = path.joinToString("+")
        }
        return
    }
    if (total < n) {
        for (i in num) {
            path.add(i)
            dfs(n, k, total + i, path)
            path.removeLast()
        }
    }
}
