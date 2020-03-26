import sys
import heapq
import math

test_case = int(sys.stdin.readline())
for _ in range(test_case):
    num = int(sys.stdin.readline())
    leftHeap = []
    rightHeap = []
    read = []
    if num <= 10:
        read = list(map(int, sys.stdin.readline().split()))
    else:
        for __ in range(int(num / 10) + 1):
            readLine = list(map(int, sys.stdin.readline().split()))
            read += readLine
    print(math.ceil(num / 2))
    for i in range(num):
        if i == 0:
            heapq.heappush(leftHeap, (-read[i], read[i]))
        elif len(leftHeap) == len(rightHeap):
            heapq.heappush(leftHeap, (-read[i], read[i]))
        else:
            heapq.heappush(rightHeap, (read[i], read[i]))
        if len(leftHeap) > 0 and len(rightHeap) > 0 and leftHeap[0][1] > rightHeap[0][1]:
            left_data = heapq.heappop(leftHeap)[1]
            right_data = heapq.heappop(rightHeap)[1]
            heapq.heappush(rightHeap, (left_data, left_data))
            heapq.heappush(leftHeap, (-right_data, right_data))
        if i != 0 and i % 20 == 0:
            print("")
        if i % 2 == 0:
            print(leftHeap[0][1], end=" ")
    print("")
