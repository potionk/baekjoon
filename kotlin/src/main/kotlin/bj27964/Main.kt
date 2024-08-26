package bj27964

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val set = mutableSetOf<String>()
    val list = br.readLine().split(" ")
    list.forEach {
        if (it.endsWith("Cheese")) {
            set.add(it)
        }
    }
    if (set.size >= 4) {
        println("yummy")
    } else {
        println("sad")
    }
}
