package bj32929

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println("UOS"[(br.readLine().toInt() - 1) % 3])
}
