package bj11346

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        br.readLine()
        br.readLine()
        val set = mutableSetOf<String>()
        set.addAll(br.readLine().split(" "))
        set.addAll(br.readLine().split(" "))
        println(set.size)
    }
}
