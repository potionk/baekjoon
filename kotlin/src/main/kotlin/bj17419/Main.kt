package bj17419

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val length = br.readLine().toInt()
    val binaryK = br.readLine()
    val count = binaryK.count { it == '1' }
    println(count)
}
