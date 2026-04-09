class String1 {
    public static void main(String[] args) {

    }

    public String deFront(String str) {
        if(str.startsWith("ab")) {
            return str;
        }
        if(str.startsWith("a")) {
            if(str.length()<=2){
                return "a";
            } else {
                return "a" + str.substring(2);
            }
        } else if (str.substring(1).startsWith("b")) {
            return str.substring(1);
        } else {
            if(str.length()<=2) {
                return "";
            } else {
                return str.substring(2);
            }
        }
    }


    public String startWord(String str, String word) {
        if(word.length()>str.length()) return "";
        if(str.length()==1) return str;

        String strSub = str.substring(1,word.length());
        String wordSub = word.substring(1);
        if(strSub.equals(wordSub)) {
            return str.substring(0,word.length());
        }
        return "";
    }


    public String withoutX(String str) {
        if(str.length()>1) {
            if(str.replace(str.substring(1,str.length()-1),"").equals("xx")) {
                return str.substring(1,str.length()-1);
            } else if (str.startsWith("x")) {
                return str.substring(1);
            } else if (str.endsWith("x")) {
                return str.substring(0,str.length()-1);
            } else {
                return str;
            }
        } else if (str.length()==1) {
            if(str.equals("x")) {
                return "";
            }
            return str;
        }
        return "";
    }

    public String withoutX2(String str) {
        if(str.length()==1) {
            if(str.equals("x")) {
                return "";
            }
            return str;
        }
        if(str.length()>0){
            if(str.startsWith("xx")) {
                return str.substring(2);
            }
            if(str.startsWith("x")) {
                return str.substring(1);
            }
            if(str.substring(1).startsWith("x")) {
                return str.substring(0,1) + str.substring(2);
            }
            return str;
        }
        return "";
    }

}