import sys
import heapq

test_case = int(sys.stdin.readline())
heap = []

for _ in range(test_case):
    cmd = int(sys.stdin.readline())
    if cmd != 0:
        heapq.heappush(heap, (abs(cmd), cmd))
    else:
        try:
            print(heapq.heappop(heap)[1])
        except:
            print(0)
