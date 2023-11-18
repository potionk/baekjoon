package bj9202

import java.io.*
import java.util.*

val ARROW_X = arrayOf(0, 0, -1, 1, -1, 1, -1, 1)
val ARROW_Y = arrayOf(-1, 1, 0, 0, -1, 1, 1, -1)
const val BOARD_SIZE = 4

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()
    val trie = Trie()
    repeat(t) {
        trie.insert(br.readLine())
    }
    br.readLine()
    val n = br.readLine().toInt()
    repeat(n) {
        val board = Array(BOARD_SIZE) { br.readLine().toCharArray() }
        val visited = Array(BOARD_SIZE) { BooleanArray(BOARD_SIZE) }
        val result = mutableSetOf<String>()
        for (i in 0 until BOARD_SIZE) {
            for (j in 0 until BOARD_SIZE) {
                dfs(board, visited, trie.root, i, j, result, "")
            }
        }
        val resultList = result.toList().sortedWith(compareBy({ -it.length }, { it }))
        var score = 0
        for (word in resultList) {
            score += when (word.length) {
                1, 2 -> 0
                3, 4 -> 1
                5 -> 2
                6 -> 3
                7 -> 5
                else -> 11
            }
        }
        bw.write("$score ${resultList.first()} ${result.size}\n")
        if (it != n - 1) {
            br.readLine()
        }
    }
    bw.close()
}

fun dfs(
    board: Array<CharArray>,
    visited: Array<BooleanArray>,
    node: TrieNode,
    y: Int,
    x: Int,
    result: MutableSet<String>,
    str: String
) {
    if (node.isEnd) {
        result.add(str)
    }
    if (x !in 0 until BOARD_SIZE || y !in 0 until BOARD_SIZE || visited[y][x] || !node.children.containsKey(board[y][x])) {
        return
    }
    visited[y][x] = true
    val currentNode = node.children[board[y][x]]!!
    for (i in 0 until 8) {
        dfs(board, visited, currentNode, y + ARROW_Y[i], x + ARROW_X[i], result, str + board[y][x])
    }
    visited[y][x] = false
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
        currentNode.isEnd = true
    }
}
