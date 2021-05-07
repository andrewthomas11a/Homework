package utils_temp;

import java.util.Scanner;


/* Если правильно понимаю, то при открытом Scanner есть resource leak, но если его закрыть в каком-либо методе, то
закроется и поток System.in (хотя пока не очень понимаю, что это) и повторное использование Scanner будет невозможно.
Как это исправить?
Возможно, нужно такие методы проверки создавать в конкретном классе, а вот в методе main вызывать Scanner.close().

UPD: В этом классе создал общий Scanner для каждого метода, и отдельный метод .close(), который закрывает этот Scanner.
Его нужно использовать, когда больше нет необходимости использовать методы класса InputCheck.
Проблема: необходимо в конце main каждого класса вручную вызывать метод close().

А возможно ли как-то использовать другой поток вместо System.in?
Ждём темы "потоки"...
 */

public class InputCheck {
    Scanner userInput = new Scanner(System.in);
    private String errorText;

    public String getError(){
        return errorText;
    }

    public InputCheck(){
        this.errorText = "Введено не число нужного типа, либо не число, попробуйте еще раз:";
    }

    public InputCheck (String error){
        this.errorText = error;
    }
    /**
     * Метод запрашивает у пользователя введение данных в консоль, проверяет на наличие в введенных данных
     * числа типа int, возвращает введенное число типа int. Если данные не содержат число типа int - выводит
     * соответствующее сообщение и позволяет повторно ввести данные до тех пор, пока они не будут представлять
     * собой целое число.
     * @return введенное число типа int
     */
    public int checkIntInput(){
        int numberFromInput;
        while (true){
            if (userInput.hasNextInt()){
                numberFromInput = userInput.nextInt();
                break;
            }else{
                System.out.println(this.errorText);
                userInput.next();
            }
        }
        return numberFromInput;
    }

    /**
     * Метод запрашивает у пользователя введение данных в консоль, проверяет на наличие в введенных данных
     * целого числа, возвращает введенное число типа long. Если данные не содержат число типа long - выводит
     * соответствующее сообщение и позволяет повторно ввести данные до тех пор, пока они не будут представлять
     * собой целое число.
     * @return введенное число типа long.
     */
    public long checkLongInput(){
        long numberFromInput;
        while (true){
            if (userInput.hasNextLong()){
                numberFromInput = userInput.nextLong();
                break;
            }else{
                System.out.println(errorText);
                userInput.next();
            }
        }
        return numberFromInput;
    }

    public void close(){
        userInput.close();
    }
}
