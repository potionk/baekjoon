package bj11256

import java.io.*
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val (j, n) = br.readLine().split(" ").map { it.toInt() }
        val pq = PriorityQueue<Int>(compareByDescending { it })
        for (k in 0 until n) {
            val (r, c) = br.readLine().split(" ").map { it.toInt() }
            pq.add(r * c)
        }
        var sum = 0
        var count = 0
        while (sum < j) {
            sum += pq.poll()
            count++
        }
        bw.write("$count\n")
    }
    br.close()
    bw.close()
}
