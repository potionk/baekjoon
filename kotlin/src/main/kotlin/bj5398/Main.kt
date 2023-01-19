package bj5398

import java.io.*

val cowConnected: MutableMap<Int, MutableList<Int>> = mutableMapOf()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val nm = br.readLine().split(" ").map { it.toInt() }
    cowConnected[1] = mutableListOf()
    val isVisited = BooleanArray(nm[0] + 1)
    for (i in 0 until nm[1]) {
        val c1c2 = br.readLine().split(" ").map { it.toInt() }
        val c1 = c1c2[0]
        val c2 = c1c2[1]
        connect(c1, c2)
        connect(c2, c1)
    }
    isVisited[1] = true
    dfs(cowConnected[1]!!, isVisited)
    var error = false
    for (i in 1..nm[0]) {
        if (!isVisited[i]) {
            bw.write("${i}\n")
            error = true
        }
    }
    if (!error) {
        bw.write("0")
    }
    br.close()
    bw.close()
}

private fun connect(c1: Int, c2: Int) {
    var list = cowConnected[c1]
    if (list.isNullOrEmpty()) {
        list = mutableListOf(c2)
    } else {
        list.add(c2)
    }
    cowConnected[c1] = list
}

fun dfs(next: List<Int>, isVisited: BooleanArray) {
    next.forEach {
        if (!isVisited[it]) {
            isVisited[it] = true
            dfs(cowConnected[it]!!, isVisited)
        }
    }
}
