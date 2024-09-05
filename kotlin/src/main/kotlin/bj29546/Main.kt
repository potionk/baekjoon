package bj29546

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = mutableListOf<String>()
    repeat(n) {
        list.add(br.readLine())
    }
    val m = br.readLine().toInt()
    repeat(m) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() - 1 }
        println(list.subList(start, end + 1).joinToString("\n"))
    }
}
