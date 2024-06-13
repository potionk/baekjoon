package bj31261

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    // (x/a-a)/a-a=b
    println((((a + b) * a + a) * a))
}
