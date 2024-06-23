package bj31612

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    val str = br.readLine()
    println(str.length + str.count { it == 'j' } + str.count { it == 'i' })
}
