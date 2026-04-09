import java.util.Arrays;
import java.util.OptionalInt;

class Recursion2 {
    public static void main(String[] args) {

    }

    public boolean groupSum(int start, int[] nums, int target) {
        if(target==0) return true;
        if(start==nums.length) return false;
        if(groupSum(start+1, nums, target-nums[start])){
            return true;
        } else {
            return groupSum(start+1, nums, target);
        }
    }


    public boolean groupSum6(int start, int[] nums, int target) {
        if(target==0 && start==nums.length) return true;
        if(start>=nums.length) return false;
        if(nums[start]==6){
            target -= 6;
        } else if (groupSum6(start+1, nums, target-nums[start])) {
            return true;
        }
        return groupSum6(start+1, nums, target);
    }


    public boolean groupNoAdj(int start, int[] nums, int target) {
        if(target==0) return true;
        if(start>=nums.length) return false;
        if(groupNoAdj(start+2, nums, target-nums[start])) {
            return true;
        } else if (groupNoAdj(start+3, nums, target-nums[start])) {
            return true;
        } else {
            return groupNoAdj(start+1, nums, target);
        }
    }


    public boolean groupSum5(int start, int[] nums, int target) {
        if(target==0 && start==nums.length) return true;
        if(start>=nums.length) return false;
        if(nums[start]%5!=0){
            if(groupSum5(start+1, nums, target-nums[start])) {
                return true;
            }
        } else {
            target-=nums[start];
            if(start<nums.length-1 && nums[start+1]==1) {
                return groupSum5(start+2, nums, target);
            }
        }
        return groupSum5(start+1, nums, target);
    }



    public boolean groupSumClump(int start, int[] nums, int target) {
        if(target==0) return true;
        if(start>=nums.length) return false;

        if(start<nums.length-1&&nums[start]==nums[start+1]) {
            int clumpSum = nums[start];
            int i = start+1;
            int temp = nums[start];
            while(nums[i]==temp) {
                clumpSum += nums[i];
                i++;
            }
            return groupSumClump(start+i-start,nums, target-clumpSum)
                    || groupSumClump(start+i-start,nums, target);
        }
        return groupSumClump(start+1,nums, target-nums[start])
                || groupSumClump(start+1,nums, target);
    }




    // can be done better
    public boolean splitArray(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2==1) {
            return false;
        }
        int halfSum = sum/2;
        return isHalfable(0, nums, halfSum, halfSum);
    }
    public boolean isHalfable(int start, int[] nums, int target1, int target2) {
        if(start>=nums.length && target1==0 && target1==target2) {
            return true;
        }
        if(start>=nums.length) return false;
        if(isHalfable(start+1, nums, target1-nums[start], target2)) {
            return true;
        } else {
            return isHalfable(start + 1, nums, target1, target2 - nums[start]);
        }
    }

    public boolean splitOdd10(int[] nums) {
        return splitThis(0, nums, 0, 0);
    }

    private boolean splitThis(int start, int[] nums, int sum1, int sum2) {
        if(start==nums.length && ((sum1%10==0 && sum2%2==1) || (sum1%2==1 && sum2%10==0))) {
            return true;
        }
        if(start>=nums.length) return false;

        return splitThis(start+1, nums, sum1+nums[start], sum2)
                || splitThis(start+1, nums, sum1, sum2+nums[start]);
    }


    public boolean split53(int[] nums) {
        return splitFitty(0, nums, 0, 0);
    }
    private boolean splitFitty(int start, int[] nums, int sum1, int sum2) {
        if(start==nums.length && sum1==sum2) return true;
        if(start>=nums.length) return false;

        if(nums[start]%5==0) return splitFitty(start+1, nums, sum1+nums[start], sum2);
        if(nums[start]%3==0) return splitFitty(start+1, nums, sum1, sum2+nums[start]);

        return splitFitty(start+1, nums, sum1, sum2+nums[start])
                || splitFitty(start+1, nums, sum1+nums[start], sum2);
    }



}