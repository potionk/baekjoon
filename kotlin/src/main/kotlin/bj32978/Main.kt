package bj32978

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val requireList = br.readLine().split(" ").toSet()
    val list = br.readLine().split(" ").toSet()
    println(requireList.minus(list).toList()[0])
}
