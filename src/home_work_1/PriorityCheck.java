package home_work_1;

public class PriorityCheck {
    public static void main(String[] args) {
        int a = 8;
        int c = 2;

        int result1 = 5+c/a;
        System.out.println("В первом примере ответ равен " + result1);
        // ожидается 5
        // приоритет у деления, результатом деления может быть только целое число, остаток "отбрасывается", получается 0
        // +посчитано верно

        int result2 = (5+c)/a;
        System.out.println("Во втором примере ответ равен " + result2);
        // ожидается 0
        // приоритет в скобках, складываем, получаем 7, делим на 8, присваивается целый остаток
        // +посчитано верно

        int result3 = (5+c++)/a;
        System.out.println("В третьем примере ответ равен " + result3);
        // ожидается 0.
        // первый приоритет у операций в скобках, но постинкремент выполняется после того, как переменная "отдала" значение для сложения
        // т.е. постинкремент на результат решения не влияет
        // в итоге к 2 прибавляем 5, только потом переменная, имеющая значение 5, увеличивается на 1, но это уже не важно для примера
        // +посчитано верно

        c=2; // возвращаем значение к первоначальному, т.к. переменной "с" присвоилось значение на 1 больше
        int result4 = (5+c++)/--a;
        System.out.println("В четвертом примере ответ равен " + result4);
        // ожидается 1.
        // аналогично предыдущему, но до деления на пемеренную a ее значение уменьшено на 1, т.е. 7
        // +посчитано верно

        c=2; a=8;
        int result5 = (5*c>>c++)/--a;
        System.out.println("В пятом примере ответ равен " + result5);
        // ожидается 0
        // приоритет у операций в скобках, сначала умножение, получаем 10
        // потом сдвиг на 2, вместо 00001010 получаем 00000010, т.е. 2
        // делим на 7, целый остаток присваивается, т.е. 0
        // +посчитано верно

        c=2; a=8;
        int result6 = (5+7 > 20 ? 68 : 22*2 >> c++) / --a;
        System.out.println("В шестом примере ответ равен " + result6);
        // ожидается 1
        // сначала в скобках, есть оператор ?:, значит сначала вычисляются значения между ними, потом выполняется логическое выражение
        // потом присвоение в зависимости от результата логического выражения
        // слева-направо, часть до вопроса всегда false, значит значение в скобках будет равняться значению после двоеточия
        // сначала умножение, 44, потом побитовый сдвиг на 2, т.е. вместо 00101100 получаем 00001011, это 11
        // 11 делим на 7, получаем целое значение 1
        // +посчитано верно

        c=2; a=8;
        //int result7 = (5+7 > 20 ? 68 >= 68 : 22*2 >> c++) / --a;
        //System.out.println("В седьмом примере ответ равен " + result7);
        //программа не скомпилируется, т.к. в операторе ?: часть "если true" является не значением, а логическим выражением
        // его нельзя потом делить на целочисленную переменную; а вторая часть является числом
        // +выдало ошибку

        boolean result8 = 6-2 > 3 && 12*12 <= 119;
        System.out.println("В восьмом примере ответ равен " + result8);
        // ожидается false
        // логический оператор И, проверяет верны ли одновременно оба логических выражения, выполняется последним перед присвоением
        // в каждой части сначала выполняются операции вычитания и умножения, потом - сравнение
        // получаем 4 > 3 И 244 <= 119
        // левая часть true, правая часть false, оператор И выдаст false

        boolean result9 = true && false;
        System.out.println("В девятом примере ответ равен " + result9);
        // ожидается false
        // логический оператор И проверяет верны ли одновременно оба логических выражения, одно из них у нас false, значит и результат false
        // +решено верно

    }
}
