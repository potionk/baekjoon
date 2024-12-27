package bj14235

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val pq = PriorityQueue<Int>(compareBy { -it })
    for (i in 0 until n) {
        val list = br.readLine().trim().split(" ").map { it.toInt() }
        if (list[0] == 0) {
            if (pq.isEmpty()) {
                println(-1)
            } else {
                println(pq.poll())
            }
        } else {
            for (j in 1 until list.size) {
                pq.add(list[j])
            }
        }
    }
}
