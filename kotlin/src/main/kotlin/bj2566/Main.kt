package bj2566

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var maxY = 0
    var maxX = 0
    var max = -1
    for (i in 1..9) {
        val readLine = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until 9) {
            if (max < readLine[j]) {
                max = readLine[j]
                maxY = i
                maxX = j + 1
            }
        }
    }
    println(max)
    println("$maxY $maxX")
    br.close()
}
