package bj13900

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val numberList = br.readLine().split(" ").map { it.toInt() }
    val total = numberList.sum().toLong()
    var result: Long = 0
    numberList.forEach {
        result += it * (total - it)
    }
    println(result / 2)
    br.close()
}
