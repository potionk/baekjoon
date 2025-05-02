import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val (a,b,c) = br.readLine().split(" ").map { it.toInt() }
        var count = 0
        for (x in 1..a) {
            for (y in 1..b) {
                for (z in 1..c) {
                    if (x % y == y % z && y % z == z % x) {
                        count++
                    }
                }
            }
        }
        println(count)
    }
}
