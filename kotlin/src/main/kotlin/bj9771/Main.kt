package bj9771

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val word = br.readLine()
    var readLine = br.readLine()
    var count = 0
    while (readLine != null) {
        count += (readLine.length - readLine.replace(word, "").length) / word.length
        readLine = br.readLine()
    }
    println(count)
    br.close()
}
