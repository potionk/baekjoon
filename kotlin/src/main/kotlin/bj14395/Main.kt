package bj14395

import java.io.*
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (s, t) = br.readLine().split(" ").map { it.toLong() }
    println(bfs(s, t))
}

fun bfs(s: Long, t: Long): String {
    val visited = mutableSetOf<Long>()
    if (s == t) return "0"
    else if (t == 1L) return "/"
    else if (t == 0L) return "-"
    val q = LinkedList<Pair<Long, String>>()
    q.add(Pair(s, ""))
    var first = false
    while (q.isNotEmpty()) {
        val poll = q.poll()
        val num = poll.first
        if (visited.contains(num)) continue
        visited.add(num)
        val op = poll.second
        if (num == t) {
            return op
        }
        if (num * num <= t) {
            q.add(Pair(num * num, "$op*"))
        }
        if (num + num <= t) {
            q.add(Pair(num + num, "$op+"))
        }
        if (!first) {
            q.add(Pair(1, "/"))
            first = true
        }
    }
    return "-1"
}
