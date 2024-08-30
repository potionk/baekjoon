package bj6752

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val c = br.readLine().toInt()
    val list = Array(c) { br.readLine().toInt() }.sorted()
    var count = 0
    var sum = 0
    list.forEach {
        if (it + sum <= t) {
            sum += it
            count++
        } else {
            return@forEach
        }
    }
    println(count)
}
