package bj21890

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var count = 0
    for (i in 0 until n) {
        val file = br.readLine()
        if (validate(file)) {
            count++
        }
    }
    println(count)
}

fun validate(file: String): Boolean {
    val split = file.split(".")
    if (split.size != 2) {
        return false
    }
    if (split[0].length > 8 || split[0].isEmpty()) {
        return false
    }
    if (split[1].length > 3 || split[1].isEmpty()) {
        return false
    }
    return true
}
