package bj16212

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    println(br.readLine().split(" ").map { it.toInt() }.sorted().joinToString(" "))
    br.close()
}
