package bj13211

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val set = mutableSetOf<String>()
    for (i in 0 until n) {
        set.add(br.readLine())
    }
    val m = br.readLine().toInt()
    var result = 0
    for (i in 0 until m) {
        if (set.contains(br.readLine())) {
            result++
        }
    }
    println(result)
    br.close()
}
