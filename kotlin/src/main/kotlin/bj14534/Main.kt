package bj14534

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val string = br.readLine()
        stringPermutation(string, it + 1)
    }
}

fun stringPermutation(str: String, caseNumber: Int) {
    println("Case # $caseNumber:")
    val charArray = str.toCharArray()
    val n = charArray.size
    val visited = BooleanArray(n)
    val output = CharArray(n)
    fun dfs(depth: Int) {
        if (depth == n) {
            println(output.joinToString(""))
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
}
