package bj27310

import java.io.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    println((str.length + str.filter { it == ':' }.length + str.filter { it == '_' }.length * 5))
}
