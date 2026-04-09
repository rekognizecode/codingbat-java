import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

class Array3 {
    public static void main(String[] args) {
//        runTests();
//        maxSpan(new int[]{1, 2, 4, 2});

        //fix45(new int[]{5, 4, 9, 4, 9, 5});
        fix45(new int[]{5, 4, 5, 4, 1});
    }

    public static int maxSpan(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> myMap = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            if(!myMap.containsKey(nums[i])) {
                ArrayList<Integer> entry = new ArrayList<>(2);
                entry.add(0, i);
                entry.add(1, i);
                myMap.put(nums[i], entry);
            } else {
                int firstHit = myMap.get(nums[i]).get(0);
                ArrayList<Integer> newHit = new ArrayList<>(2);
                newHit.add(0, firstHit);
                newHit.add(1, i);
                myMap.replace(nums[i],newHit);
            }
        }
        Collection<ArrayList<Integer>> spans = myMap.values();
        int max = 0;
        for (ArrayList<Integer> span : spans) {
            int diff= span.get(1)-span.get(0)+1;
            max = Math.max(max, diff);
        }
        return max;
    }


    public int[] fix34(int[] nums) {
        int index3 = -1;
        int index4 = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]==3) {
                index3 = i;
                for(int j = index4+1; j < nums.length; j++) {
                    if(nums[j]==4) {
                        index4 = j;
                        nums[j]=nums[index3+1];
                        nums[index3+1]=4;
                        break;
                    }
                }
            }
        }
        return nums;
    }


    public static int[] fix45(int[] nums) {
        int index4 = -1;
        int index5 = -1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i]==4&&nums[i+1]!=5) {
                index4 = i;
                for(int j =  index5+1; j < nums.length; j++){
                    if(nums[j]==4 && nums[j+1]==5) {
                        j++;
                        continue;
                    }
                    if(nums[j]==5) {
                        nums[j]=nums[index4+1];
                        nums[index4+1]=5;
                        index5 = j;
                        break;
                    }
                }
            }
        }
        return nums;
    }




    public  static void runTests() {
        // Test cases
        int[][] testCases = {
                {1, 1, 1, 2, 1},  //1 true
                {2, 1, 1, 2, 1},  //2 false
                {10,0, 10},         //3 true
                {1, 2, 3, 4, 5},  //4 false
                {1, 2, 3, 4, 10}, //5 true
                {1, 2, 3, 4, 2, 2}, //6 false
                {1, 1, 1, 1, 1, 1}, //7 true
                {2, 1, 1, 1, 1},    //8 true
                {10, 0, 1, -10},    //9 false
                {0, 0, 0, 0, 0},    //  10 true
                {1, 1, 1, 1},       // true
                {1, 2, 3, 1, 0, 2, 3} // true
        };


        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            boolean result = canBalance(nums);
            System.out.println("Test case " + (i + 1) + ": " + result);
        }
    }
    public static boolean canBalance(int[] nums) {
        int sum = 0;
        for(int i: nums){
            sum+=i;
        }
        if(sum%2==1){
            return false;
        }
        int halfSum = sum/2;
        int firstHalf = 0;
        int firstHit = 0;
        for(int i=0;i<nums.length-1;i++){
            firstHalf += nums[i];
            if(firstHalf==halfSum){
                firstHit=i;
            }
        }

        int secondHalf = 0;
        int secondHit = 0;
        for(int i = nums.length-1;i>firstHit;i--) {
            secondHalf+=nums[i];
            if(secondHalf==halfSum){
                secondHit=i;
            }
        }
        if(secondHit==firstHit+1){
            return true;
        }
        return false;
    }

    public int countClumps(int[] nums) {
        Integer last = null;
        int clumps = 0;
        boolean clump = false;
        for(int i = 0;i<nums.length;i++){
            if(last==null){
                last = nums[i];
            }
            if(last==nums[i]&&i>0){
                clump=true;
            }
            if(last!=nums[i]&&clump){
                clump=false;
                clumps++;
            }
            if(last==nums[i]&&i==nums.length-1){
                clumps++;
            }
            last = nums[i];
        }
        return clumps;
    }

    //! FINALLY
    public int[] seriesUp(int n) {
        int offset = 0;
        int curWidth = 1;
        int[] out = new int[sumUpTo(n)];
        while(curWidth<=n) {
            int i = 0;
            for (; i < curWidth ; i++) {
                out[offset+i] = i+1;
            }
            offset += i;
            curWidth++;
        }
        return out;
    }

    private int sumUpTo(int n) {
        int out = 0;
        for(int i =0; i<=n; i++) {
            out+=i;
        }
        return out;
    }
}
