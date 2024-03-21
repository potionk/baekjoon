package bj17202

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine().map { it - '0' }
    val b = br.readLine().map { it - '0' }
    val list = mutableListOf<Int>()
    for (i in 0..7) {
        list.add(a[i])
        list.add(b[i])
    }
    while (list.size > 2) {
        val newList = mutableListOf<Int>()
        for (i in 0 until list.size - 1) {
            newList.add((list[i] + list[i + 1]) % 10)
        }
        list.clear()
        list.addAll(newList)
    }
    println(list.joinToString(""))
}
