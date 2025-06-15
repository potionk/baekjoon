package bj6246

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, q) = br.readLine().split(" ").map { it.toInt() }
    val array = Array(n) { false }
    repeat(q) {
        val (l, i) = br.readLine().split(" ").map { it.toInt() }
        for (j in l - 1 until n step i) {
            array[j] = true
        }
    }
    println(array.count { !it })
}
