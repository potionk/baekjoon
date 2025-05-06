package bj31797

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val queue = PriorityQueue<Pair<Int, Int>> { a, b ->
        a.first - b.first
    }
    for (i in 1..m) {
        val (left, right) = br.readLine().split(" ").map { it.toInt() }
        queue.add(Pair(left, i))
        queue.add(Pair(right, i))
    }
    var next = 10001
    var result = -1
    repeat(n) {
        val (hand, index) = queue.poll()
        queue.add(Pair(next, index))
        next++
        result = index
    }
    println(result)
}
