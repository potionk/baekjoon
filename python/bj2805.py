import sys

test_case, length = map(int, sys.stdin.readline().split())
wood = list(map(int, sys.stdin.readline().split()))
high = max(wood)
low = 1
result = 0
while low - high <= 0:
    mid = int((high + low) / 2)
    total = 0
    for i in range(test_case):
        cut = wood[i] - mid
        if cut > 0:
            total += wood[i] - mid
    if total >= length:
        if result < mid:
            result = mid
        low = mid + 1
    else:
        high = mid - 1

print(result)
