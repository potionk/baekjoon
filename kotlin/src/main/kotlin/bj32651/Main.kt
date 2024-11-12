package bj32651

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    if (n <= 100000 && n % 2024 == 0) {
        println("Yes")
    } else {
        println("No")
    }
}
