import sys

test_case, max_length = map(int, sys.stdin.readline().split())
lan_cables = []
high = -1
low = 1
for _ in range(test_case):
    read_data = int(sys.stdin.readline())
    high = max(high, read_data)
    lan_cables.append(read_data)

result = -1
while low <= high:
    mid = int((high + low) / 2)
    count = 0
    for i in range(test_case):
        count += int(lan_cables[i] / mid)
    if count >= max_length:
        if result < mid:
            result = mid
        low = mid + 1
    else:
        high = mid - 1

print(result)
