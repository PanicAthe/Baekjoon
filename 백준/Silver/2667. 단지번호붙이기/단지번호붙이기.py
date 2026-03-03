import sys
from collections import deque

input = sys.stdin.readline

N = int(input().strip())

map = [list(map(int, input().strip())) for _ in range(N)]

visited = [[False]*N for _ in range(N)]

dx = [0,0,-1,1]
dy = [1,-1,0,0]

def bfs(start_x, start_y):
    queue = deque()
    queue.append((start_x, start_y))
    visited[start_x][start_y] = True

    count = 1

    while queue:
        cur_x, cur_y = queue.popleft()

        for i in range(4):
            x = cur_x + dx[i]
            y = cur_y + dy[i]

            if x<0 or x>=N or y<0 or y>=N or map[x][y]==0 or visited[x][y]:
                continue;

            visited[x][y] = True
            queue.append((x,y))
            count += 1

    return count

result = []

for i in range(N):
    for j in range(N):
        if not visited[i][j] and map[i][j]==1:
            result.append(bfs(i, j))

print(len(result))
result.sort()
for r in result:
    print(r)