package bj28279

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val deque: Deque<Int> = ArrayDeque()

    for (i in 0 until n) {
        val command = br.readLine().split(" ")
        when (command[0]) {
            "1" -> deque.addFirst(command[1].toInt())
            "2" -> deque.addLast(command[1].toInt())
            "3" -> bw.write("${if (deque.isNotEmpty()) deque.pollFirst() else -1}\n")
            "4" -> bw.write("${if (deque.isNotEmpty()) deque.pollLast() else -1}\n")
            "5" -> bw.write("${deque.size}\n")
            "6" -> bw.write("${if (deque.isEmpty()) 1 else 0}\n")
            "7" -> bw.write("${if (deque.isNotEmpty()) deque.peekFirst() else -1}\n")
            "8" -> bw.write("${if (deque.isNotEmpty()) deque.peekLast() else -1}\n")
        }
    }
    bw.close()
}
