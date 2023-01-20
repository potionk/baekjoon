package bj5237

import java.io.*

var internetMap: MutableMap<Int, MutableList<Int>> = mutableMapOf()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val readLine = br.readLine().trim().split(" ").map { it.toInt() }
        internetMap = mutableMapOf()
        internetMap[0] = mutableListOf()
        val isVisited = BooleanArray(readLine[0])
        for (j in 2 until readLine.size step 2) {
            val c1 = readLine[j]
            val c2 = readLine[j + 1]
            connect(c1, c2)
            connect(c2, c1)
        }
        isVisited[0] = true
        dfs(internetMap[0]!!, isVisited)
        var notConnected = false
        for (j in 0 until readLine[0]) {
            if (!isVisited[j]) {
                notConnected = true
            }
        }
        if (notConnected) {
            bw.write("Not connected.\n")
        } else {
            bw.write("Connected.\n")
        }
    }
    br.close()
    bw.close()
}

private fun connect(c1: Int, c2: Int) {
    var list = internetMap[c1]
    if (list.isNullOrEmpty()) {
        list = mutableListOf(c2)
    } else {
        list.add(c2)
    }
    internetMap[c1] = list
}

fun dfs(next: List<Int>, isVisited: BooleanArray) {
    next.forEach {
        if (!isVisited[it]) {
            isVisited[it] = true
            dfs(internetMap[it]!!, isVisited)
        }
    }
}
