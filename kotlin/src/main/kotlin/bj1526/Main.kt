package bj1526

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (i in n downTo 0) {
        var isGood = true
        var l = i
        while (l > 0) {
            if (l % 10 != 4 && l % 10 != 7) {
                isGood = false
                break
            }
            l /= 10
        }
        if (isGood) {
            println(i)
            break
        }
    }
    br.close()
}
