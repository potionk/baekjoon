package bj16139

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val s = br.readLine().toCharArray()
    val cumulativeSum = Array(26) { IntArray(s.size) }
    for (i in s.indices) {
        cumulativeSum[s[i] - 'a'][i] = 1
    }
    for (i in 0 until 26) {
        for (j in 1 until s.size) {
            cumulativeSum[i][j] += cumulativeSum[i][j - 1]
        }
    }
    val questionSize = br.readLine().toInt()
    for (i in 0 until questionSize) {
        val (alphabetStr, leftStr, rightStr) = br.readLine().split(" ")
        val alphabetIdx = alphabetStr.toCharArray()[0] - 'a'
        val left = leftStr.toInt()
        val right = rightStr.toInt()
        val result =
            cumulativeSum[alphabetIdx][right] - (if (left - 1 >= 0) cumulativeSum[alphabetIdx][left - 1] else 0)
        bw.write("$result\n")
    }
    br.close()
    bw.close()
}
