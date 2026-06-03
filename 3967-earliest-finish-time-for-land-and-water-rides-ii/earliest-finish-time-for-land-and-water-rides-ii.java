class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        // Earliest finish time among all land rides
        int minLandEnd = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            minLandEnd = Math.min(minLandEnd,
                                  landStartTime[i] + landDuration[i]);
        }

        // Land -> Water
        int ans1 = Integer.MAX_VALUE;
        for (int i = 0; i < waterStartTime.length; i++) {
            int finish = Math.max(minLandEnd, waterStartTime[i])
                         + waterDuration[i];
            ans1 = Math.min(ans1, finish);
        }

        // Earliest finish time among all water rides
        int minWaterEnd = Integer.MAX_VALUE;
        for (int i = 0; i < waterStartTime.length; i++) {
            minWaterEnd = Math.min(minWaterEnd,
                                   waterStartTime[i] + waterDuration[i]);
        }

        // Water -> Land
        int ans2 = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            int finish = Math.max(minWaterEnd, landStartTime[i])
                         + landDuration[i];
            ans2 = Math.min(ans2, finish);
        }

        return Math.min(ans1, ans2);
    }
}