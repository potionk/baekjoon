package bj11109

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val (d, n, s, p) = br.readLine().split(" ").map { it.toInt() }
        val parallelTime = d + n * p
        val notParallelTime = n * s
        if (parallelTime < notParallelTime) {
            bw.write("parallelize\n")
        } else if (parallelTime > notParallelTime) {
            bw.write("do not parallelize\n")
        } else {
            bw.write("does not matter\n")
        }
    }
    br.close()
    bw.close()
}
