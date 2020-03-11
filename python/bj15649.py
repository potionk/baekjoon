import sys

n, m = map(int, sys.stdin.readline().split())
isVisited = [False for _ in range(n)]
data = [0 for _ in range(m)]


def pr(cur_index):
    if cur_index == m:
        for i in range(m):
            sys.stdout.write(str(data[i]))
            if i != m - 1:
                sys.stdout.write(" ")
        sys.stdout.write("\n")
        return
    for i in range(n):
        if isVisited[i]:
            continue
        isVisited[i] = True
        data[cur_index] = i + 1
        pr(cur_index+1)
        isVisited[i] = False


pr(0)