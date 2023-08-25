package bj26884

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val set = mutableSetOf<String>()
    val check = mutableSetOf<String>()
    var count = 0
    for (i in 1..n) {
        val a = br.readLine()
        if (set.contains(a)) {
            if (check.contains(a)) {
                continue
            }
            count++
            check.add(a)
        } else {
            set.add(a)
        }
    }
    println(count)
}
