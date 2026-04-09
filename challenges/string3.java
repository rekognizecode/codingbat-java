class String3 {
    public static void main(String[] args) {

    }


    public int countYZ(String str) {
        int count = 0;
        for(int i = 0; i<str.length(); i++){
            char current = str.charAt(i);
            if(i==0) {
                if(isYorZ(current) && !Character.isLetter(str.charAt(i+1))) {
                        count++;
                }
            } else if (i==str.length()-1) {
                if(isYorZ(current)) {
                    count++;
                }
            } else {
                if(isYorZ(current) && !Character.isLetter(str.charAt(i+1))) {
                    count++;
                }
            }
        }
        return count;
    }
    public boolean isYorZ(char c) {
        return c=='y'||c=='z'||c=='Y'||c=='Z';
    }


    public String withoutString(String base, String remove) {
        String out ="";
        for(int i = 0; i<base.length();i++){
            if(i+remove.length()>base.length()) {
                out+=base.substring(i);
                break;
            }
            if(base.substring(i,i+remove.length()).equalsIgnoreCase(remove)){
                i+=remove.length()-1;
            } else {
                out+=base.charAt(i);
            }
        }
        return out;
    }


    public boolean equalIsNot(String str) {
        if(!str.contains("is")&&!str.contains("not")) {
            return true;
        }
        if((str.contains("is")&&!str.contains("not")) || (!str.contains("is")&&str.contains("not"))) {
            return false;
        }
        return equalIsNot(str.replaceFirst("is","").replaceFirst("not",""));
    }


    public boolean gHappy(String str) {
        if(str.length()==1) return false;
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i)=='g') {
                if(i<str.length()-1) {
                    if(str.charAt(i-1)!='g'&&str.charAt(i+1)!='g') {
                        return false;
                    }
                } else {
                    return str.charAt(i - 1) == 'g';
                }
            }
        }
        return true;
    }


    public int countTriple(String str) {
        if(str.length()<3) return 0;
        int count = 0;
        for (int i = 0; i < str.length()-2; i++) {
            if (str.charAt(i)==str.charAt(i+1)&&str.charAt(i+2)==str.charAt(i+1)) {
                count++;
            }
        }
        return count;
    }



    public int sumDigits(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) {
                sum+=Integer.parseInt(String.valueOf(str.charAt(i)));
            }
        }
        return sum;
    }


    public String sameEnds(String string) {
        String out ="";
        for(int i = 1; i<string.length();i++) {
            String current = string.substring(0,i);
            if(string.replaceFirst(current, "").contains(current)) {
                out = current;
            }
        }
        return out;
    }



    public String mirrorEnds(String string) {
        String out ="";
        for(int i = 0; i<string.length();i++){
            char start = string.charAt(i);
            char end = string.charAt(string.length()-1-i);
            if(start==end){
                out+=start;
            } else {
                return out;
            }
        }
        return out;
    }



    public int maxBlock(String str) {
        if(str.length()==0) return 0;
        int max = 0;
        char former = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            int currentMax = 1;
            while(i<str.length()&&str.charAt(i)==former) {
                currentMax++;
                i++;
            }
            if(i<str.length()-1) {
                former = str.charAt(i);
            }
            max = Math.max(max, currentMax);
        }
        return max;
    }



    public int sumNumbers(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            String currentNr = "0";
            while(i<str.length()&&Character.isDigit((str.charAt(i)))) {
                currentNr+=str.charAt(i);
                i++;
            }
            sum += Integer.parseInt(currentNr);
        }
        return sum;
    }


    // ! almost
    public String notReplace(String str) {
        String out = "";
        if(str.length()<2) return str;
        if(str.equals("is")) return "is not";
        for (int i = 0; i < str.length(); i++) {
            if(i==0) {
                if(str.startsWith("is")&& !Character.isLetter(str.charAt(2))) {
                    out += "is not";
                    i++;
                } else {
                    out += str.charAt(i);
                }
            } else if (i<str.length()-2) {
                if (str.charAt(i) == 'i' && str.charAt(i + 1) == 's'
                        && !Character.isLetter(str.charAt(i + 2))
                        && !Character.isLetter(str.charAt(i - 1))) {
                    out += "is not";
                    i++;
                } else {
                    out += str.charAt(i);
                }
            } else if (i==str.length()-2) {
                if (str.charAt(i) == 'i' && str.charAt(i + 1) == 's'
                        && !Character.isLetter(str.charAt(i - 1))) {
                    out += "is not";
                    i++;
                } else {
                    out += str.charAt(i);
                }
            } else {
                return out+str.substring(i);
            }
        }
        return out;
    }


}