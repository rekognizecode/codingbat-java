import java.util.List;
import java.util.stream.Collectors;

class Functional1 {
    public static void main(String[] args) {

    }

    public List<Integer> doubling(List<Integer> nums) {
        return nums.stream().map((v)->v*2).collect(Collectors.toList());
    }

    public List<Integer> square(List<Integer> nums) {
        return nums.stream().map((v)->v*v).collect(Collectors.toList());
    }

    public List<String> addStar(List<String> strings) {
        return strings.stream().map(s->s+"*").collect(Collectors.toList());
    }

    public List<String> copies3(List<String> strings) {
        return strings.stream().map(s->s+s+s).collect(Collectors.toList());
    }

    public List<String> moreY(List<String> strings) {
        return strings.stream().map(s->"y"+s+"y").collect(Collectors.toList());
    }

    public List<Integer> math1(List<Integer> nums) {
        return nums.stream().map(v->(v+1)*10).collect(Collectors.toList());
    }

    public List<Integer> rightDigit(List<Integer> nums) {
        return nums.stream().map(v->v%10).collect(Collectors.toList());
    }

    public List<String> lower(List<String> strings) {
        return strings.stream().map(v->v.toLowerCase()).collect(Collectors.toList());
    }

    public List<String> noX(List<String> strings) {
        return strings.stream().map(v->v.replace("x", "")).collect(Collectors.toList());
    }





}