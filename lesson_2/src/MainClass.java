public class MainClass {

    public static void main(String[] args) {
        String [][] strArr = new String [4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                strArr[i][j] = "10";
            }
        }

        ArrayConvert arrayConvert = new ArrayConvert(strArr);
        System.out.println(arrayConvert.convertAndSum());
    }

}