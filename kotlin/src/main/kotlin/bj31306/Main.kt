package bj31306

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    val vowels = listOf('a', 'e', 'i', 'o', 'u')
    val vowelsWithY = vowels + 'y'
    println("${str.count { it in vowels }} ${str.count { it in vowelsWithY }}")
}
