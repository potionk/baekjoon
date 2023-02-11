package bj2668

import java.io.*
import java.util.*

var resultList = mutableListOf<Int>()
var n = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    n = br.readLine().toInt()
    val connect = IntArray(n)
    val isVisited = BooleanArray(n)
    for (i in 0 until n) {
        connect[i] = br.readLine().toInt() - 1
        if (connect[i] == i) {
            isVisited[i] = true
            resultList.add(i)
        }
    }
    for (i in 0 until n) {
        if (!isVisited[i]) {
            val stack = Stack<Int>()
            val isVisitedInDfs = BooleanArray(n)
            dfs(i, connect, isVisited, isVisitedInDfs, stack)
        }
    }
    bw.write("${resultList.size}\n")
    resultList.sorted().forEach { bw.write("${it + 1}\n") }
    br.close()
    bw.close()
}

fun dfs(idx: Int, connect: IntArray, isVisited: BooleanArray, isVisitedInDfs: BooleanArray, stack: Stack<Int>) {
    if (isVisitedInDfs[idx]) {
        while (stack.peek() != idx) {
            resultList.add(stack.pop())
        }
        resultList.add(stack.pop())
    } else if (!isVisited[idx]) {
        stack.push(idx)
        isVisitedInDfs[idx] = true
        isVisited[idx] = true
        dfs(connect[idx], connect, isVisited, isVisitedInDfs, stack)
    }
}
