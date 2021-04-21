package home_work_3_Hanoi;

import java.util.Scanner;

// реализован только ручной режим работы

public class HanoiMain {
    public static void main(String[] args) {
        byte numberOfRings;
        byte numberOfRods = 3;
        byte[][] towersHanoi;
        boolean continuePlay = true;
        // нужно будет реализовать способ выбора способа игры
        ITowers move = new HanoiTowersManual();
        Scanner userInput = new Scanner(System.in);

        System.out.println("Начинаем новую игру! Введите количество колец (от 3 до 8):");

        while (true){
            if (userInput.hasNextByte()){
                numberOfRings = userInput.nextByte();
                if (numberOfRings > 2 && numberOfRings < 9){
                    break;
                }else{
                    System.out.println("Вы вышли за пределы допустимых значений! Попробуйте еще раз.");
                }
            }else{
                System.out.println("Введены неверные данные, попробуйте еще раз.");
                userInput.next();
            }
        }

        towersHanoi = new byte[numberOfRings][numberOfRods];

        fillTowersStart(towersHanoi);
        showCurrent(towersHanoi);

        while(!winGame(towersHanoi)){
            continuePlay = continueOrNot();
            if (!continuePlay){
                break;
            }
            move.moveRings(towersHanoi);
            showCurrent(towersHanoi);
        }

        if (continuePlay){
            System.out.println("Поздравляем, игра завершена! Количество ходов: " + move.getMovesCount());
            System.out.println("Перезапустите, чтобы начать заново.");
        }else{
            System.out.println("Игра окончена. Перезапустите, чтобы начать заново.");
        }
    }


    public static void fillTowersStart(byte[][] arr){
        byte firstRing = 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] += firstRing;
            firstRing++;
        }
    }

    public static void showCurrent(byte[][] arr){
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] > 0 ? (arr[i][j] + "\t") : ("*" + "\t"));
            }
            System.out.println("\b");
        }
    }

    public static boolean winGame(byte[][] arr){
        byte sumAllRings = 0;
        byte sumInRod = 0;
        boolean isWin = false;

        for (int i = 0; i < arr.length; i++) {
            sumAllRings+=(i+1);
        }

        for (int i = 1; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sumInRod += arr[j][i];
            }
            if (sumAllRings == sumInRod){
                isWin = true;
            }
            sumInRod = 0;
        }
        return (isWin);
    }

    public static boolean continueOrNot(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Продолжаем играть (д/н)?");
            String answer = input.nextLine();
            if (answer.equals("д")){
                return true;
            }else if (answer.equals("н")){
                return false;
            }else{
                System.out.println("Не понятный ответ, давайте еще раз.");
            }
        }
    }
}
