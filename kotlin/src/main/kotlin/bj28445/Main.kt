package bj28445

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val set = mutableSetOf<String>()
    repeat(2) {
        val (a, b) = br.readLine().split(" ")
        set.add(a)
        set.add(b)
    }
    val list = set.toList().sorted()
    for (element in list) {
        for (element2 in list) {
            println("$element $element2")
        }
    }
}
