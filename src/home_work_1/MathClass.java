package home_work_1;

import java.util.Arrays;

public class MathClass {
    public static void main(String[] args) {
        int a = -15;
        int b = 67;

        System.out.println(Math.abs(a)); // возвращает модуль числа

        System.out.println("Максимальное число среди a и b - это " + Math.max(a, b)); // возвращает максимальное среди двух значений
        System.out.println("Минимальное число среди a и b - это " + Math.min(a, b)); // возвращает минимальное значение

        int c = Math.addExact(a,b); // складывает числа, причем выдает ошибку если происходит переполнение данных
        System.out.println(c);

        int d = 729;
        System.out.println(Math.sqrt(d)); // возвращает квадратный корень, производит автоматическое преобразование в double
        System.out.println(Math.cbrt(d)); // возвращает кубический корень, производит автоматическое преобразование в double

        int e = 2_147_483_647;
        System.out.println(e*2); // обычное умножение, в котором из-за переполнения данных исказится значение
        //System.out.println(Math.multiplyExact(e, 2)); // производит точное умножение, но выдает ошибку если происходит переполнение

        double f1 = 0.23452345;
        double f2 = 15.45684;
        double f3 = 15.57646;
        double f4 = -12.8461;
        System.out.println(Math.ceil(f1)); // возвращает ближайший целый double (по сути integer), который >= значению
        System.out.println(Math.floor(f3)); // возвращает ближайший целый double (по сути integer), который <= значению
        System.out.println(Math.round(f2)); // возвращает ближайший int, если работает с float, и long, если работает с double
        System.out.println(Math.round(f4));
        System.out.println(Math.rint(f3)); // округляет до double, являющийся целым числом

        System.out.println(Math.pow(b, 2)); // возводит первое в степень второго, работает с double, поэтому преобразовал int

        int g = (int)(Math.random()*100); // генерирует псевдо-рандомный double от 0.0 до 1.0, для получаения int требует приведения типов
        System.out.println(g);

        int b2 = (int)(Math.random()*100);
        if (b == b2){
            System.out.println("Вот это успех! Рандомное число совпало с заданным числом " + b + "! Сегодня ты счастливчик, купи лотерейный билет");
        }

        System.out.println();

        massive();
    }

    public static void massive(){
        int[] massive = new int[(int)(Math.random()*10)];
        for (int i = 0; i < massive.length; i++){
            massive[i] = (int)(Math.random()*100);
        }
        System.out.print("У нас есть массив случайного размера со случайными числами: {");
        for (int i = 0; i < massive.length; i++) {
            if (i != massive.length - 1) {
                System.out.print(massive[i] + ", ");
            } else {
                System.out.println(massive[i] + "}");
            }
        }
        // можно было заменить на
        // System.out.println("У нас есть массив случайного размера со случайными числами: " + Arrays.toString(massive));

        System.out.print("В этом массиве наибольшее число: ");
        for (int i = 0; i < (massive.length-1); i++){
            massive[i+1]=Math.max(massive[i], massive[i+1]);
        }
        System.out.println(massive[massive.length-1]);
    }
}
