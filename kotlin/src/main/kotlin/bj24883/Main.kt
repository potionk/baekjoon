package bj24883

import java.io.*
import java.util.*

fun main() {
    println(if (BufferedReader(InputStreamReader(System.`in`)).readLine().lowercase(Locale.getDefault()) == "n") "Naver D2" else "Naver Whale")
}
