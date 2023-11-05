package bj23895

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()
    for (i in 1..t) {
        var (n, b) = br.readLine().split(" ").map { it.toInt() }
        val priorityQueue = PriorityQueue<Int>()
        br.readLine().split(" ").map { it.toInt() }.forEach(priorityQueue::add)
        var count = 0
        while (priorityQueue.isNotEmpty() && b >= priorityQueue.peek()) {
            b -= priorityQueue.poll()
            count++
        }
        bw.write("Case #$i: $count\n")
    }
    bw.close()
}
