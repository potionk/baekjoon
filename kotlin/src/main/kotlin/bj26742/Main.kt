package bj26742

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    val bCount = str.count { it == 'B' }
    println((bCount / 2 + (str.length - bCount) / 2))
}
