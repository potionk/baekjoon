package bj33869

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val keyStr = br.readLine()
    val visited = mutableSetOf<Char>()
    val encryptTable = Array(26) { ' ' }
    var idx = 0
    keyStr.forEach {
        if (!visited.contains(it)) {
            visited.add(it)
            encryptTable[idx++] = it
        }
    }
    for (i in 'A'..'Z') {
        if (!visited.contains(i)) {
            encryptTable[idx++] = i
        }
    }
    val s = br.readLine()
    s.forEach {
        print(encryptTable[it - 'A'])
    }
}
