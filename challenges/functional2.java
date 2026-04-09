import java.util.List;
import java.util.stream.Collectors;

class Functional2 {
    public static void main(String[] args) {

    }

    public List<Integer> noNeg(List<Integer> nums) {
        return nums.stream().filter(v->v>=0).collect(Collectors.toList());
    }

    public List<Integer> no9(List<Integer> nums) {
        return nums.stream().filter(v->v%10!=9).collect(Collectors.toList());
    }

    public List<Integer> noTeen(List<Integer> nums) {
        return nums.stream().filter(v->v<13||v>19).collect(Collectors.toList());
    }

    public List<String> noZ(List<String> strings) {
        return strings.stream().filter(v->!v.contains("z")).collect(Collectors.toList());
    }

    public List<String> noLong(List<String> strings) {
        return strings.stream().filter(v->v.length()<4).collect(Collectors.toList());
    }

    public List<String> no34(List<String> strings) {
        return strings.stream().filter(v->v.length()!=3 && v.length()!=4).collect(Collectors.toList());
    }

    public List<String> noYY(List<String> strings) {
        return strings.stream()
                .map(s-> s + "y")
                .filter(s->!s.contains("yy"))
                .collect(Collectors.toList());
    }

    public List<Integer> two2(List<Integer> nums) {
        return nums.stream()
                    .map(v->v*2)
                    .filter(v->v%10!=2)
                    .collect(Collectors.toList());
    }

    public List<Integer> square56(List<Integer> nums) {
        return nums.stream()
                    .map(v->v*v+10)
                    .filter(v->v%10!=5 && v%10!=6)
                    .collect(Collectors.toList());
    }



}