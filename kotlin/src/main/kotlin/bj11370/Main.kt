package bj11370

import java.io.*

val Y_ARROW = listOf(0, 1, 0, -1)
val X_ARROW = listOf(1, 0, -1, 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        val readLine = br.readLine()
        if (readLine == "0 0") {
            break
        }
        val (w, h) = readLine.split(" ").map { it.toInt() }
        var spiderX = -1
        var spiderY = -1
        val map = Array(h) { CharArray(w) }
        for (i in 0 until h) {
            map[i] = br.readLine().toCharArray()
            for (j in 0 until w) {
                if (map[i][j] == 'S') {
                    spiderY = i
                    spiderX = j
                }
            }
        }
        dfs(spiderY, spiderX, h, w, map, Array(h) { BooleanArray(w) })
        for (i in 0 until h) {
            for (j in 0 until w) {
                bw.write("${map[i][j]}")
            }
            bw.write("\n")
        }
    }
    br.close()
    bw.close()
}

fun dfs(
    y: Int,
    x: Int,
    ySize: Int,
    xSize: Int,
    map: Array<CharArray>,
    isVisited: Array<BooleanArray>
) {
    for (i in 0 until 4) {
        val nextY = y + Y_ARROW[i]
        val nextX = x + X_ARROW[i]
        if (canMove(nextY, nextX, ySize, xSize) && map[nextY][nextX] == 'T' && !isVisited[nextY][nextX]) {
            isVisited[nextY][nextX] = true
            map[nextY][nextX] = 'S'
            dfs(nextY, nextX, ySize, xSize, map, isVisited)
        }
    }
}

fun canMove(nextY: Int, nextX: Int, ySize: Int, xSize: Int): Boolean {
    return nextY in 0 until ySize && nextX in 0 until xSize
}
