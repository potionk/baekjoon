package bj32775

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sab = br.readLine().toInt()
    val fab = br.readLine().toInt()
    println(if (sab > fab) "flight" else "high speed rail")
}
