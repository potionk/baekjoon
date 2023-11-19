package bj27541

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    val input = br.readLine()
    println(if (input.last() == 'G') input.dropLast(1) else "${input}G")
}
