package bj27239

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val rank = (n - 1) / 8 + 1
    val fileIndex = (n - 1) % 8
    val fileChar = 'a' + fileIndex
    println("$fileChar$rank")
}
