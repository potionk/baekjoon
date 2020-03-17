import sys

tc = int(sys.stdin.readline())
meeting_room = []
for i in range(tc):
    meeting_room.append(tuple(map(int, sys.stdin.readline().split())))

meeting_room = sorted(meeting_room, key=lambda room: room[1])
meeting_room = sorted(meeting_room, key=lambda room: room[0])
finish_time = 0
count = 0
while True:
    find_next = sorted(meeting_room, key=lambda room: room[1])
    finish_time = find_next[0][1]
    flag = False
    while True:
        if len(meeting_room) <= 0:
            break
        if meeting_room[0][0] < finish_time:
            if meeting_room[0][0] == meeting_room[0][1]:
                count += 1
            elif meeting_room[0][1] == finish_time:
                count += 1
                meeting_room.pop(0)
                continue
            meeting_room.pop(0)
        elif meeting_room[0][1] == finish_time:
            count += 1
            meeting_room.pop(0)
        else:
            break
    if len(meeting_room) <= 0:
        break

print(count)
