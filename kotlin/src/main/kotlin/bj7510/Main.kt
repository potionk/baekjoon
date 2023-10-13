package bj7510

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    for (i in 1..n) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }.sorted()
        println("Scenario #$i:")
        if (a * a + b * b == c * c) {
            println("yes\n")
        } else {
            println("no\n")
        }
    }
}
