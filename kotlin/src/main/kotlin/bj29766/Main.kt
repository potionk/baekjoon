package bj29766

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    val count = str.windowed(4).count { it == "DKSH" }
    println(count)
}
