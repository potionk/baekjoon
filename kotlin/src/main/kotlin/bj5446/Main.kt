package bj5446

import java.io.*
import java.util.*

var count = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        count = 0
        val deleteTargetNum = br.readLine().toInt()
        val trie = Trie()
        repeat(deleteTargetNum) {
            trie.insertDelete(br.readLine())
        }
        val necessaryTargetNum = br.readLine().toInt()
        repeat(necessaryTargetNum) {
            trie.insertNecessary(br.readLine())
        }
        analyze(trie.root, "", true)
        println(if (necessaryTargetNum == 0) 1 else count)
    }
}

data class TrieNode(val char: Char?) {
    val children: TreeMap<Char, TrieNode> = TreeMap()
    var isNecessary: Boolean = false
    var isEnd: Boolean = false
    var requireDelete: Boolean = false
}

class Trie {
    val root = TrieNode(null)

    fun insertDelete(str: String) {
        var currentNode = root
        for (char in str) {
            if (!currentNode.children.containsKey(char)) {
                currentNode.children[char] = TrieNode(char)
            }
            currentNode = currentNode.children[char]!!
        }
        currentNode.isEnd = true
        currentNode.requireDelete = true
    }

    fun insertNecessary(str: String) {
        var currentNode = root
        for (char in str) {
            if (!currentNode.children.containsKey(char)) {
                currentNode.children[char] = TrieNode(char)
            }
            currentNode = currentNode.children[char]!!
            currentNode.isNecessary = true
        }
        currentNode.isEnd = true
    }
}

fun analyze(node: TrieNode, ip: String, isRoot: Boolean): Boolean {
    var necessary = false
    for ((currentNode, childNode) in node.children) {
        necessary = analyze(childNode, ip + currentNode, false)
        if (node.isNecessary && !necessary) {
//            if (childNode.isEnd) {
//                println("$ip${childNode.char}")
//            } else {
//                println("$ip${childNode.char}*")
//            }
            count++
        } else if (childNode.requireDelete && childNode.isNecessary) {
//            println("$ip${childNode.char}")
            count++
        } else if (isRoot && !necessary) {
//            println("$ip${childNode.char}*")
            count++
        }
    }
    return node.isNecessary || necessary
}
