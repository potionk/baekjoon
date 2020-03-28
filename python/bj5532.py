import sys

L = int(sys.stdin.readline())
A = int(sys.stdin.readline())
B = int(sys.stdin.readline())
C = int(sys.stdin.readline())
D = int(sys.stdin.readline())

count = 0
while A > 0 or B > 0:
    A -= C
    B -= D
    count += 1

print(L-count)
