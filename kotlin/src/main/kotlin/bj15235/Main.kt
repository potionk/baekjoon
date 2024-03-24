package bj15235

import java.io.*
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    val result = IntArray(n)
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    for (i in 0 until n) {
        queue.add(Pair(i, arr[i]))
    }
    var time = 1
    while (queue.isNotEmpty()) {
        val (index, value) = queue.poll()
        if (value > 0) {
            result[index] = time
            queue.add(Pair(index, value - 1))
            time++
        }
    }
    println(result.joinToString(" "))
}
