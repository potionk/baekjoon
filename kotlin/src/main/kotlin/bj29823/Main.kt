package bj29823

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    val directions = br.readLine()
    var north = 0
    var south = 0
    var east = 0
    var west = 0
    for (dir in directions) {
        when (dir) {
            'N' -> north++
            'S' -> south++
            'E' -> east++
            'W' -> west++
        }
    }
    println(abs(north - south) + abs(east - west))
}
