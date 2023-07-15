package bj16061

import java.io.*
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, d, k) = br.readLine().split(" ").map { it.toInt() }
    val pq = PriorityQueue<Pair<String, Int>>(compareBy { -1 * it.second })
    for (i in 0 until n) {
        val (s, c) = br.readLine().split(" ")
        pq.add(Pair(s, c.toInt()))
    }
    var sum = 0
    val result = mutableListOf<String>()
    for (i in 0 until k) {
        val (s, c) = pq.poll()
        if (sum < d) {
            sum += c
            result.add(s)
        } else {
            break
        }
    }
    if (sum < d) {
        bw.write("impossible")
    } else {
        bw.write("${result.size}\n")
        for (i in result) {
            bw.write("$i, YOU ARE FIRED!\n")
        }
    }
    br.close()
    bw.close()
}
