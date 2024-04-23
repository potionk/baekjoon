package bj31614

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println(br.readLine().toInt() * 60 + br.readLine().toInt())
}
