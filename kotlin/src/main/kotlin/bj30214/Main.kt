package bj30214

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toDouble() }
    println(if (n / m >= 0.5) "E" else "H")
}
