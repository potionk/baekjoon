package bj30067

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = mutableListOf<Int>()
    repeat(10) {
        list.add(br.readLine().toInt())
    }
    val sum = list.sum()
    for (i in 0 until 10) {
        if (sum - list[i] == list[i]) {
            println(list[i])
            break
        }
    }
}
