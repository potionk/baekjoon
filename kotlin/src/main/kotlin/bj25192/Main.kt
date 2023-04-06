package bj25192

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var count = 0
    var set = mutableSetOf<String>()
    for (i in 0 until n) {
        val s = br.readLine()
        if (s == "ENTER") {
            count += set.size
            set = mutableSetOf()
        } else {
            set.add(s)
        }
    }
    count += set.size
    println(count)
    br.close()
}
