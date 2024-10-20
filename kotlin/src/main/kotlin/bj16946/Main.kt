package bj16946

import java.io.*

val dy = intArrayOf(1, -1, 0, 0)
val dx = intArrayOf(0, 0, 1, -1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { br.readLine().toCharArray() }
    val group = Array(n) { IntArray(m) { -1 } }
    val maxCountMap = mutableMapOf<Int, Int>()
    var groupIdx = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == '0' && group[i][j] == -1) {
                val count = dfs(map, group, i, j, groupIdx, n, m)
                maxCountMap[groupIdx++] = count
            }
        }
    }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == '1') {
                val visited = mutableSetOf<Int>()
                var count = 1
                for (k in 0 until 4) {
                    val ny = i + dy[k]
                    val nx = j + dx[k]
                    if (ny in 0 until n && nx in 0 until m && map[ny][nx] == '0' && !visited.contains(group[ny][nx])) {
                        count += maxCountMap[group[ny][nx]]!!
                        visited.add(group[ny][nx])
                    }
                }
                bw.write("${count % 10}")
            } else {
                bw.write("0")
            }
        }
        bw.write("\n")
    }
    bw.close()
}

fun dfs(map: Array<CharArray>, group: Array<IntArray>, y: Int, x: Int, groupIdx: Int, ySize: Int, xSize: Int): Int {
    group[y][x] = groupIdx
    var count = 1
    for (i in 0 until 4) {
        val ny = y + dy[i]
        val nx = x + dx[i]
        if (ny in 0 until ySize && nx in 0 until xSize && map[ny][nx] == '0' && group[ny][nx] == -1) {
            count += dfs(map, group, ny, nx, groupIdx, ySize, xSize)
        }
    }
    return count
}
