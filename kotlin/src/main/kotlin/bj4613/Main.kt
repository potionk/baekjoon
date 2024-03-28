package bj4613

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val line = br.readLine()
        if (line == "#") break
        var total = 0
        for (i in line.indices) {
            if (line[i] == ' ') continue
            total += (i + 1) * (line[i] - 'A' + 1)
        }
        println(total)
    }
}
