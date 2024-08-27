package bj26575

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val (a, b, c) = br.readLine().trim().split(" ").map { it.toDouble() }
        val result = a * b * c
        bw.write(String.format("$%.2f\n", result))
    }
    br.close()
    bw.close()
}