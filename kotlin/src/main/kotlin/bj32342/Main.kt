package bj32342

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val line = br.readLine().toCharArray()
        var count = 0
        for (i in 0 until line.size - 2) {
            if (line[i] == 'W') {
                if (line[i + 1] == 'O' && line[i + 2] == 'W') {
                    count++
                }
            }
        }
        println(count)
    }
}
