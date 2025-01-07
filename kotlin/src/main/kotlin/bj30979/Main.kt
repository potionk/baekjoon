package bj30979

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val n = br.readLine().toInt()
    val f = br.readLine().split(" ").map { it.toInt() }
    if (f.sum() >= t) {
        println("Padaeng_i Happy")
    } else {
        println("Padaeng_i Cry")
    }
}
