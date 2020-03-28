import sys

A = int(sys.stdin.readline())
B = int(sys.stdin.readline())
C = int(sys.stdin.readline())
D = int(sys.stdin.readline())
P = int(sys.stdin.readline())

X = A * P
Y = 0
if P <= C:
    Y = B
else:
    Y = B + (P - C) * D

if X > Y:
    print(Y)
else:
    print(X)
