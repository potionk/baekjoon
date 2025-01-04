package bj23544

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val set = mutableSetOf<String>()
    for (i in 0 until n) {
        set.add(br.readLine())
    }
    println(n - set.size)
}
