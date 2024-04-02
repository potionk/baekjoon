package bj9723

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    repeat(n) {
        val (a, b, c) = br.readLine().split(" ").map { it.toLong() }.sorted()
        bw.write("Case #${it + 1}: ${if (a * a + b * b == c * c) "YES" else "NO"}\n")
    }
    bw.close()
}
