import sys

cur_hour, cur_min = map(int, sys.stdin.readline().split())
oven_time = int(sys.stdin.readline())

cur_min += oven_time

if cur_min >= 60:
    cur_hour += int(cur_min / 60)
    cur_hour %= 24
    cur_min %= 60

print(str(cur_hour) + " " + str(cur_min))