package bj32498

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var result = 0
    repeat(n) {
        if (br.readLine().toInt() % 2 == 1) {
            result += 1
        }
    }
    println(result)
}
