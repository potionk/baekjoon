import sys

N, M = map(int, sys.stdin.readline().split())
money = []
for _ in range(N):
    money.append(int(sys.stdin.readline()))
high = sum(money)
low = max(money)
result = high
while low - high <= 0:
    mid = int((high + low) / 2)
    wallet = 0
    count = 1
    for i in range(N):
        wallet += money[i]
        if wallet > mid:
            count += 1
            wallet = money[i]
    if count > M:
        low = mid + 1
    else:
        if mid < result:
            result = mid
        high = mid - 1

print(result)
