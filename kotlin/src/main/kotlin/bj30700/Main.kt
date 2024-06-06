package bj30700

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val koreaArray = arrayOf('K', 'O', 'R', 'E', 'A')
    var result = 0
    br.readLine().forEach {
        if (it == koreaArray[result % 5]) {
            result++
        }
    }
    println(result)
}
