package bj31616

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val set = mutableSetOf<Char>()
    br.readLine()
    br.readLine().toCharArray().forEach { set.add(it) }
    if (set.size == 1) {
        println("Yes")
    } else {
        println("No")
    }
}
