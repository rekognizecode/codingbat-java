import java.util.ArrayList;

class Dynamic{
    public static void main(String[] args) {
        /*System.out.println(count7(777_777_777));
        String nested = "aa(abcd(cd()efgh(ij)kl)m)";
        System.out.println(parenBit(nested));
        System.out.println(parenBit_For(nested));*/
        testParenthesisChecker();
    }

    public static void testParenthesisChecker() {
        String[] nestedBrackets = {
                /*"(()())",
                "(()(()))",*/
                "((())(()))",
        };
        ArrayList<String> righties = new ArrayList<>();
        boolean rightiesRight = true;
        for (int i = 0; i < nestedBrackets.length; i++) {
            if(!parenthesisChecker(nestedBrackets[i])) {
                righties.add("Wrongly false: " + i);
                rightiesRight = false;
            }
        }
        if (rightiesRight) {
            System.out.println("All corrects correct");
        } else {
            for (String righty : righties) {
                System.out.println(righty);
            }
        }
        String[] faultyBrackets = {
                ")))(((",
                "()))((()",
                "(())(()))",
                "((())((()()))",
        };
        boolean wrongiesWrong = true;
        ArrayList<String> wrongies = new ArrayList<>();
        for (int i = 0; i < faultyBrackets.length; i++) {
            if(parenthesisChecker(faultyBrackets[i])) {
                wrongies.add("Wrongly true: " + i);
                wrongiesWrong = false;
            }
        }
        if (wrongiesWrong) {
            System.out.println("All wrongies wrong");
        } else {
            for (String wrongy : wrongies) {
                System.out.println(wrongy);
            }
        }


    }

    // Recursion1 as loops

    public int powerN(int base, int n) {
        int tempBase = base;
        for (; n > 1; n--) {
            base *= tempBase;
        }
        return base;
    }

    public int factorial(int n) {
        int result = 1;
        for(int i = 2; i<=n;i++){
            result*=i;
        }
        return result;
    }


    public static int count7(int n) {
        int count = 0;
        for (int i = 0; i <= n+1; i++) {
            if(n%10==7) {
                count++;
            }
            n /= 10;
        }
        return count;
    }


    public int count8(int n){
        int count = 0;
        while(n>0){
            if(n%10 == 8 && n%100-n%10==80){
                count+=2;
                n/=10;
            } else if(n%10==8) {
                count++;
                n/=10;
            } else {
                n/=10;
            }
        }
        return count;
    }

    public int powerN_2(int base, int n) {
        int temp = base;
        for(int i = 1; i<n; i++) {
            base*=temp;
        }
        return base;
    }

    public int countX(String str) {
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='x') count++;
        }
        return count;
    }

    public int countHi(String str) {
        int count = 0;
        for(int i = 0; i+1<str.length(); i++){
            if(str.charAt(i)=='h'&&str.charAt(i+1)=='i')
                count++;
        }
        return count;
    }

    public String changeXY(String str) {
        char[] out = str.toCharArray();
        for (int i = 0; i < out.length; i++) {
            if(out[i]=='x') out[i]='y';
        }
        return String.valueOf(out);
    }

    public String changePi(String str) {
        String out = "";
        for (int i = 0; i < str.length(); i++) {
            if(i<str.length()-1 && str.charAt(i)=='p' && str.charAt(i+1)=='i') {
                out+="3.14";
                i++;
            } else {
                out+=str.charAt(i);
            }
        }
        return out;
    }

    public String noX(String str) {
        String out = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)!='x') out += str.charAt(i);
        }
        return out;
    }

    public boolean array6(int[] nums, int index) {
        for(; index<nums.length;index++) {
            if(nums[index]==6) return true;
        }
        return false;
    }

    public int array11(int[] nums, int i) {
        int count = 0;
        for(; i < nums.length; i++) {
            if(nums[i]==11) count++;
        }
        return count;
    }

    public boolean array220(int[] nums, int i) {
        for(;i<nums.length-1; i++)
            if(nums[i+1]==nums[i]*10) return true;
        return false;
    }

    public String pairStar(String str) {
        String out = "";
        for (int i = 0; i < str.length(); i++) {
            if(i<str.length()-1&&str.charAt(i)==str.charAt(i+1))
                out += str.charAt(i) + "*";
            else
                out += str.charAt(i);
        }
        return out;
    }

    public String endX_simple(String str) {
        String out = "";
        int xCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='x') xCount++;
            else out+=str.charAt(i);
        }
        return out + repeatx(xCount);
    }
    public String repeatx(int x) {
        String out = "";
        for(int i = 0; i < x; i++) {
            out+="x";
        }
        return out;
    }

    public String endX(String str) {
        char[] chars = str.toCharArray();
        int i = 0, j = 1;
        while(i<chars.length && j<chars.length) {
            if(chars[i]=='x' && chars[j]!='x') {
                chars[i++]=chars[j];
                chars[j++]='x';
            } else if(chars[i]=='x') {
                j++;
            } else {
                i++;
            }
        }
        return new String(chars);
    }

    public int countPairs(String str) {
        int count = 0;
        for (int i = 0; i < str.length()-2; i++) {
            if(str.charAt(i)==str.charAt(i+2)) count++;
        }
        return count;
    }

    public int countAbc(String str) {
        int count = 0;
        for(int i = 0; i < str.length()-2; i++){
            if(str.charAt(i)=='a'&&str.charAt(i+1)=='b'
                    && (str.charAt(i+2)=='a' || str.charAt(i+2)=='c')) {
                count++;
                i++;
            }
        }
        return count;
    }

    public String stringClean(String str) {
        if(str.length()<2) return str;
        String out = String.valueOf(str.charAt(0));
        char former = str.charAt(0);
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i)!=former) {
                out+=str.charAt(i);
            }
            former = str.charAt(i);
        }
        return out;
    }

    public int countHi2(String str) {
        int count = 0;
        if(str.startsWith("hi")) count++;
        for(int i = 0; i < str.length()-2; i++) {
            if(str.charAt(i)!='x' && str.charAt(i+1)=='h' && str.charAt(i+2)=='i')
                count++;
        }
        return count;
    }

     /*
        also works for nested parenthesis, but doesn't check if there are
        enough closing brackets, will add as long as there aren't more
        closing brackets than opening brackets
     */
    public static String parenBit(String str) {
        String out = "";
        int bracketsOpen = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='(') {
                out += str.charAt(i);
                bracketsOpen++;
                i++;
                while(i<str.length() && bracketsOpen>0) {
                    if(str.charAt(i)==')') {
                        out += str.charAt(i);
                        bracketsOpen--;
                        i++;
                    } else if(str.charAt(i)=='(') {
                        out += str.charAt(i);
                        bracketsOpen++;
                        i++;
                    } else {
                        out += str.charAt(i++);
                    }
                }
            }
        }
        return out;
    }

    public static String parenBit_For(String str) {
        String out = "";
        int bracketsOpen = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='(') {
                out += str.charAt(i);
                bracketsOpen++;
                i++;
                for(;i<str.length() && bracketsOpen>0; i++) {
                    if(str.charAt(i)==')') {
                        out += ")";
                        bracketsOpen--;
                    } else if(str.charAt(i)=='(') {
                        out += str.charAt(i);
                        bracketsOpen++;
                    } else {
                        out += str.charAt(i);
                    }
                }
            }
        }
        return out;
    }

    // just checks for symmetrical brackets, still valid solution
    public boolean nestParen(String str) {
        if(str.length()%2==1) return false;
        for(int i = 0; i < str.length()/2; i++) {
            if(!(str.charAt(i)=='(' && str.charAt(str.length()-1-i)==')')) {
                return false;
            }
        }
        return true;
    }


    // probably not really efficient due to the lookup of matching bracket
    // and all the string manipulation
    public static boolean parenthesisChecker(String str) {
        while (str.length()>0) {
            if(str.startsWith("()")) {
                str = str.substring(2);
            } else if (str.charAt(0)=='(') {
                int bracketsOpen = 0;
                for (int i = 1; i < str.length()+1; i++) {
                    if (i==str.length()) return false;
                    if(str.charAt(i)=='(') {
                        bracketsOpen++;
                    } else if (bracketsOpen>0 && str.charAt(i)==')') {
                        bracketsOpen--;
                    } else if (bracketsOpen==0 && str.charAt(i)==')') {
                        str = str.substring(1,i) + str.substring(i+1);
                        break;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }
    /* Better:
    public static boolean parenthesisChecker(String str) {
        int bracketsOpen = 0;  // Keep track of open brackets count

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                bracketsOpen++;
            } else if (c == ')' && bracketsOpen > 0) {
                bracketsOpen--;
            } else if (c == ')' && bracketsOpen == 0) {
                return false;  // Unmatched closing parenthesis
            } else {
                return false;  // Invalid character
            }
        }
        return bracketsOpen == 0;  // All opened brackets are closed
    }

   */


    public int strCount(String str, String sub) {
        int count = 0;
        for (int i = 0; i < str.length()-sub.length()+1; i++) {
            if(str.substring(i).startsWith(sub)) {
                count++;
                i+=sub.length()-1;
            }
        }
        return count;
    }

    public boolean strCopies(String str, String sub, int n) {
        for (int i = 0; i < str.length(); i++) {
            if(str.substring(i).startsWith(sub)) n--;
            if(n==0) return true;
        }
        return false;
    }

    public int strDist(String str, String sub) {
        int firstIndex = -1;
        for(int i = 0; i<str.length(); i++) {
            if(str.substring(i).startsWith(sub)){
                firstIndex = i;
                break;
            }
        }
        for (int i = str.length()-1; firstIndex>0 && i >= 0; i--) {
            if(str.substring(i).contains(sub)) {
                if(i==firstIndex) {
                    return sub.length();
                } else {
                    return i+sub.length()-firstIndex;
                }
            }
        }
        return 0;
    }

    public int strDist_noLoop(String str, String sub) {
        int firstIndex = str.indexOf(sub);
        if(firstIndex == -1) return 0;

        int lastIndex = str.lastIndexOf(sub);
        if(firstIndex==lastIndex) return sub.length();
        return lastIndex+sub.length()-firstIndex;
    }
}