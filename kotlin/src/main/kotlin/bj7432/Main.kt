package bj7432

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val root = TrieNode()

    repeat(n) {
        val path = br.readLine().split("\\")
        var currentNode = root
        for (current in path) {
            currentNode = currentNode.children.getOrPut(current) { TrieNode() }
        }
    }
    printTrie(root, bw, 0)
    bw.close()
}

data class TrieNode(
    val children: TreeMap<String, TrieNode> = TreeMap()
)

fun printTrie(node: TrieNode, bw: BufferedWriter, depth: Int) {
    for ((currentNode, childNode) in node.children) {
        bw.write("${" ".repeat(depth)}$currentNode\n")
        printTrie(childNode, bw, depth + 1)
    }
}
