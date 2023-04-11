package bj25418

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, k) = br.readLine().split(" ").map { it.toInt() }
    println(bfs(a, k))
    br.close()
}

fun bfs(a: Int, k: Int): Int {
    val queue = LinkedList<Int>()
    val isVisited = BooleanArray(1000001)
    queue.add(a)
    var count = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val current = queue.poll()
            if (current == k) {
                return count
            }
            if (current * 2 <= k && !isVisited[current * 2]) {
                isVisited[current * 2] = true
                queue.add(current * 2)
            }
            if (current + 1 <= k && !isVisited[current + 1]) {
                isVisited[current + 1] = true
                queue.add(current + 1)
            }
        }
        count++
    }
    return -1
}


