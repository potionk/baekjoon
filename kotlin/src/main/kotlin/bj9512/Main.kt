package bj9512

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, String>()
    repeat(n) {
        val langInfo = br.readLine().split(" ")
        for (i in 1 until langInfo.size) {
            map[langInfo[i].toLowerCase()] = langInfo[0]
        }
    }
    br.readLine()
    var sample = br.readLine()
    while (sample != null) {
        val tokenized = sample.split(" ", ",", ".", "!", ";", "?", "(", ")").map { it.toLowerCase() }
        for (i in tokenized.indices) {
            if (map.containsKey(tokenized[i])) {
                print("${map[tokenized[i]]}\n")
                break
            }
        }
        sample = br.readLine()
    }
}
