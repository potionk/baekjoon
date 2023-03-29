package bj10811

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = IntArray(n) { it + 1 }
    for (i in 0 until m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until (b - a + 1) / 2) {
            val temp = arr[a - 1 + j]
            arr[a - 1 + j] = arr[b - 1 - j]
            arr[b - 1 - j] = temp
        }
    }
    for (i in 0 until n) {
        bw.write("${arr[i]} ")
    }
    br.close()
    bw.close()
}
