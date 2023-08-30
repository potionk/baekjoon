package bj28691

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    when (br.readLine()) {
        "M" -> println("MatKor")
        "W" -> println("WiCys")
        "C" -> println("CyKor")
        "A" -> println("AlKor")
        "\$" -> println("\$clear")
        else -> println("-1")
    }
}
