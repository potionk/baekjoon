package bj30868

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        if (n < 5) println("|".repeat(n))
        else println("${"++++ ".repeat((n / 5))}${"|".repeat(n % 5)}")
    }
}
