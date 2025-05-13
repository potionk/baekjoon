package bj32279

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val (p, q, r, s) = br.readLine().split(" ").map { it.toInt() }
    val a1 = br.readLine().toInt()
    val a = IntArray(n + 1)
    a[1] = a1
    for (i in 1 until n) {
        if (i * 2 <= n) {
            a[i * 2] = p * a[i] + q
        }
        if (i * 2 + 1 <= n) {
            a[i * 2 + 1] = r * a[i] + s
        }
    }
    var sum = 0
    for (i in 1..n) {
        sum += a[i]
    }
    println(sum)
}