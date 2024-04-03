package bj28114

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (p1, y1, s1) = br.readLine().split(" ")
    val (p2, y2, s2) = br.readLine().split(" ")
    val (p3, y3, s3) = br.readLine().split(" ")
    println(
        listOf(y1.toInt() % 100, y2.toInt() % 100, y3.toInt() % 100).sorted().joinToString("")
    )
    val list = listOf(Pair(p1.toInt(), s1), Pair(p2.toInt(), s2), Pair(p3.toInt(), s3)).sortedBy { it.first }.reversed()
    println("${list[0].second.first()}${list[1].second.first()}${list[2].second.first()}")
}
