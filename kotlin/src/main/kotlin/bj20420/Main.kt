package bj20420

import java.io.*
import kotlin.math.min

val du = Pair(-1, 0)
val dd = Pair(1, 0)
val dl = Pair(0, -1)
val dr = Pair(0, 1)
val d = listOf(du, dr, dd, dl)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r, c, k) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(r) { br.readLine().toCharArray() }
    if (k == 0) {
        if (bfsNoScroll(r, c, arr)) {
            println("Yes")
        } else {
            println("No")
        }
    } else {
        if (bfs(r, c, arr, k)) {
            println("Yes")
        } else {
            println("No")
        }
    }
}

fun bfs(ySize: Int, xSize: Int, arr: Array<CharArray>, k: Int): Boolean {
    val visited = Array(ySize) { Array(xSize) { Array(k + 1) { BooleanArray(k + 1) } } }
    val queue = mutableListOf<Triple<Int, Int, Pair<Int, Int>>>()
    queue.add(Triple(0, 0, Pair(0, 0)))
    visited[0][0][0][0] = true
    while (queue.isNotEmpty()) {
        val (y, x, scroll) = queue.removeAt(0)
        if (y == ySize - 1 && x == xSize - 1) {
            return true
        }

        val direction = charToDirIdx(arr[y][x])

        val (dy, dx) = d[direction]
        val ny = y + dy
        val nx = x + dx
        if (validate(ny, nx, ySize, xSize) && !visited[ny][nx][scroll.first][scroll.second]) {
            for (i in scroll.first..k step 4) {
                visited[ny][nx][i][scroll.second] = true
            }
            for (i in scroll.second..k step 4) {
                visited[ny][nx][scroll.first][i] = true
            }
            queue.add(Triple(ny, nx, scroll))
        }

        for (i in scroll.first + 1..min(k, scroll.first + 3)) {
            val rotateRight = rotateRight(direction, i - scroll.first)
            val (rotateDy, rotateDx) = d[rotateRight]
            val ry = y + rotateDy
            val rx = x + rotateDx
            if (validate(ry, rx, ySize, xSize) && !visited[ry][rx][i][scroll.second]) {
                for (j in i..k step 4) {
                    visited[ry][rx][j][scroll.second] = true
                }
                for (j in scroll.second..k step 4) {
                    visited[ry][rx][i][j] = true
                }
                queue.add(Triple(ry, rx, Pair(i, scroll.second)))
            }
        }

        for (i in scroll.second + 1..min(k, scroll.second + 3)) {
            val rotateLeft = rotateLeft(direction, i - scroll.second)
            val (rotateDy, rotateDx) = d[rotateLeft]
            val ry = y + rotateDy
            val rx = x + rotateDx
            if (validate(ry, rx, ySize, xSize) && !visited[ry][rx][scroll.first][i]) {
                for (j in i..k step 4) {
                    visited[ry][rx][scroll.first][j] = true
                }
                for (j in scroll.first..k step 4) {
                    visited[ry][rx][j][i] = true
                }
                queue.add(Triple(ry, rx, Pair(scroll.first, i)))
            }
        }
    }
    return false
}

fun bfsNoScroll(ySize: Int, xSize: Int, arr: Array<CharArray>): Boolean {
    val visited = Array(ySize) { BooleanArray(xSize) }
    val queue = mutableListOf<Pair<Int, Int>>()
    queue.add(Pair(0, 0))
    visited[0][0] = true
    while (queue.isNotEmpty()) {
        val (y, x) = queue.removeAt(0)
        if (y == ySize - 1 && x == xSize - 1) {
            return true
        }
        val direction = charToDirIdx(arr[y][x])
        val (dy, dx) = d[direction]
        val (ny, nx) = Pair(y + dy, x + dx)
        if (validate(ny, nx, ySize, xSize) && !visited[ny][nx]) {
            visited[ny][nx] = true
            queue.add(Pair(ny, nx))
        }
    }
    return false
}

fun validate(y: Int, x: Int, ySize: Int, xSize: Int): Boolean {
    return y in 0 until ySize && x in 0 until xSize
}

fun charToDirIdx(c: Char): Int {
    return when (c) {
        'U' -> 0
        'R' -> 1
        'D' -> 2
        'L' -> 3
        else -> -1
    }
}

fun rotateRight(index: Int, count: Int): Int {
    return (index + count) % 4
}

fun rotateLeft(index: Int, count: Int): Int {
    val result = (index - count) % 4
    if (result < 0) {
        return 4 + result
    }
    return result
}
