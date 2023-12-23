package bj9780

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()
    repeat(t) {
        br.readLine()
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val list = br.readLine().split(" ").map { it.toLong() }
        val cumulativeSum = LongArray(n + 1)
        for (i in 1..n) {
            cumulativeSum[i] = cumulativeSum[i - 1] + list[i - 1]
        }
        for (i in 0 until m) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            bw.write("${cumulativeSum[b + 1] - cumulativeSum[a]}\n")
        }
        bw.write("\n")
    }
    bw.close()
}
