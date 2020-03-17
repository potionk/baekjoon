import sys

tc = int(sys.stdin.readline())
meeting_room = []
for i in range(tc):
    meeting_room.append(tuple(map(int, sys.stdin.readline().split())))

meeting_room = sorted(meeting_room, key=lambda room: room[0])
meeting_room = sorted(meeting_room, key=lambda room: room[1])

cur_time = 0
count = 0

for i in meeting_room:
    if i[0] >= cur_time:
        cur_time = i[1]
        count += 1

print(count)