package bj33163

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    br.readLine().toCharArray().forEach {
        when (it) {
            'J' -> {
                print("O")
            }
            'O' -> {
                print("I")
            }
            else -> {
                print("J")
            }
        }
    }
}
