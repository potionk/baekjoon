package bj14238

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine().toCharArray()
    val count = IntArray(3) // a, b, c
    val alphabet = "ABC".toCharArray()
    for (c in s) {
        count[c - 'A']++
    }
    val size = s.size
    fun dfs(idx: Int, lastBIdx: Int, lastCIdx: Int, charList: MutableList<Char>): String {
        if (idx == size) {
            return charList.joinToString("")
        }
        for (i in 2 downTo 0) {
            if (count[i] > 0) {
                if (i == 1 && lastBIdx + 1 >= idx) {
                    continue
                }
                if (i == 2 && lastCIdx + 2 >= idx) {
                    continue
                }
                if (size - idx < count[1] * 2 - 1 || size - idx < (count[2] - 1) * 3 + 1) {
                    continue
                }
                count[i]--
                val bIdx = if (i == 1) idx else lastBIdx
                val cIdx = if (i == 2) idx else lastCIdx
                charList.add(alphabet[i])
                val result = dfs(idx + 1, bIdx, cIdx, charList)
                if (result != "") {
                    return result
                }
                charList.removeAt(charList.size - 1)
                count[i]++
            }
        }
        return ""
    }

    val result = dfs(0, -2, -3, mutableListOf())
    if (result == "") {
        println(-1)
    } else {
        println(result)
    }
}
