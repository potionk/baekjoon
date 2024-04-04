package bj10173

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val line = br.readLine()
        if (line == "EOI") break
        println(
            if (line.toLowerCase().contains("nemo")) {
                "Found"
            } else {
                "Missing"
            }
        )
    }
}
