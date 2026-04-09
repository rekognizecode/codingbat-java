import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

// TODO:  userCompare
class Ap1 {
    public static void main(String[] args) {
        int val = -1667;
        System.out.println(hasOne(val));
        System.out.println(hasOne_Recursive(val));
    }

    public boolean scoresIncreasing(int[] scores) {
        int formerMin = Integer.MIN_VALUE;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < formerMin) {
                return false;
            }
            formerMin = scores[i];
        }
        return true;
    }

    public static boolean scores100(int[] scores) {
        for (int i = 1; i < scores.length - 1; i++) {
            if (scores[i] == 100 && (scores[i - 1] == 100 || scores[i + 1] == 100)) {
                return true;
            }
        }
        return false;
    }

    public boolean scoresClump(int[] scores) {
        if (scores.length < 3) return false;
        for (int i = 0; i < scores.length - 2; i++) {
            int diffToNext = Math.abs(scores[i] - scores[i + 1]);
            int diffToSecond = Math.abs(scores[i] - scores[i + 2]);
            int diffNextToSecond = Math.abs(scores[i + 1] - scores[i + 2]);

            if (diffToNext < 3 && diffToSecond < 3 && diffNextToSecond < 3) {
                return true;
            }
        }
        return false;
    }

    public int scoresAverage(int[] scores) {
        int firstSum = 0;
        int secondSum = 0;
        for (int i = 0; i < scores.length; i++) {
            if (i < scores.length / 2) {
                firstSum += scores[i];
            } else {
                secondSum += scores[i];
            }
        }
        return Math.max(firstSum / (scores.length / 2), secondSum / (scores.length / 2));
    }

    public int wordsCount(String[] words, int len) {
        int count = 0;
        for (String w : words) {
            if (w.length() == len) count++;
        }
        return count;
    }

    public int wordsCount_Stream(String[] words, int len) {
        return (int) Arrays.stream(words).filter(w -> w.length() == len).count();
    }

    public String[] wordsFront(String[] words, int n) {
        return Arrays.stream(words).limit(n).toArray(String[]::new);
        //return Arrays.stream(words).limit(n).toArray(val->new String[val]);
    }

    public List wordsWithoutList(String[] words, int len) {
        return Arrays.stream(words)
                .filter(w -> w.length() != len)
                .collect(Collectors.toList());
    }

    public static boolean hasOne(int n) {
        if (n == 0) return false;
        if (n % 10 == 1 || n % 10 == -1) {
            return true;
        }
        return hasOne(n / 10);
    }

    public static boolean hasOne_Recursive(int n) {
        while (n != 0) {
            if (n % 10 == 1 || n % 10 == -1) return true;
            n /= 10;
        }
        return false;
    }

    public boolean dividesSelf(int n) {
        int temp = n;
        while (temp != 0) {
            if (temp % 10 == 0 || n % (temp % 10) != 0) return false;
            temp /= 10;
        }
        return true;
    }


    public int[] copyEvens(int[] nums, int count) {
        int[] out = new int[count];
        int outIndex = 0;
        for (int i = 0; i < nums.length && outIndex < count; i++) {
            if (nums[i] % 2 == 0) out[outIndex++] = nums[i];
        }
        return out;
    }

    public int[] copyEvens_Stream(int[] nums, int count) {
        return Arrays.stream(nums).filter(n -> n % 2 == 0).limit(count).toArray();
    }

    public int[] copyEndy(int[] nums, int count) {
        return Arrays.stream(nums)
                .filter(v -> (0 <= v && v <= 10) || (90 <= v && v <= 100))
                .limit(count).toArray();
    }

    public int matchUp(String[] a, String[] b) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals("") && !b[i].equals("")
                    && a[i].charAt(0) == b[i].charAt(0)) {
                count++;
            }
        }
        return count;
    }


    public int scoreUp(String[] key, String[] answers) {
        int points = 0;
        for (int i = 0; i < key.length; i++) {
            if (answers[i].equals("?")) {
                continue;
            }
            if (answers[i].equals(key[i])) {
                points += 4;
            } else {
                points -= 1;
            }
        }
        return points;
    }


    public String[] wordsWithout(String[] words, String target) {
        return Arrays.stream(words).filter(w -> !w.equals(target)).toArray(String[]::new);
    }

    public int scoresSpecial(int[] a, int[] b) {
        int bigA = findBiggest(a);
        int bigB = findBiggest(b);
        return bigA + bigB;
    }

    public int findBiggest(int[] in) {
        int max = 0;
        for (int i : in) {
            if (i > 0 && i % 10 == 0) {
                max = i > max ? i : max;
            }
        }
        return max;
    }


    public int sumHeights(int[] heights, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            int diff = Math.abs(heights[i] - heights[i + 1]);
            sum += diff;
        }
        return sum;
    }

    public int sumHeights_Recursive(int[] heights, int start, int end) {
        int sum = 0;
        if (start == end) return 0;
        sum += Math.abs(heights[start] - heights[start + 1]);
        return sum + sumHeights_Recursive(heights, start + 1, end);
    }


    public int sumHeights2(int[] heights, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            int diff = heights[i] - heights[i + 1];
            if (diff < 0) {
                diff = Math.abs(diff << 1);
            }
            sum += diff;
        }
        return sum;
    }

    // TODO: userCompare

    public int bigHeights(int[] heights, int start, int end) {
        int count = 0;
        for(int i = start; i < end; i++) {
            if(Math.abs(heights[i]-heights[i+1])>4) {
                count++;
            }
        }
        return count;
    }


    public String[] mergeTwo(String[] a, String[] b, int n) {
        String[] out = new String[n];
        int indexA = 0;
        int indexB = 0;
        String lastAdded = a[0].codePointAt(0)<b[0].codePointAt(0)?
                a[indexA++] : b[indexB++];
        out[0] = lastAdded;
        for (int i = 1; i < n; i++) {
            if (a[indexA].codePointAt(0)<=lastAdded.codePointAt(0)) indexA++;
            if (b[indexB].codePointAt(0)<=lastAdded.codePointAt(0)) indexB++;
            if (a[indexA].codePointAt(0) < b[indexB].codePointAt(0)) {
                lastAdded = a[indexA++];
            } else {
                lastAdded = b[indexB++];
            }
            out[i] = lastAdded;
        }
        return out;
    }


    public int commonTwo(String[] a, String[] b) {
        int iA = 0;
        int iB = 0;
        int count = 0;
        String lastAdded = "";
        while(iA<a.length&&iB<b.length) {
            if (a[iA].equals(b[iB])) {
                if (!a[iA].equals(lastAdded)) {
                    lastAdded = a[iA];
                    count++;
                }
                iA++;
                iB++;
            } else if (a[iA].codePointAt(0) < b[iB].codePointAt(0)) {
                iA++;
            } else {
                iB++;
            }
        }
        return count;
    }


}
