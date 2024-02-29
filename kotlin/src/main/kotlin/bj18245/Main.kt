package bj18245

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var i = 1
    while (true) {
        val input = br.readLine()
        if (input == "Was it a cat I saw?") {
            break
        }
        println(input.filterIndexed { index, _ -> index % (i + 1) == 0 })
        i++
    }
}
