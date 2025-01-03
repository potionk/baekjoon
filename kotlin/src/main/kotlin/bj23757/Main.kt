package bj23757

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val pq = PriorityQueue<Int>(reverseOrder())
    val arr = br.readLine().split(" ").map { it.toInt() }
    for (i in 0 until n) {
        pq.add(arr[i])
    }
    val child = br.readLine().split(" ").map { it.toInt() }
    child.forEach {
        if (pq.isNotEmpty() && pq.peek() >= it) {
            val poll = pq.poll()
            if (poll > it) {
                pq.add(poll - it)
            }
        } else {
            println("0")
            return
        }
    }
    println(1)
}
