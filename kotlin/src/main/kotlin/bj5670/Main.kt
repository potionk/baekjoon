package bj5670

import java.io.*
import java.util.*

var totalCount = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var line: String?
    while (true) {
        line = br.readLine()
        if (line == null) {
            break
        }
        val n = line.toInt()
        val trie = Trie()
        var totalLength = 0
        for (i in 0 until n) {
            val str = br.readLine()
            totalLength += str.length
            trie.insert(str)
        }
        totalCount = 0
        calculateCount(trie.root, bw, if (trie.root.children.size == 1) 1 else 0)
        bw.write("${String.format("%.2f", (totalCount) / n.toDouble())}\n")
    }
    bw.close()
}


data class TrieNode(val char: Char?) {
    val children: TreeMap<Char, TrieNode> = TreeMap()
    var isEnd: Boolean = false
}

class Trie {
    val root = TrieNode(null)

    fun insert(str: String) {
        var currentNode = root
        for (char in str) {
            if (!currentNode.children.containsKey(char)) {
                currentNode.children[char] = TrieNode(char)
            }
            currentNode = currentNode.children[char]!!
        }
        val lastNode = TrieNode('.')
        lastNode.isEnd = true
        currentNode.children['.'] = lastNode
    }
}

fun calculateCount(node: TrieNode, bw: BufferedWriter, count: Int) {
    if (node.isEnd) {
        totalCount += count
        return
    }
    var nextCount = count
    if (node.children.size > 1) {
        nextCount++
    }
    for ((_, childNode) in node.children) {
        if (childNode.char == '.') {
            calculateCount(childNode, bw, count)
        } else {
            calculateCount(childNode, bw, nextCount)
        }
    }
}
