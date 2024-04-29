package bj15081

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val set = mutableSetOf<String>()
    repeat(t) {
        br.readLine().split(" ").drop(1).forEach {
            if (it !in set) {
                set.add(it)
                print("$it ")
                return@repeat
            }
        }
    }
}
