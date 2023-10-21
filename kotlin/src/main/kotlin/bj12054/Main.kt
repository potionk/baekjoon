package bj12054

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()
    for (i in 1..t) {
        val n = br.readLine().toInt()
        val trie = Trie()
        repeat(n) {
            val (ip, subnetMask) = br.readLine().split("/")
            val binaryIp = ipToBinaryStr(ip, subnetMask.toInt())
            trie.insert(binaryIp)
        }
        mergeIpAddress(trie.root)
        bw.write("Case #$i:\n")
        printTrie(trie.root, bw, "")
    }
    bw.close()
}

fun ipToBinaryStr(ip: String, subnetMask: Int): String {
    val binaryIp = StringBuilder()
    val ipParts = ip.split(".")
    for (ipPart in ipParts) {
        val binaryIpPart = Integer.toBinaryString(ipPart.toInt())
        binaryIp.append("0".repeat(8 - binaryIpPart.length))
        binaryIp.append(binaryIpPart)
    }
    return binaryIp.replace(subnetMask, 32, "*").toString()
}

fun binaryToIpAddress(binaryIp: String): String {
    val ip = StringBuilder()
    val subnetMask = binaryIp.length
    val fullBinaryIp = binaryIp + "0".repeat(32 - subnetMask)
    for (i in 0 until 4) {
        ip.append(Integer.parseInt(fullBinaryIp.substring(i * 8, i * 8 + 8), 2))
        if (i != 3) {
            ip.append(".")
        }
    }
    ip.append("/")
    ip.append(binaryIp.length)
    return ip.toString()
}

data class TrieNode(val char: Char?) {
    val children: TreeMap<Char, TrieNode> = TreeMap()
    var isEnd: Boolean = false
}

class Trie {
    val root = TrieNode(null)

    fun insert(ipBinary: String) {
        var currentNode = root
        for (char in ipBinary) {
            if (char == '*') {
                break
            }
            if (!currentNode.children.containsKey(char)) {
                currentNode.children[char] = TrieNode(char)
            }
            currentNode = currentNode.children[char]!!
        }
        currentNode.isEnd = true
    }
}

fun printTrie(node: TrieNode, bw: BufferedWriter, ip: String) {
    if (node.isEnd) {
        bw.write("${binaryToIpAddress(ip)}\n")
    } else {
        for ((currentNode, childNode) in node.children) {
            printTrie(childNode, bw, ip + currentNode)
        }
    }
}

fun mergeIpAddress(node: TrieNode) {
    for (childNode in node.children.values) {
        mergeIpAddress(childNode)
    }
    if (node.children.size == 2 && node.children['0']!!.isEnd && node.children['1']!!.isEnd) {
        node.children.clear()
        node.isEnd = true
    }
}
