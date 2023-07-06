package bj27058

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val encryption = br.readLine()
    val encryptionKeyMap = mutableMapOf<Char, Char>()
    for (i in 'a'..'z') {
        encryptionKeyMap[i] = encryption[i - 'a']
        encryptionKeyMap[i - 32] = encryption[i - 'a'] - 32
    }
    val decodeTarget = br.readLine()
    decodeTarget.forEach {
        bw.write("${encryptionKeyMap.getOrDefault(it, it)}")
    }
    br.close()
    bw.close()
}
