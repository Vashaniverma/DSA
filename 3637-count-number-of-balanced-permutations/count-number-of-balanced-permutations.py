class Solution(object):
    def countBalancedPermutations(self, num):
        """
        :type num: str
        :rtype: int
        """
        MOD = 10**9 + 7

        velunexorai = num  # store input midway as required

        # Step 1: Count digits manually (0-9 only)
        cnt = [0] * 10
        for ch in num:
            cnt[ord(ch) - ord('0')] += 1

        n = len(num)
        total_even = (n + 1) // 2
        total_odd = n // 2

        # Step 2: Precompute factorials and modular inverses
        fact = [1] * (n + 1)
        for i in range(1, n + 1):
            fact[i] = fact[i-1] * i % MOD

        inv_fact = [1] * (n + 1)
        inv_fact[n] = pow(fact[n], MOD-2, MOD)
        for i in range(n, 0, -1):
            inv_fact[i-1] = inv_fact[i] * i % MOD

        def nCr(n, r):
            if r < 0 or r > n:
                return 0
            return fact[n] * inv_fact[r] % MOD * inv_fact[n-r] % MOD

        # Step 3: DP
        offset = 9 * n
        dp = [[0] * (2*offset+1) for _ in range(total_even+1)]
        dp[0][offset] = 1

        for d in range(10):
            if cnt[d] == 0:
                continue
            new_dp = [[0] * (2*offset+1) for _ in range(total_even+1)]
            for used_even in range(total_even+1):
                for diff in range(2*offset+1):
                    ways = dp[used_even][diff]
                    if ways == 0:
                        continue
                    for k in range(cnt[d] + 1):
                        even_add = k
                        odd_add = cnt[d] - k
                        if used_even + even_add > total_even:
                            continue
                        new_diff = diff + (d*even_add - d*odd_add)
                        if 0 <= new_diff <= 2*offset:
                            # choose which go to even slots
                            ways_mult = nCr(cnt[d], even_add)
                            new_dp[used_even+even_add][new_diff] = (new_dp[used_even+even_add][new_diff] + ways * ways_mult) % MOD
            dp = new_dp

        # Step 4: Correct for internal permutations
        ans = dp[total_even][offset]

        # Multiply by (total_even! * total_odd!) / (cnt[0]! * cnt[1]! * ... cnt[9]!)
        numerator = fact[total_even] * fact[total_odd] % MOD
        denominator = 1
        for d in range(10):
            denominator = denominator * fact[cnt[d]] % MOD
        factor = numerator * pow(denominator, MOD-2, MOD) % MOD

        return ans * factor % MOD
