import sys

students = [0 for _ in range(30)]

for i in range(28):
    read = int(sys.stdin.readline())
    students[read - 1] = 1

for i in range(30):
    if students[i] == 0:
        print(i + 1)
