package bj30007

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    repeat(n) {
        val (a, b, x) = br.readLine().split(" ").map { it.toInt() }
        bw.write("${(a * (x - 1) + b)}\n")
    }
    bw.close()
}
