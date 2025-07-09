package bj33772

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val row1 = br.readLine()
    val row2 = br.readLine()
    var result = ""
    var i = 0
    while (i < n) {
        if (row1[i] == '.') {
            i++
            continue
        }
        if (i + 7 < n &&
            row1.substring(i, i + 8) == "\\../\\../" &&
            row2.substring(i, i + 8) == ".\\/..\\/."
        ) {
            result += 'w'
            i += 8
        } else if (i + 3 < n &&
            row1.substring(i, i + 4) == "\\../" &&
            row2.substring(i, i + 4) == ".\\/."
        ) {
            result += 'v'
            i += 4
        } else {
            i++
        }
    }
    println(result)
}
