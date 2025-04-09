package bj5340

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println("Latitude ${br.readLine().trimEnd().length}:${br.readLine().trimEnd().length}:${br.readLine().trimEnd().length}")
    println("Longitude ${br.readLine().trimEnd().length}:${br.readLine().trimEnd().length}:${br.readLine().trimEnd().length}")
}
