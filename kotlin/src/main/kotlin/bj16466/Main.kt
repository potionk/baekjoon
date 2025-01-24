package bj16466

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val tickets = br.readLine().split(" ").map { it.toInt() }.sorted()
    val ticketSet = tickets.toSet()
    val max = tickets.last()
    for (i in 1..max) {
        if (i !in ticketSet) {
            println(i)
            return
        }
    }
    println(max + 1)
}
