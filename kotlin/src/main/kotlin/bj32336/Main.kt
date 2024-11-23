package bj32336

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val essential = br.readLine().split(" ").map { it.toInt() }.toSet()
    if (n == 1) {
        println("0\n0")
        return
    }
    val needToVisited = BooleanArray(n)
    val map = mutableMapOf<Int, MutableList<Int>>()
    repeat(n - 1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        map.computeIfAbsent(a) { mutableListOf() }.add(b)
        map.computeIfAbsent(b) { mutableListOf() }.add(a)
    }
    dfs(map, 0, essential, needToVisited, BooleanArray(n))
    val course = mutableListOf<Int>()
    trace(map, 0, needToVisited, BooleanArray(n), course)
    println(course.size - 1)
    println(course.joinToString(" "))
}

fun dfs(
    map: Map<Int, List<Int>>,
    node: Int,
    essential: Set<Int>,
    needToVisited: BooleanArray,
    visited: BooleanArray
): Boolean {
    if (map[node] == null) {
        return false
    }
    visited[node] = true
    var flag = essential.contains(node)
    for (child in map[node]!!) {
        if (visited[child]) {
            continue
        }
        if (dfs(map, child, essential, needToVisited, visited)) {
            flag = true
        }
    }
    if (flag) {
        needToVisited[node] = true
    }
    return flag
}

fun trace(
    map: Map<Int, List<Int>>,
    node: Int,
    needToVisited: BooleanArray,
    visited: BooleanArray,
    course: MutableList<Int>
) {
    if (map[node] == null) {
        return
    }
    course.add(node)
    visited[node] = true
    for (child in map[node]!!) {
        if (visited[child] || !needToVisited[child]) {
            continue
        }
        trace(map, child, needToVisited, visited, course)
        course.add(node)
    }
}
