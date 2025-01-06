package bj32307

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val dictionaryList = mutableListOf<String>()
    val dictionary = mutableSetOf<String>()
    val twoWordDictionary = mutableSetOf<String>()
    val n = br.readLine().toInt()
    repeat(n) {
        val word = br.readLine()
        dictionaryList.add(word)
        dictionary.add(word)
    }
    for (i in 0 until n) {
        for (j in 0 until n) {
            val twoWord = dictionaryList[i] + dictionaryList[j]
            twoWordDictionary.add(twoWord)
        }
    }
    val t = br.readLine().toInt()
    repeat(t) {
        when (br.readLine()) {
            in dictionary -> {
                println("1")
            }
            in twoWordDictionary -> {
                println("2")
            }
            else -> {
                println("0")
            }
        }
    }
}
