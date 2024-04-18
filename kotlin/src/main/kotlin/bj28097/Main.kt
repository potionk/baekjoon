package bj28097

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val time = br.readLine().split(" ").map { it.toInt() }
    val total = time.sum() + 8 * (n - 1)
    println("${total / 24} ${total % 24}")
}
