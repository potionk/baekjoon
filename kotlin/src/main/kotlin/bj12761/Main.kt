package bj12761

import java.io.*
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (a, b, n, m) = br.readLine().split(" ").map { it.toInt() }
    println(bfs(a, b, n, m, BooleanArray(100001) { false }))
    br.close()
    bw.close()
}

fun bfs(a: Int, b: Int, n: Int, m: Int, visited: BooleanArray): Int {
    val queue = LinkedList<Int>()
    queue.add(n)
    var count = 0
    val canMove = { x: Int -> x in 0..100000 }

    val next = arrayOf(-1, 1, -a, a, -b, b)
    val next2 = arrayOf(a, b)

    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val current = queue.poll()
            if (current == m) {
                return count
            }
            for (j in 0 until next.size) {
                val nextX = current + next[j]
                if (canMove(nextX) && !visited[nextX]) {
                    visited[nextX] = true
                    queue.add(nextX)
                }
            }
            for (j in 0 until next2.size) {
                val nextX = current * next2[j]
                if (canMove(nextX) && !visited[nextX]) {
                    visited[nextX] = true
                    queue.add(nextX)
                }
            }
        }
        count++
    }
    return -1
}
