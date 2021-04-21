package home_work_3_Hanoi;

import java.util.Scanner;

public class HanoiTowersManual implements ITowers{
    // переменная будет считать количество сделанных ходов
    private byte movesCount;

    public byte getMovesCount() {
        return movesCount;
    }

    /**
     * Метод запрашивает у пользователя информацию о том, с какой башни на какую переместить кольцо. Проверяет
     * правильность введенных данных, можно ли сделать такой ход, а также разрешен ли ход правилами игры.
     * Если все условия соблюдены - перемещает кольцо.
     * @param arr передаваемый массив с данными о текущем положении колец на башнях
     */
    public void moveRings(byte[][] arr){
        byte rodFrom;
        byte rodTo;

        System.out.println("Делайте ход!");
        while (true){
            byte upperRingFirst;
            byte upperRingSecond;
            System.out.println("С какой башни снять кольцо?");
            rodFrom = checkInputRodNumber(arr);
            upperRingFirst = findUpperRing(arr, rodFrom);
            if (upperRingFirst != 0){
                System.out.println("На какую башню повесить кольцо?");
                rodTo = checkInputRodNumber(arr);
                upperRingSecond = findUpperRing(arr, rodTo);

                // проверяем, можно ли сделать такой ход.
                if (rodTo == rodFrom){
                    System.out.println("Вы ввели тот же номер башни, такой ход сделать нельзя. Сделайте другой ход.");
                }else if (upperRingFirst > upperRingSecond && upperRingSecond!=0){
                    System.out.println("Такой ход запрещен правилами игры! Сделайте другой ход.");
                }else{
                    break;
                }
            }else{
                System.out.println("На этой башне ничего нет! Попробуйте еще раз.");
            }
        }

        // перемещаем кольцо с одной башни на другую
        ringsMoving(arr, rodFrom, rodTo);
    }

    /**
     * Перемещает верхнее кольцо с одной башни на другую.
     * @param arr данные о текущем положении башень, в которые будут вносится изменения
     * @param rodFrom номер башни, с которой перемещается кольцо
     * @param rodTo номер башни, на которую перемещается кольцо
     */
    public void ringsMoving(byte[][] arr, int rodFrom, int rodTo){
        int a = rodFrom - 1;
        int b = rodTo - 1;
        byte ringSize = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][a] > 0){
                ringSize = arr[i][a];
                arr[i][a] = 0;
                break;
            }
        }
        for (int j = arr.length-1; j >= 0; j--){
            if (arr[j][b] == 0){
                arr[j][b] = ringSize;
                break;
            }
        }
        // засчитываем ход в "счетчик"
        this.movesCount++;
    }

    /**
     * Возвращает значение (размер) верхнего кольца на обозначенном номере башни. Если колец на этой башне нет -
     * возвращает 0.
     * @param arr данные о текущем положении башень
     * @param rodNumber номер башни, на которой ищем кольцо
     * @return размер верхнего кольца
     */
    public byte findUpperRing(byte[][] arr, byte rodNumber){
        byte upperRing = 0;
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[i][rodNumber-1] > 0){
                upperRing = arr[i][rodNumber-1];
                break;
            }
        }
        return upperRing;
    }

    /**
     * Позволяет ввести номер столбца башни, с которым нужно взаимодействовать. Проверяет, существует ли башня с
     * таким номером в текущей игре, и правильно ли введены данные в целом.
     * @param arr данные о текущем положении башень
     * @return возвращаемый номер башни, прощедший проверку
     */
    public byte checkInputRodNumber(byte[][] arr){
        byte inputRodNumber;
        Scanner userInput = new Scanner(System.in);
        while(true) {
            if (userInput.hasNextByte()) {
                inputRodNumber = userInput.nextByte();
                if (inputRodNumber > 0 && inputRodNumber <= arr[0].length) {
                    break;
                } else {
                    System.out.println("Нет башни с таким номером! Попробуйте еще раз.");
                }
            } else {
                System.out.println("Введены неверные данные, попробуйте еще раз.");
                userInput.next();
            }
        }
        return inputRodNumber;
    }
}
