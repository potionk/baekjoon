import sys
import heapq

test_case = int(sys.stdin.readline())
leftHeap = []
rightHeap = []
for i in range(test_case):
    read = int(sys.stdin.readline())
    if i == 0:
        heapq.heappush(leftHeap, (-read, read))
    elif len(leftHeap) == len(rightHeap):
        heapq.heappush(leftHeap, (-read, read))
    else:
        heapq.heappush(rightHeap, (read, read))
    if len(leftHeap) > 0 and len(rightHeap) > 0 and leftHeap[0][1] > rightHeap[0][1]:
        left_data = heapq.heappop(leftHeap)[1]
        right_data = heapq.heappop(rightHeap)[1]
        heapq.heappush(rightHeap, (left_data, left_data))
        heapq.heappush(leftHeap, (-right_data, right_data))
    print(leftHeap[0][1])
