class Solution(object):
    def trapRainWater(self, heightMap):
        """
        :type heightMap: List[List[int]]
        :rtype: int
        """
        if not heightMap or not heightMap[0]:
            return 0

        m, n = len(heightMap), len(heightMap[0])
        visited = [[False] * n for _ in range(m)]

        # ---------- Min Heap Implementation ----------
        def heappush(heap, item):
            heap.append(item)
            i = len(heap) - 1
            while i > 0:
                parent = (i - 1) // 2
                if heap[parent][0] > heap[i][0]:
                    heap[parent], heap[i] = heap[i], heap[parent]
                    i = parent
                else:
                    break

        def heappop(heap):
            if not heap:
                return None
            root = heap[0]
            last = heap.pop()
            if heap:
                heap[0] = last
                i = 0
                while True:
                    left, right = 2*i+1, 2*i+2
                    smallest = i
                    if left < len(heap) and heap[left][0] < heap[smallest][0]:
                        smallest = left
                    if right < len(heap) and heap[right][0] < heap[smallest][0]:
                        smallest = right
                    if smallest != i:
                        heap[i], heap[smallest] = heap[smallest], heap[i]
                        i = smallest
                    else:
                        break
            return root
        # ---------------------------------------------

        heap = []
        # Step 1: Push all border cells
        for i in range(m):
            for j in range(n):
                if i in (0, m-1) or j in (0, n-1):
                    heappush(heap, (heightMap[i][j], i, j))
                    visited[i][j] = True

        trapped = 0
        maxBoundary = 0
        directions = [(1,0), (-1,0), (0,1), (0,-1)]

        # Step 2: Process cells
        while heap:
            h, x, y = heappop(heap)
            maxBoundary = max(maxBoundary, h)

            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and not visited[nx][ny]:
                    visited[nx][ny] = True
                    nh = heightMap[nx][ny]
                    if nh < maxBoundary:
                        trapped += maxBoundary - nh
                    heappush(heap, (max(nh, maxBoundary), nx, ny))

        return trapped
