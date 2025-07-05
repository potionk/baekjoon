package bj5778

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val (n, m) = br.readLine().trim().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) break
        val tickets = br.readLine().trim().split(" ").map { it.toInt() }
        val ticketMap = mutableMapOf<Int, Int>()
        for (ticket in tickets) {
            ticketMap[ticket] = ticketMap.getOrDefault(ticket, 0) + 1
        }
        var duplicates = 0
        for ((_, count) in ticketMap) {
            if (count > 1) {
                duplicates++
            }
        }
        println(duplicates)
    }
}
