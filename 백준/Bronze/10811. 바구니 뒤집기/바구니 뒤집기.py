# N: 바구니 수, M: 역순 수행 횟수
N, M = map(int, input().split())

# 1번부터 N번까지 바구니 초기화
baskets = list(range(1, N + 1))

# M번에 걸쳐 역순 처리
for _ in range(M):
    i, j = map(int, input().split())
    # 리스트의 i-1부터 j까지를 역순으로 바꿈 (i, j는 1-based)
    baskets[i-1:j] = baskets[i-1:j][::-1]

# 결과 출력
print(' '.join(map(str, baskets)))
