package bj28453

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }
    list.forEach { print("${cal(it)} ") }
}

fun cal(n: Int): Int {
    if (n == 300) return 1
    else if (n >= 275) return 2
    else if (n >= 250) return 3
    else return 4
}
