dp[i] = 包含i元素的最大值是多少
两种情况
1. 只有当前nums[i]元素
2. 包含上一个元素的最大值dp[i-1],加上当前值nums[i]
dp[i] = max(dp[i-1]+nums[i], nums[i])