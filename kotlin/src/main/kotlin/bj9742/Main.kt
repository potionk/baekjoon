package bj9742

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var readLine = br.readLine()
    while (readLine != null) {
        val (str, n) = readLine.split(" ")
        stringPermutation(str, n.toInt())
        readLine = br.readLine()
    }
}

fun stringPermutation(str: String, order: Int) {
    val charArray = str.toCharArray()
    val n = charArray.size
    val visited = BooleanArray(n)
    val output = CharArray(n)
    var count = 0
    var find = false
    fun dfs(depth: Int) {
        if (depth == n) {
            count++
            if (count == order) {
                println("$str $order = ${output.joinToString("")}")
                find = true
            }
            return
        }
        for (i in charArray.indices) {
            if (!visited[i]) {
                visited[i] = true
                output[depth] = charArray[i]
                dfs(depth + 1)
                visited[i] = false
            }
        }
    }
    dfs(0)
    if (!find) {
        println("$str $order = No permutation")
    }
}
