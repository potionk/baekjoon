package bj20977

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    println(
        br.readLine()
            .replace("J", "a")
            .replace("O", "b")
            .replace("I", "c")
            .toCharArray().sorted().joinToString("")
            .replace("a", "J")
            .replace("b", "O")
            .replace("c", "I")
    )
}
