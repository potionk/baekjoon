package bj1417

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val votes = mutableListOf<Int>()
    for (i in 0 until n) {
        votes.add(br.readLine().toInt())
    }
    var me = votes.removeAt(0)
    val priorityQueue = PriorityQueue<Int>(Collections.reverseOrder())
    priorityQueue.addAll(votes)
    var result = 0
    while (priorityQueue.isNotEmpty()) {
        val max = priorityQueue.poll()
        if (me > max) {
            break
        }
        priorityQueue.add(max - 1)
        result++
        me++
    }
    println(result)
}
