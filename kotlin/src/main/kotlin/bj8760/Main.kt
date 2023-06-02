package bj8760

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val (w, h) = br.readLine().split(" ").map { it.toInt() }
        bw.write("${((w * h) / 2)}\n")
    }
    br.close()
    bw.close()
}
