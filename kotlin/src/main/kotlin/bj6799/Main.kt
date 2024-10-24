package bj6799

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = mutableListOf<Pair<String, Int>>()
    repeat(n) {
        val (str, ram, cpu, disk) = br.readLine().split(" ")
        list.add(Pair(str, ram.toInt() * 2+ cpu.toInt() *3 + disk.toInt()))
    }
    list.sortedWith(compareBy({ -1 * it.second }, { it.first })).take(2).forEach {
        println(it.first)
    }
}
