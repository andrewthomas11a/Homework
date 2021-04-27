package home_work_4;

public class StringPracticeMain {
    public static void main(String[] args) {
        StringPractice str = new StringPractice();

        // Проверяем результат из задачи № 3
        System.out.println(str.toWeek(8));
        System.out.println(str.toWeek(21));
        System.out.println(str.toWeek(77));
        System.out.println(str.toWeek(287));
        System.out.println(str.toWeek(-50));

        // Проверяем результат из задачи № 4
        System.out.println(str.toHoursMinuteSecondMillisecond(7789001, true));
        System.out.println(str.toHoursMinuteSecondMillisecond(7789001, false));
        System.out.println(str.toHoursMinuteSecondMillisecond(864651, true));
        System.out.println(str.toHoursMinuteSecondMillisecond(-864651, false));
    }
}
