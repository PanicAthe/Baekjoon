from collections import deque

N, M = map(int, input().split())
map = [list(map(int, list(input()))) for _ in range(N)]

dx = [0,0,1,-1]
dy = [1,-1,0,0]

dist = [[-1]*M for _ in range(N)]

queue = deque()
queue.append((0, 0))
dist[0][0] = 1

while queue:
    x, y = queue.popleft()

    if x== N-1 and y == M-1:
        break

    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < N and 0 <= ny < M and map[nx][ny] == 1 and dist[nx][ny] == -1 :
            dist[nx][ny] = dist[x][y] + 1
            queue.append((nx, ny))

print(dist[N-1][M-1])