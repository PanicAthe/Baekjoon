N, M = map(int, input().split())

data = {}
for _ in range(N):
    key, value = input().split()
    data[key] = value

for _ in range(M):
    site = input()
    print(data[site])