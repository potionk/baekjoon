package bj27323

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println(br.readLine().toInt() * br.readLine().toInt())
    br.close()
}