package bj1326

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    val steppingStone = br.readLine().trim().split(" ").map { it.toInt() }
    val (start, end) = br.readLine().trim().split(" ").map { it.toInt() - 1 }
    println(bfs(start, end, steppingStone))
    br.close()
}

fun bfs(start: Int, end: Int, steppingStone: List<Int>): Int {
    val queue = LinkedList<Int>()
    queue.add(start)
    val visited = BooleanArray(steppingStone.size) { false }
    visited[start] = true
    var count = 0
    var finished = false
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (s in 0 until size) {
            val current = queue.poll()
            if (current == end) {
                finished = true
                break
            }
            for (i in current + steppingStone[current] until steppingStone.size step steppingStone[current]) {
                if (!visited[i]) {
                    queue.add(i)
                    visited[i] = true
                }
            }
            for (i in current - steppingStone[current] downTo 0 step steppingStone[current]) {
                if (!visited[i]) {
                    queue.add(i)
                    visited[i] = true
                }
            }
        }
        if (finished) break
        count++
    }
    return if (finished) count else -1
}
