package bj25594

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val hgMap = mapOf(
        "a" to "aespa",
        "b" to "baekjoon",
        "c" to "cau",
        "d" to "debug",
        "e" to "edge",
        "f" to "firefox",
        "g" to "golang",
        "h" to "haegang",
        "i" to "iu",
        "j" to "java",
        "k" to "kotlin",
        "l" to "lol",
        "m" to "mips",
        "n" to "null",
        "o" to "os",
        "p" to "python",
        "q" to "query",
        "r" to "roka",
        "s" to "solvedac",
        "t" to "tod",
        "u" to "unix",
        "v" to "virus",
        "w" to "whale",
        "x" to "xcode",
        "y" to "yahoo",
        "z" to "zebra"
    ).map { it.key to it.value.toCharArray() }.toMap()
    val charArray = br.readLine().toCharArray()
    var idx = 0
    val stringBuilder = StringBuilder()
    val size = charArray.size
    while (idx < size) {
        val c = charArray[idx]
        val expected = hgMap[c.toString()]!!
        for (i in expected.indices) {
            if (idx + i >= size || charArray[idx + i] != expected[i]) {
                println("ERROR!")
                return
            }
        }
        stringBuilder.append(c)
        idx += expected.size
    }
    println("It's HG!")
    println(stringBuilder.toString())
}
