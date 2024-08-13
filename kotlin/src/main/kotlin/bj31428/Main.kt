package bj31428

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val friends = br.readLine().split(" ")
    val me = br.readLine()
    println(friends.count { me == it })
}
