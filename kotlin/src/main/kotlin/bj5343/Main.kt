package bj5343

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val data = br.readLine().toCharArray()
        var errorCount = 0
        for (i in data.indices step 8) {
            val parity = data.slice(i until i + 7).count { it == '1' }
            if (parity % 2 == 0 && data[i + 7] == '1') {
                errorCount++
            } else if (parity % 2 == 1 && data[i + 7] == '0') {
                errorCount++
            }
        }
        println(errorCount)
    }
}
