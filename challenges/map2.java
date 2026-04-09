import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Map2 {
    public static void main(String[] args) {

    }

    public Map<String, Integer> word0(String[] strings) {
        Map<String, Integer> out = new HashMap<>();
        for(String s : strings){
            out.put(s, 0);
        }
        return out;
    }

    public Map<String, Integer> wordLen(String[] strings) {
        Map<String, Integer> out = new HashMap<>();
        for(String s: strings) {
            out.put(s, s.length());
        }
        return out;
    }

    public Map<String, String> pairs(String[] strings) {
        Map<String, String> out = new HashMap<>();
        for(String s : strings){
            out.put(String.valueOf(s.charAt(0)),String.valueOf(s.charAt(s.length()-1)));
        }
        return out;
    }

    public Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> out = new HashMap<>();
        for(String s : strings) {
            int temp = out.getOrDefault(s, 0);
            out.put(s, temp+1);
        }
        return out;
    }

    public Map<String, String> firstChar(String[] strings) {
        Map<String, String> out = new HashMap<>();
        for(String s: strings) {
            String cur = String.valueOf(s.charAt(0));
            if(!out.containsKey(cur)) {
                out.put(cur, s);
            } else {
                String temp = out.get(cur);
                out.replace(cur, temp+s);
            }
        }
        return out;
    }

    public String wordAppend_2(String[] strings) {
        String out = "";
        HashSet<String> isIn = new HashSet<>();
        for(String s : strings) {
            if(isIn.contains(s)) {
                isIn.remove(s);
                out += s;
            } else {
                isIn.add(s);
            }
        }
        return out;
    }



    public String wordAppend(String[] strings) {
        HashMap<String, Integer> map = new HashMap();
        String out = "";
        for(String s: strings){
            if(!map.containsKey(s)){
                map.put(s,1);
            } else {
                int temp = map.get(s);
                map.replace(s,temp+=1);
                if(temp+1>=2 && temp%2==0){
                    out += s;
                }
            }
        }
        return out;
    }

    public Map<String, Boolean> wordMultiple(String[] strings) {
        HashMap<String, Boolean> out = new HashMap<>();
        for(String s : strings) {
            if(out.containsKey(s)) out.replace(s, true);
            else out.put(s, false);
        }
        return out;
    }

    public String[] allSwap(String[] strings) {
        HashMap<String, Integer> firsts = new HashMap<>();
        for(int i = 0; i < strings.length; i++) {
            String cur = String.valueOf(strings[i].charAt(0));
            if(firsts.containsKey(cur)) {
                int firstIndex = firsts.get(cur);
                String swap = strings[firstIndex];
                strings[firstIndex] = strings[i];
                strings[i]=swap;
                firsts.remove(cur);
            } else {
                firsts.put(cur, i);
            }
        }
        return strings;
    }

    public String[] firstSwap(String[] strings) {
        HashMap<String, Integer> firsts = new HashMap<>();
        for(int i = 0; i < strings.length; i++) {
            String cur = String.valueOf(strings[i].charAt(0));
            if(firsts.containsKey(cur) && firsts.get(cur)==-1) continue;
            if(firsts.containsKey(cur)) {
                int firstIndex = firsts.get(cur);
                String swap = strings[firstIndex];
                strings[firstIndex] = strings[i];
                strings[i]=swap;
                firsts.put(cur,-1);
            } else {
                firsts.put(cur, i);
            }
        }
        return strings;
    }




}