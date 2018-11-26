public class ArrayConvert {

    private String [][] strArray;

    public ArrayConvert(String[][] strArray) {
        this.strArray = strArray;

        if (strArray.length != 4 || strArray[0].length != 4){
            throw new MySizeArrayException("Массив иного размера, чем 4 х 4");
        }
    }

    public int convertAndSum (){
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum = sum + Integer.parseInt(strArray[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException("Ошибка в ячейке " + i + " " + j);
                }
            }
        }
        return sum;
    }
}