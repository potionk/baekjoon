package bj27959

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    if (n * 100 >= m) {
        println("Yes")
    } else {
        println("No")
    }
    br.close()
}
