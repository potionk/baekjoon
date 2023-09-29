package bj16934

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val root = TrieNode()

    repeat(n) {
        val userNameStr = br.readLine()
        val userName = userNameStr.toCharArray()
        var currentNode = root
        var printIdx = -1
        for (i in userName.indices) {
            val path = userName[i]
            if (!currentNode.children.containsKey(path) && printIdx == -1) {
                printIdx = i
            }
            currentNode = currentNode.children.getOrPut(path) { TrieNode(size = if (i == userName.lastIndex) 1 else 0) }
        }
        if (printIdx == -1) {
            currentNode.size++
            bw.write("${userNameStr}${if (currentNode.size == 1) "" else currentNode.size}\n")
        } else {
            bw.write("${userName.sliceArray(0..printIdx).joinToString("")}\n")
        }
    }
    bw.close()
}

data class TrieNode(
    val children: TreeMap<Char, TrieNode> = TreeMap(),
    var size: Int = 0
)
