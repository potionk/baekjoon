package bj31607

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val pq = PriorityQueue<Int>()
    repeat(3) {
        pq.add(br.readLine().toInt())
    }
    if (pq.poll() + pq.poll() == pq.poll()) print("1") else print("0")
}
