import java.util.ArrayList;


class Recursion1 {
    public static void main(String[] args) {
       /*
       long start = System.currentTimeMillis();
       long fact = 0;
        for (int i = 1; i <= 10000; i++) {
            fact = powerN(2,i)-1;
        }
        System.out.println(System.currentTimeMillis()-start);
        System.out.println(fact);
        start = System.currentTimeMillis();
        fact = 0;
        for (int i = 1; i <= 10000; i++) {
            fact = powerN2(2,i)-1;
        }
       System.out.println(System.currentTimeMillis()-start);
        System.out.println(fact);*/

       // testParenthesisChecker();

    }


    public static void testParenthesisChecker() {
        String[] nestedBrackets = {
                "(()())",
                "(()(()))",
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
    public static long factorial(long n) {
        return n>2? n * factorial(n-1) : n;
    }


    public static long powerN(long base, long n) {
        if(n==1) return n * base;
        return base * powerN(base, n-1);
    }
    public static long powerN2(long base, long n) {
        long tempBase = base;
        for (; n > 1; n--) {
            base *= tempBase;
        }
        return base;
    }
    public int count7(int n) {
        if(n==0) return 0;

        int count = 0;
        if(n%10==7) count++;

        return count + count7(n/10);
    }

    public int count8(int n) {
        if(n<=0) return 0;
        int count = 0;

        if(n%10 == 8 && n%100 - n%10 == 80) {
            count+=2;
        } else if(n%10==8) {
            count++;
        }
        count+=count8(n/10);
        return count;
    }

    public int countX(String str) {
        int count = 0;
        if(str.length()==0) {return count;}
        if(str.startsWith("x")) {
            count++;
        }
        count+=countX(str.substring(1));
        return count;
    }


    public int countHi(String str) {
        if(str.length()==0) return 0;
        int count = 0;
        if(str.startsWith("hi")) {
            count++;
            count += countHi(str.substring(2));
        } else {
            count += countHi(str.substring(1));
        }
        return count;
    }

    public String changeXY(String str) {
        String out = "";
        if(str.length()==0) return "";

        if(str.startsWith("x")) {
            out+="y";
        } else {
            out+=str.substring(0,1);
        }
        out+=changeXY(str.substring(1));
        return out;
    }

    public String changePi(String str) {
        if(str.length()==0) return str;
        String out = "";
        if(str.startsWith("pi")) {
            out += 3.14;
            out += changePi(str.substring(2));
        } else {
            out += str.charAt(0);
            out += changePi(str.substring(1));
        }
        return out;
    }

    public String noX(String str) {
        if(str.length()==0) return "";
        String out = "";

        if(str.charAt(0)=='x') out += noX(str.substring(1));
        else out += str.charAt(0) + noX(str.substring(1));

        return out;
    }



    public boolean array6(int[] nums, int index) {
        if(index == nums.length) return false;
        if(nums[index]==6) return true;

        return array6(nums, index+1);
    }

    public int array11(int[] nums, int index) {
        int count = 0;
        if(index==nums.length) return 0;
        if(nums[index]==11) count++;

        return count + array11(nums, ++index);
    }

    public boolean array220(int[] nums, int index) {
        if(index+1>=nums.length) {return false;}
        if(nums[index]*10==nums[index+1]) {return true;}

        return array220(nums, index+1);
    }

    public String allStar(String str) {
        if(str.length()==0) return "";
        if(str.length()==1) return str;
        String out = "";
        out+=str.substring(0,1) + "*";
        out+=allStar(str.substring(1));
        return out;
    }

    public String pairStar(String str) {
        if(str.length()==0) return "";
        if(str.length()==1) return str;
        String out = "";
        if(str.charAt(0)==str.charAt(1)) {
            out+=str.charAt(0)+"*";
        } else {
            out+=str.charAt(0);
        }
        out+=pairStar(str.substring(1));
        return out;
    }

    public String endX(String str) {
        if(str.length()==0) return "";
        String out = "";
        if(str.charAt(0)=='x') out += endX(str.substring(1)) + "x";
        else out += str.charAt(0) + endX(str.substring(1));
        return out;
    }

    public String endX_2(String str) {
        if(str.length()==0) return "";
        if(str.charAt(0)=='x')
            return endX_2(str.substring(1)) + "x";
        else
            return str.charAt(0) + endX_2(str.substring(1));
    }


    public int countPairs(String str) {
        if(str.length()<=2) return 0;
        int count = 0;

        if(str.charAt(0)==str.charAt(2)){
            count++;
        }
        count+=countPairs(str.substring(1));
        return count;
    }

    public int countAbc(String str) {
        if(str.length()<3) return 0;
        int count = 0;
        if(str.startsWith("aba")||str.startsWith("abc")) {
            count++;
        }
        count += countAbc(str.substring(1));
        return count;
    }

    public int count11(String str) {
        if(str.length()<=1) return 0;
        int count =0;
        if(str.startsWith("11")){
            count++;
            count+=count11(str.substring(2));
        } else {
            count+=count11(str.substring(1));
        }
        return count;
    }

    public String stringClean(String str) {
        if(str.length()<=1) return str;
        String out ="";

        if(str.charAt(0)!=str.charAt(1)) {
            out += str.charAt(0);
        }
        out += stringClean(str.substring(1));
        return out;
    }

    /*public int countHi2(String str) {
        if(str.length()<2) return 0;
        int count = 0;

        if(str.startsWith("xhi")) {
            count += countHi2(str.substring(3));
        } else {
            if(str.startsWith("hi")){
                count++;
            }
            count += countHi2(str.substring(1));
        }
        return count;
    }*/
    public int countHi2(String str) {
        if(str.length()<2) return 0;
        int count = 0;

        if(str.startsWith("xhi")) {
            count += countHi2(str.substring(3));
        } else if(str.startsWith("hi")){
            count++;
            count += countHi2(str.substring(2));
        } else {
            count += countHi2(str.substring(1));
        }
        return count;
    }


    public String parenBit(String str) {

        if(!str.startsWith("(")) {
            str = parenBit(str.substring(1));
        }
        if(!str.endsWith(")")) {
            str = parenBit(str.substring(0, str.length()-1));
        }
        return str;
    }


    public static boolean nestParen(String str) {
        if(str.length() == 0) return true;

        if(!str.startsWith("(")) {
            str = str.substring(1);
        }
        if(!str.endsWith(")")) {
            str = str.substring(0,str.length()-1);
        }
        if(str.startsWith("(")&&str.endsWith(")")) {
            return nestParen(str.substring(1,str.length()-1));
        }
        return false;
    }

    public static boolean nestParenGPT(String str) {
        if (str.length() == 0) {
            return true;
        }

        if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
            return nestParenGPT(str.substring(1, str.length() - 1));
        }
        return false;
    }

    // my own little challenge, also works for non-symmetrical nested parentheses
    // mix of recursion and iteration
    public static boolean parenthesisChecker(String str) {
        if(str.length()==0) return true;

        if(str.startsWith("()")) return parenthesisChecker(str.substring(2));
        else if(str.startsWith("(")) {
            int bracketsOpen = 0;
            for (int i = 1; i < str.length(); i++) {
                if(str.charAt(i)=='(') {
                    bracketsOpen++;
                } else if (bracketsOpen>0 && str.charAt(i)==')') {
                    bracketsOpen--;
                } else if(bracketsOpen==0 && str.charAt(i)==')') {
                    return parenthesisChecker(str.substring(1,i)
                                        + str.substring(i+1));
                }
            }
        }
        return false;
    }

    // TODO: implement purely recursive version
    public static boolean parenthesisChecker_Rec(String str) {
        if(str.length()==0) return true;


        return false;
    }


    public static boolean testNestParenGPT() {
        String[] testCases = {
                "x()y",
                "x()"
        };
        boolean[] results = {
                true,
                true
        };
        for (int i = 0; i < testCases.length; i++) {
        if(nestParenGPT(testCases[i])==results[i])
            System.out.println("All good");
        return true;
        }
            return false;
    }

    public int strCount(String str, String sub) {
        if(str.length()<sub.length()) return 0;
        int count = 0;

        if(str.startsWith(sub)) {
            count++;
            count += strCount(str.substring(sub.length()), sub);
        } else {
            count += strCount(str.substring(1), sub);
        }
        return count;
    }

    public boolean strCopies(String str, String sub, int n) {
        if(str.length()<sub.length() && n>0) return false;
        if(str.length()<sub.length() && n==0) return true;

        if(str.startsWith(sub)) {
            return strCopies(str.substring(1), sub, n-1);
        } else {
            return strCopies(str.substring(1), sub, n);
        }
    }

    public int strDist(String str, String sub) {
        if(str.length()<sub.length()) return 0;
        if(!str.startsWith(sub)) {
            return strDist(str.substring(1), sub);
        } else if (!str.endsWith(sub)){
            return strDist(str.substring(0,str.length()-1), sub);
        } else {
            return str.length();
        }
    }

}