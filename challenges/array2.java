import java.util.Arrays;

class Array2 {
    public static void main(String[] args) {

    }

    public int countEvens(int[] nums) {
        int evens = 0;
        for (int num : nums) {
            if(num%2==0) evens++;
        }
        return evens;
    }

    public int bigDiff(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return max-min;
    }

    public int centeredAverage(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum += num;
        }
        return (sum - min - max)/(nums.length-2);
    }

    public int sum13(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]==13) {
                i++;
                continue;
            }
            sum+=nums[i];
        }
        return sum;
    }

    public int sum67(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]==6) {
                while(i<nums.length && nums[i]!=7) {
                    i++;
                }
            } else {
                sum += nums[i];
            }
        }
        return sum;
    }

    public boolean lucky13(int[] nums) {
        return Arrays.stream(nums).noneMatch(v->v==1||v==3);
    }

    public boolean sum28(int[] nums) {
        return Arrays.stream(nums).filter(v->v==2).sum() == 8;
    }

    public boolean more14(int[] nums) {
        int ones = 0;
        int fours = 0;
        for(int num: nums) {
            if(num==4) fours++;
            if(num==1) ones++;
        }
        return ones > fours;
    }

    public int[] fizzArray(int n) {
        int[] out = new int[n];
        for(int i = 0; i < n;i++){
            out[i] = i;
        }
        return out;
    }

    public boolean only14(int[] nums) {
        return Arrays.stream(nums).allMatch(v->v==1||v==4);
    }

    public String[] fizzArray2(int n) {
        String[] out = new String[n];
        for(int i = 0; i < n;i++){
            out[i] = String.valueOf(i);
        }
        return out;
    }

    public boolean no14(int[] nums) {
        boolean hasOnes = false;
        boolean hasFours = false;
        for(int num : nums) {
            if(num==4) hasFours = true;
            if(num==1) hasOnes = true;
        }
        return !(hasOnes&&hasFours);
    }

    public boolean either24(int[] nums) {
        boolean twoTwo = false;
        boolean fourFour = false;
        for(int i = 0;i < nums.length-1; i++) {
            if(nums[i]==2 && nums[i+1]==2) twoTwo = true;
            if(nums[i]==4 && nums[i+1]==4) fourFour = true;
        }
        return fourFour ^ twoTwo;
    }

    public int matchUp(int[] nums1, int[] nums2) {
        int matches = 0;
        for(int i = 0; i< nums1.length; i++) {
            if(nums1[i]!=nums2[i] && Math.abs(nums1[i]-nums2[i])<3) matches++;
        }
        return matches;
    }

    public boolean has77(int[] nums) {
        for(int i = 0; i < nums.length-2; i++) {
            if((nums[i]==7 && nums[i+1]==7)
                    ||(nums[i]==7 && nums[i+2]==7)
                    ||(nums[i+1]==7 && nums[i+2]==7)) {
                return true;
            }
        }
        return false;
    }

    public boolean has12(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]==1) {
                while(i<nums.length) {
                    if(nums[i++]==2) return true;
                }
            }
        }
        return false;
    }

    public boolean modThree(int[] nums) {
        for(int i = 0; i < nums.length-2; i++){
            if(nums[i]%2==0 && nums[i+1]%2==0 && nums[i+2]%2==0) return true;
            if(nums[i]%2==1 && nums[i+1]%2==1 && nums[i+2]%2==1) return true;
        }
        return false;
    }

    public boolean haveThree(int[] nums) {
        int threes = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i==nums.length-1) {
                if(nums[i]==3) threes++;
                break;
            }
            if(nums[i]==3) {
                if(nums[i+1]==3) return false;
                threes++;
            }
        }
        return threes == 3;
    }

    public boolean twoTwo(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]==2) {
                if(i==0) {
                    if(nums.length==1 || nums[i+1]!=2) return false;
                } else if(i==nums.length-1) {
                    if(nums[i-1]!=2) return false;
                } else {
                    if(nums[i-1]!=2 && nums[i+1]!=2) return false;
                }
            }
        }
        return true;
    }

    public boolean sameEnds(int[] nums, int len) {
        for(int i = 0; i < len; i++) {
            if(nums[i] != nums[nums.length-len+i]) return false;
        }
        return true;
    }

    public boolean tripleUp(int[] nums) {
        if(nums.length<3) return false;
        for(int i = 0; i < nums.length-2; i++) {
            if(nums[i]+1==nums[i+1] && nums[i]+2==nums[i+2]) return true;
        }
        return false;
    }

    public int[] fizzArray3(int start, int end) {
        int[] out = new int[end-start];
        for(int i = 0; i < out.length; i++) {
            out[i] = i+start;
        }
        return out;
    }

    public int[] shiftLeft(int[] nums) {
        if(nums.length==0) return nums;
        int first = nums[0];
        for(int i = 0; i<nums.length-1; i++) {
            nums[i] = nums[i+1];
        }
        nums[nums.length-1] = first;
        return nums;
    }


    // !!! WTF HAPPENED HERE
    public int[] tenRun(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 10 == 0) {
                int temp = nums[i];
                while (i < nums.length) {
                    i++;
                    if (i == nums.length - 1) {
                        if (nums[i] % 10 != 0) {
                            nums[i] = temp;
                        }
                        break;
                    } else {
                        if (nums[i] % 10 != 0) {
                            nums[i] = temp;
                        } else {
                            i--;
                            break;
                        }
                    }
                }
            }
        }
        return nums;
    }


    public int[] pre4(int[] nums) {
        int  four = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==4) {
                four = i;
                break;
            }
        }
        return Arrays.stream(nums).limit(four).toArray();
    }

    public int[] post4(int[] nums) {
        int  four = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            if(nums[i]==4) {
                four = i+1;
                break;
            }
        }
        int[] out = new int[nums.length-four];
        /*
        for(int i = 0; i < out.length; i++) {
            out[i] = nums[four+i];
        }
        */
         // |
        //  v
        System.arraycopy(nums, four, out, 0, out.length);
        return out;
    }

    // ! notAlone net verstanden


    public int[] zeroFront(int[] nums) {
        int i = 0;
        int j = 1;
        while(i<nums.length && j<nums.length) {
            if(nums[i]!=0 && nums[j]==0) {
                int temp = nums[i];
                nums[j]=temp;
                nums[i]=0;
                i++;
                j++;
            } else if(nums[i]!=0 && nums[j]!=0) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        return nums;
    }

    // gpt
    public int[] withoutTen(int[] nums) {
        int frontIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]!=10) {
                nums[frontIndex]=nums[i];
                frontIndex++;
            }
        }
        for(int i = frontIndex; i < nums.length; i++) {
            nums[i]=0;
        }
        return nums;
    }


    public int[] zeroMax(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            int replace = 0;
            if(nums[i]==0) {
                for (int odd = i; odd < nums.length; odd++) {
                    if(nums[odd]%2==1) {
                        replace = Math.max(replace, nums[odd]);
                    }
                }
                nums[i] = replace;
            }
        }
        return nums;
    }

    public int[] evenOdd(int[] nums) {
        int[] out = new int[nums.length];
        int front = 0;
        int back = nums.length-1;
        for (int num : nums) {
            if (num % 2 == 0) {
                out[front++] = num;
            } else {
                out[back--] = num;
            }
        }
        return out;
    }

    public String[] fizzBuzz(int start, int end) {
        String[] out = new String[end-start];
        for(int i = 0; i < end-start; i++) {
            if((i+start)%3==0 && (i+start)%5==0) {
                out[i] = "FizzBuzz";
            } else if ((i+start)%3==0){
                out[i] = "Fizz";
            } else if((i+start)%5==0) {
                out[i] = "Buzz";
            } else {
                out[i] = String.valueOf(i+start);
            }
        }
        return out;
    }

}