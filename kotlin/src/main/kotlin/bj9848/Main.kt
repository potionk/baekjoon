package bj9848

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    var before = br.readLine().toInt()
    var count = 0
    repeat(n - 1) {
        val now = br.readLine().toInt()
        if (before - now >= k) {
            count++
        }
        before = now
    }
    println(count)
}
