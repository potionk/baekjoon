package bj9935

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    val bomb = br.readLine()
    val bombLastChar = bomb.last()
    val bombLength = bomb.length
    val afterBombStr = mutableListOf<Char>()
    for (i in str.indices) {
        afterBombStr.add(str[i])
        if (afterBombStr.last() == bombLastChar && afterBombStr.size >= bombLength) {
            var isBomb = true
            for (j in bomb.indices) {
                if (afterBombStr[afterBombStr.size - bombLength + j] != bomb[j]) {
                    isBomb = false
                    break
                }
            }
            if (isBomb) {
                for (j in 0 until bombLength) {
                    afterBombStr.removeLast()
                }
            }
        }
    }
    if (afterBombStr.isEmpty()) {
        println("FRULA")
    } else {
        println(afterBombStr.joinToString(""))
    }
}
