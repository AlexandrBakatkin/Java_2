public class ArrayConvert {
    private String [][] strArray;

    public ArrayConvert(String[][] strArray) {
        this.strArray = strArray;
    }

    public int convertAndSum (){
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sum = sum + Integer.parseInt(strArray[i][j]);
            }
        }
        return sum;
    }
}