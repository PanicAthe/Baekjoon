import sys

input = sys.stdin.readline

first_line = input().split()
N = int(first_line[0])
K = int(first_line[1])

weight = [0] * N
value = [0] * N

for i in range(N):
    w, v = map(int, input().split())
    weight[i] = w
    value[i] = v

dp = [0] * (K + 1)

for i in range(N):
    for j in range(K, weight[i] - 1, -1):
        dp[j] = max(dp[j], dp[j - weight[i]] + value[i])

print(dp[K])