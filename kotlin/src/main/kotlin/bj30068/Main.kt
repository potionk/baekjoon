package bj30068

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val parkingLot = mutableMapOf<Int, Int>()
    for (i in 0 until n) {
        val (time, number) = br.readLine().split(" ").map { it.toInt() }
        if (parkingLot.containsKey(number)) {
            println("$number ${time - parkingLot[number]!!}")
            parkingLot.remove(number)
        } else {
            parkingLot[number] = time
        }
    }
}
