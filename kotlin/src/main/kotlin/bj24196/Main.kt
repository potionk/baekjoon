package bj24196

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val charArray = br.readLine().toCharArray()
    var idx = 0
    while (idx < charArray.size) {
        print(charArray[idx])
        idx += charArray[idx].code - 'A'.code + 1
    }
}
