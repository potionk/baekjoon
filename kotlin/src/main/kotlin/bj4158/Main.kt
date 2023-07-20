package bj4158

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) {
            break
        }
        val set = mutableSetOf<Int>()
        for (i in 0 until n) {
            set.add(br.readLine().toInt())
        }
        var count = 0
        for (i in 0 until m) {
            if (set.contains(br.readLine().toInt())) {
                count++
            }
        }
        bw.write("$count\n")
    }
    bw.close()
}
