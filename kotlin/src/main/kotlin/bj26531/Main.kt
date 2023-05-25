package bj26531

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (a, b, c) = br.readLine().replace("+", "=").split(" = ").map { it.toInt() }
    println(if (a + b == c) "YES" else "NO")
    br.close()
    bw.close()
}
