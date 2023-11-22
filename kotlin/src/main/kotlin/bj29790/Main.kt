package bj29790

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, u, l) = br.readLine().split(" ").map { it.toInt() }
    println(if (n < 1000) "Bad" else if (u < 8000 && l < 260) "Good" else "Very Good")
    br.close()
}
