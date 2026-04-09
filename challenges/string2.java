import java.util.ArrayList;

class String2 {
    public static void main(String[] args) {
        xyzMiddle("AxyzBBB");
    }

    public int countHi(String str) {
        int count = 0;

        for (int i = 0; i < str.length()-1; i++) {
            if(str.startsWith("hi", i)) {
                count++;
            }
        }
        return count;
    }


    public boolean catDog(String str) {
        int dogs = 0;
        int cats = 0;

        for (int i = 0; i < str.length(); i++) {
            if(str.startsWith("cat", i)) cats++;
            if(str.startsWith("dog", i)) dogs++;
        }
        return dogs == cats;
    }

    public int countCode(String str) {
        int count = 0;

        for (int i = 0; i < str.length()-3; i++) {
            if(str.startsWith("co",i)&& String.valueOf(str.charAt(i + 3)).equals("e")) {
                count++;
            }
        }
        return count;
    }


    public boolean endOther(String a, String b) {
        return a.toLowerCase().endsWith(b.toLowerCase())
                || b.toLowerCase().endsWith(a.toLowerCase());
    }


    public boolean xyzThere(String str) {
        for (int i = 1; i < str.length()-2; i++) {
            if(str.startsWith("xyz",i) && !str.startsWith(".",i-1)) {
                return true;
            }
        }
        return false;
    }


    public boolean bobThere(String str) {
        for (int i = 0; i < str.length()-2; i++) {
            if(str.charAt(i)=='b'&&str.charAt(i+2)=='b') {
                return true;
            }
        }
        return false;
    }


    public boolean xyBalance(String str) {
        int indexY = -1;
        int indexX = -1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='y') indexY=i;
            if (str.charAt(i)=='x') indexX=i;
        }
        return indexY>=indexX;
    }


    public String mixString(String a, String b) {
        int maxLength = Math.max(a.length(),b.length());
        String out = "";
        for (int i = 0; i < maxLength; i++) {
            if (i>=a.length()) return out + b.substring(i);
            if (i>=b.length()) return out + a.substring(i);
            out+=a.charAt(i);
            out+=b.charAt(i);
        }
        return out;
    }


    public String repeatEnd(String str, int n) {
        String out = "";
        for (int i = 0; i < n; i++) {
            out+=str.substring(str.length()-n);
        }
        return out;
    }


    public String repeatFront(String str, int n) {
        String out = "";
        for (int i = n; i > 0; i--) {
            out+=str.substring(0,i);
        }
        return out;
    }

    public String repeatSeparator(String word, String sep, int count) {
        String out = "";

        for (int i = 0; i < count; i++) {
            out+=word;
            if (i<count-1) {
                out+=sep;
            }
        }
        return out;
    }


    public boolean prefixAgain(String str, int n) {
        return str.substring(n).contains(str.substring(0,n));
    }


    public  static boolean xyzMiddle(String str) {
        if(str.length()>5){
            String middle;
            if(str.length()%2==1) {
                middle = str.substring(str.length() / 2 - 2, str.length() / 2 + 3);
            } else {
                middle = str.substring(str.length() / 2 - 3, str.length() / 2 + 3);
            }
            return middle.substring(1,middle.length()-1).contains("xyz");
        }
        if(str.length()==5) {
            return str.substring(1, str.length()-1).contains("xyz");
        }
        return str.contains("xyz");
    }


    public String getSandwich(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.startsWith("bread",i)) {
                if(str.substring(i+5).lastIndexOf("bread")>-1) {
                    return str.substring(i+5,str.lastIndexOf("bread"));
                }
            }
        }
        return "";
    }


    public boolean sameStarChar(String str) {
        for (int i = 1; i < str.length()-1; i++) {
            if(str.charAt(i)=='*' && str.charAt(i-1)!=str.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }


    public String oneTwo(String str) {
        int changeLength = str.length()-(str.length()%3);
        String out ="";
        for (int i = 0; i < changeLength; i+=3) {
            out+=str.substring(i+1,i+3)+str.charAt(i);
        }
        return out;
    }

    // ! wrong
    public String zipZap(String str) {
        String out ="";
        for (int i = 0; i < str.length(); i++) {
            String sub = str.substring(i);
            int indexZ = sub.indexOf("z");
            int indexP = sub.indexOf("p");
            if (indexZ==-1||indexP==-1) {
                return out;
            }
            String zp = indexP==sub.length()-1? sub.substring(indexZ) : sub.substring(indexZ, indexP+1);
            int i1 = 0;
            for (i1 = 0; i1 < zp.length(); i1++) {
                if (zp.charAt(i1)=='z'||zp.charAt(i1)=='p') {
                    out+=zp.charAt(i1);
                }
            }
            i+=i1-1;
        }
        return out;
    }



    public String starOut(String str) {
        String out="";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)!='*'){
                if(i<str.length()-1) {
                    if (str.charAt(i + 1) != '*') {
                        if (i == 0) {
                            out += str.charAt(i);
                        } else if (str.charAt(i - 1) != '*') {
                            out += str.charAt(i);
                        }
                    }
                } else if (i>0 && str.charAt(i - 1) != '*'){
                    out+=str.charAt(i);
                }
            }
        }
        return out;
    }

    // corrected by Chat
    public String starOutGPT(String str) {
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '*' &&
                    (i == 0 || str.charAt(i - 1) != '*') &&
                    (i == str.length() - 1 || str.charAt(i + 1) != '*')) {
                out.append(str.charAt(i));
            }
        }
        return out.toString();
    }


    public String plusOut(String str, String word) {

        for (int i = 0; i < str.length(); i++) {
            if(str.substring(i,i+word.))
        }
    }



}