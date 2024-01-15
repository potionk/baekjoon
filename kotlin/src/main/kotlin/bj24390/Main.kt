package bj24390

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, s) = br.readLine().split(":").map { it.toInt() }
    val totalSec = m * 60 + s
    println(bfs(totalSec))
}

fun bfs(totalSec: Int): Int {
    val queue: Queue<Int> = LinkedList()
    queue.add(30)
    var count = 1
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val current = queue.poll()
            if (current == totalSec) {
                return count
            }
            if (current + 600 <= totalSec) queue.add(current + 600)
            else if (current + 60 <= totalSec) queue.add(current + 60)
            else if (current + 30 <= totalSec) queue.add(current + 30)
            else if (current + 10 <= totalSec) queue.add(current + 10)
            if (count == 1) {
                queue.add(10)
                queue.add(60)
                queue.add(600)
            }
        }
        count++
    }
    return -1
}
