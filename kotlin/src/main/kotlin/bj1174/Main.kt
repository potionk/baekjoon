package bj1174

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = mutableListOf<Long>()
    if (n < 10) {
        println(n - 1)
        return
    }
    for (i in 0 until 10) {
        dfs(i, i.toLong(), list)
    }
    list.sort()
    if (n > list.size) {
        println(-1)
    } else {
        println(list[n - 1])
    }
}

fun dfs(start: Int, n: Long, list: MutableList<Long>) {
    list.add(n)
    for (i in start - 1 downTo 0) {
        dfs(i, n * 10 + i, list)
    }
}
