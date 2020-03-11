import sys

n, m = map(int, sys.stdin.readline().split())
data = [0 for _ in range(m)]


def pr(cur_index):
    if cur_index == m:
        compare = -1
        outData = []
        for i in range(m):
            if data[i] >= compare:
                outData.append(data[i])
                compare = data[i]
            else:
                break
        if len(outData) == m:
            for j in range(m):
                sys.stdout.write(str(outData[j])+" ")
            sys.stdout.write("\n")
        return
    for i in range(n):
        data[cur_index] = i + 1
        pr(cur_index + 1)


pr(0)