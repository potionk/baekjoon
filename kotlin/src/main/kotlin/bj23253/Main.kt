package bj23253

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    for (i in 0 until n) {
        br.readLine()
        val books = br.readLine().split(" ").map { it.toInt() }
        var before = books[0]
        for (j in 1 until books.size) {
            if (books[j] > before) {
                println("No")
                return
            }
            before = books[j]
        }
    }
    println("Yes")
}
