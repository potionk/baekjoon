package bj15577

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val pq = PriorityQueue<Double>()
    repeat(n) {
        pq.add(br.readLine().toDouble())
    }
    repeat(n - 1) {
        val a = pq.poll()
        val b = pq.poll()
        pq.add((a + b) / 2)
    }
    println(pq.poll())
}
