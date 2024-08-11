package bj29986

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, h) = br.readLine().split(" ").map { it.toInt() }
    println(br.readLine().split(" ").map { it.toInt() }.count { it <= h })
}
