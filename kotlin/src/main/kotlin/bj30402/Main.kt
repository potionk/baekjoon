package bj30402

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var result = ""
    for (i in 0 until 15) {
        val line = br.readLine().split(" ")
        line.forEach {
            when (it) {
                "w" -> {
                    result = "chunbae"
                    return@forEach
                }
                "b" -> {
                    result = "nabi"
                    return@forEach
                }
                "g" -> {
                    result = "yeongcheol"
                    return@forEach
                }
            }
        }
        if (result != "") {
            println(result)
            return
        }
    }
}
