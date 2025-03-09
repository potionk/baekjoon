package bj33162

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.ceil

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val x = br.readLine().toInt()
    println((ceil(x / 2.0).toInt()) * 3 - (x / 2) * 2)
}
