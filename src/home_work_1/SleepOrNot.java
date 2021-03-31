package home_work_1;

public class SleepOrNot {
    public static void main(String[] args) {
        boolean weekday = true;
        boolean vacation = false;
        if (sleepIn(weekday, vacation)){
            System.out.println("Можно спать дальше!");}
        else{
            System.out.println("Пора идти на работу");}
    }

    public static boolean sleepIn (boolean weekday, boolean vacation){
        if (vacation || !weekday){
            return true;}
        else{
            return false;}
    }

}
