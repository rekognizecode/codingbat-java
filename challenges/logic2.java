class Logic2 {
    public static void main(String[] args) {
        System.out.println(String.valueOf(makeBricks(1000, 1000, 10000)));

    }

    public static boolean makeBricks(int small, int big, int goal) {
        if(big==-1||small==-1){
            return false;
        }
        if(big>goal) {
            return false;
        }
        if(small+big*5==goal) {
            return true;
        } else if(makeBricks(small,big-1,goal)||makeBricks(small-1,big,goal)){
            return true;
        }
        return false;
    }


}