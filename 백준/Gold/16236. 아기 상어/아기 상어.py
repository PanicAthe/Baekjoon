import sys
import heapq

# 입력을 빠르게 받기 위해 sys.stdin.readline 사용
input = sys.stdin.readline

# N: 공간의 크기
N = 0
map_data = []
# 아기 상어 크기
size = 2
# 아기 상어 위치 (x, y)
pos = [0, 0]
# 아기 상어가 현재 크기에서 먹은 물고기 수
count = 0
# 도움을 요청하기 까지 걸린 초
time = 0

dx = [-1, 0, 0, 1]
dy = [0, -1, 1, 0]

# 아기 상어가 물고기 먹는지 확인
def bfs():
    global size, pos, count, time
    
    visited = [[False] * N for _ in range(N)]
    
    # 위치와 거리를 저장 (우선순위 큐)
    # 파이썬의 heapq는 최소 힙이므로 (거리, x, y) 순으로 넣으면 
    # 자동으로 거리 ASC, X ASC, Y ASC 순으로 정렬됨
    que = []
    heapq.heappush(que, (0, pos[0], pos[1]))
    visited[pos[0]][pos[1]] = True

    while que:
        dist, x, y = heapq.heappop(que)

        # 현재 위치 물고기를 잡아 먹을 수 있음
        if 0 < map_data[x][y] < size:
            time += dist
            pos = [x, y]
            count += 1
            if count == size:
                size += 1
                count = 0
            map_data[x][y] = 0
            return True
            
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny]:
                # 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없음
                if map_data[nx][ny] <= size:
                    visited[nx][ny] = True
                    heapq.heappush(que, (dist + 1, nx, ny))

    return False

def main():
    global N, map_data, pos
    
    N = int(input())
    map_data = []

    for i in range(N):
        row = list(map(int, input().split()))
        for j in range(N):
            if row[j] == 9:
                pos = [i, j]
                row[j] = 0 # 아기 상어 시작 위치 초기화
        map_data.append(row)

    while True:
        if not bfs():
            break
            
    print(time)

if __name__ == "__main__":
    main()