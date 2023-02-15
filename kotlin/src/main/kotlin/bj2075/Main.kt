package bj2075

import java.io.*
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val queue = PriorityQueue<Int>(n)
    for (i in 0 until n) {
        br.readLine().split(" ").map { it.toInt() }.forEach {
            if (i == 0) {
                queue.add(it)
            } else if (queue.peek() < it) {
                queue.poll()
                queue.add(it)
            }
        }
    }
    println(queue.poll())
    br.close()
}
