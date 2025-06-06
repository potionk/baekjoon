package bj6992

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().trim().toInt()
    repeat(n) {
        val list = br.readLine().trim().split(" ").map { it.toInt() }.drop(1)
        if (list.size == 1) {
            println("The next 5 numbers after ${listToString(list)} are: ${listToString(getResult(list[0], 0))}")
        } else {
            val diff = list[1] - list[0]
            for (i in 2 until list.size) {
                if (list[i] - list[i - 1] != diff) {
                    println("The sequence ${listToString(list)} is not an arithmetic sequence.")
                    return@repeat
                }
            }
            println("The next 5 numbers after ${listToString(list)} are: ${listToString(getResult(list.last() + diff, diff))}")
        }
    }
}

fun listToString(list: List<Int>): String = "[${list.joinToString(", ")}]"

fun getResult(first: Int, diff: Int): List<Int> = (0..4).map { first + diff * it }