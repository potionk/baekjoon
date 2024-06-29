package bj31636

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val str = br.readLine()
    if (str.contains("ooo")) {
        println("Yes")
    } else {
        println("No")
    }
}
