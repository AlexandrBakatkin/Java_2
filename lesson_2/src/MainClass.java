public class MainClass {

    public static void main(String[] args) {

        //Создаем массив 4 х 4 или любого другого размера

        String [][] strArr = new String [4][4];

        //Заполняем массив одинаковыми строковыми элементами для простоты

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                strArr[i][j] = "10";
            }
        }
        //Для проверки работы исключения убираем комментарии со следующей строки ;-)

        //strArr[1][3] = "k";

        ArrayConvert arrayConvert = new ArrayConvert(strArr);
        System.out.println(arrayConvert.convertAndSum());
    }

}