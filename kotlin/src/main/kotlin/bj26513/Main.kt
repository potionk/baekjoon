package bj26513

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        if (n == 0 && k == 0) break
        var maxSafe = 1
        var maxBroken = k
        repeat(n) {
            val (floor, status) = br.readLine().split(" ")
            if (status == "SAFE") {
                maxSafe = maxOf(maxSafe, floor.toInt())
            } else {
                maxBroken = minOf(maxBroken, floor.toInt())
            }
        }
        println("${maxSafe + 1} ${maxBroken - 1}")
    }
}