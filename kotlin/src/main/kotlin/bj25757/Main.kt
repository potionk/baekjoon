package bj25757

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, type) = br.readLine().split(" ")
    val nInt = n.toInt()
    val set = mutableSetOf<String>()
    repeat(nInt) {
        set.add(br.readLine())
    }
    when (type) {
        "Y" -> println(set.size)
        "F" -> println(set.size / 2)
        "O" -> println(set.size / 3)
    }
}
