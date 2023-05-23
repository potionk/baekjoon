package bj26942

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val students = mutableListOf<String>()
    for (i in 0 until n) {
        students.add(br.readLine())
    }
    val m = br.readLine().toInt()
    val map = mutableMapOf<String, MutableList<String>>()
    for (i in 0 until m) {
        val group = br.readLine().split(" ")
        if (map[group[0]] == null) {
            map[group[0]] = mutableListOf()
        }
        map[group[0]]!!.add(group[1])
        if (map[group[1]] == null) {
            map[group[1]] = mutableListOf()
        }
        map[group[1]]!!.add(group[0])
    }
    val isVisited = mutableSetOf<String>()
    var result = 0
    students.forEach {
        if (!isVisited.contains(it)) {
            dfs(map, isVisited, it)
            result++
        }
    }
    bw.write("$result")
    br.close()
    bw.close()
}

fun dfs(map: MutableMap<String, MutableList<String>>, isVisited: MutableSet<String>, start: String) {
    isVisited.add(start)
    if (map[start] != null) {
        map[start]!!.forEach {
            if (!isVisited.contains(it)) {
                dfs(map, isVisited, it)
            }
        }
    }
}
