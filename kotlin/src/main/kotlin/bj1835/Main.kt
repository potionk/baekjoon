package bj1835

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var n = br.readLine().toInt()

    val queue = ArrayDeque<Int>()
    while (n > 0) {
        queue.addFirst(n)
        for (i in 0 until n) {
            queue.addFirst(queue.removeLast())
        }
        n--
    }
    queue.forEach {
        bw.write("$it ")
    }
    bw.flush()
    br.close()
    bw.close()
}
