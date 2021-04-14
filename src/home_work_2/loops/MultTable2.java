package home_work_2.loops;

import utils_temp.InputCheck;

public class MultTable2 {
    public static void main(String[] args) {
        InputCheck input = new InputCheck();
        System.out.println("С какого числа начинать таблицу?");
        int startNumber = input.checkIntInput();
        System.out.println("До какого числа выводить таблицу?");
        int lastNumber = input.checkIntInput();
        System.out.println("Сколько столбиков в строку делать?");
        int columnsInRow = input.checkIntInput();
        input.close();

        /* в этой переменной хранится количество строк, рассчитанное с учетом введенных данных о начальном числе,
        конечном числе и количестве колонок в строке.
        */
        int rows = (int) Math.ceil((lastNumber-startNumber+1)/(double)columnsInRow);

        for (int i = 0; i < rows; i++) {
            int last = (startNumber+columnsInRow-1) > lastNumber ? lastNumber : (startNumber+columnsInRow-1);
            row(startNumber, last);
            startNumber += columnsInRow;
            System.out.println();
        }
    }

    public static void row(int a, int b){
        for (int i = 1; i <= 10; i++){
            for (int start = a; start <= b; start++){
                System.out.print(start + " x " + i + " = " + (start*i) + "\t\t");
            }
            System.out.println("\b\b");
        }
    }
}
