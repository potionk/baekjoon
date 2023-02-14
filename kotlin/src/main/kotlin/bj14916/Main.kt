package bj14916

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var result = -1
    for (i in n / 5 downTo 0) {
        if ((n - 5 * i) % 2 == 0) {
            result = i + (n - 5 * i) / 2
            break
        }
    }
    print(result)
    br.close()
}
