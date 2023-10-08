package bj8595

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    val word = br.readLine()
    val regex = "\\d+".toRegex()
    println(regex.findAll(word).sumOf { it.value.toLong() })
}
