package bj11179

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println(br.readLine().toInt().toString(radix = 2).reversed().toInt(2))
    br.close()
}