package bj6325

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var programNum = 1
    while (true) {
        val n = br.readLine().trim().toInt()
        if (n == 0) break
        val set = mutableSetOf<String>()
        set.add("a")
        repeat(n) {
            val (a, b) = br.readLine().trim().split(" = ")
            if (set.contains(b)) {
                set.add(a)
            } else {
                if (set.contains(a)) {
                    set.remove(a)
                }
            }
        }
        println("Program #${programNum++}")
        if (set.size == 0) {
            println("none")
        } else {
            println(set.toList().sorted().joinToString(" "))
        }
        println()
    }
}
