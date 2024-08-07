package bj26350

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (i in 1..n) {
        val list = br.readLine().split(" ").map { it.toInt() }.drop(1)
        // Denominations: 1 5 10 25
        println("Denominations: ${list.joinToString(" ")}")
        var bad = false
        for (j in 1 until list.size) {
            if (list[j - 1] * 2 > list[j]) {
                println("Bad coin denominations!")
                bad = true
                break
            }
        }
        if (!bad) println("Good coin denominations!")
        if (i < n) println()
    }
}
