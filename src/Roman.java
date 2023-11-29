public enum Roman {
    I(1), II(2), III(3),IV(4), V(5), VI(6),VII(7),VIII(8),IX(9), X(10);

    private  int romanNum;
    Roman(int romanNum){
        this.romanNum = romanNum;
    }
    public int getRomanNum(){
        return romanNum;
    }
    public static int convertToArabic(String romanNumber) {
        Roman roman = Roman.valueOf(romanNumber);
        return roman.getRomanNum();
    }

}
