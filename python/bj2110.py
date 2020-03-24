import sys

test_case, number = map(int, sys.stdin.readline().split())
house = []

for _ in range(test_case):
    read_data = int(sys.stdin.readline())
    house.append(read_data)
result = 0
house = sorted(house)
low = 1
high = house[-1]-house[0]

while low <= high:
    mid = int((high + low) / 2)
    count = 1
    startIndex = 0
    for i in range(1, test_case):
        if house[i] - house[startIndex] >= mid:
            count += 1
            startIndex = i
    if count >= number:
        if result < mid:
            result = mid
        low = mid + 1
    else:
        high = mid - 1

print(result)
