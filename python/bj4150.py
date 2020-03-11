import sys

tc = int(sys.stdin.readline())

dp=[1,1]

for i in range(2, tc):
    dp.append(dp[i-1]+dp[i-2])

print(dp[-1])