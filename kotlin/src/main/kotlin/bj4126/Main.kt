package bj4126

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, Set<String>>()
    repeat(n) {
        val (firstName, lastName, course) = br.readLine().split(" ")
        map[course] = map.getOrDefault(course, setOf()) + "$firstName $lastName"
    }
    map.toList().sortedByDescending { it.second.size }.sortedBy { it.first }.forEach {
        println("${it.first} ${it.second.size}")
    }
}
