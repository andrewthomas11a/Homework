package home_work_4;

public class StringPractice {

    public String toString(int number){
        if (number > 999_999_999 || number < -999_999_999){
            System.out.println("В метод передано число за пределами диапазона.");
            return "";
        }

        if (number == 0){
            return "Ноль";
        }

        StringBuilder str = new StringBuilder();

        if (number < 0) {
            str.append("Минус ");
        }

        // Разбиваем число на части
        int millions = Math.abs(number / 1_000_000);
        int thousand = Math.abs((number % 1_000_000) / 1000);
        int hundred = Math.abs(number % 1000);

        String[][] numberPartType = {
                {"миллионов",   "миллион",  "миллиона"},
                {"тысяч",       "тысяча",   "тысячи"},
        };

        if (millions != 0){
            str.append(numberNameRus(millions, true)).append(" ").
                    append(numberPartType[0][caseRussian(millions)]).append(" ");
        }
        if (thousand != 0){
            str.append(numberNameRus(thousand, false)).append(" ").
                    append(numberPartType[1][caseRussian(thousand)]).append(" ");
        }

        str.append(numberNameRus(hundred, true));

        str.replace(0, 1, (str.substring(0,1)).toUpperCase());

        return str.toString();
    }

    public String toString (double number){
        StringBuilder str = new StringBuilder();

        // создаем массив путем разделения строкового вида числа double на две части: до точки и после
        String[] numberPartArray = Double.toString(number).split("[.]");
        // первый строковый элемент массива записываем в переменную типа int
        int intPart = Integer.parseInt(numberPartArray[0]);
        // второй элемент массива записываем в переменную типа int. учитывая необходимость "прочитать" только 2 цифры
        // после запятой, обрезаем строку до двух символов, проверяя, не состоит ли строка уже из 1 символа
        int fractPart = Integer.parseInt(numberPartArray[1].substring(0, numberPartArray[1].length() > 1 ? 2 : 1));

        // если после запятой была только 1 цифра, добавляем в конце ноль, чтобы можно было читать "сотых".
        // можно сделать по-другому: вместо "сотых" добавлять "десятых", если длина дробной части 1, т.к.
        // возможно "10 сотых" не совсем корректно
        if (numberPartArray[1].length() == 1){
            fractPart *= 10;
        }

        // добавляем словами целую часть числа double, используя метод toString, написанный для int
        str.append(toString(intPart));
        str.append(" целых ");
        // добавляем словами дробную часть числа
        str.append(numberNameRus(fractPart,  true));
        str.append(" сотых");

        /*
        // На случай если нужно склонять слова "целых" и "сотых"
        String[][] partName = {{" целых ", " целая ", " целые "}, {" сотых", " сотая", " сотые"}};
        str.append(toString(intPart));
        str.append(partName[0][caseRussian(intPart)]);
        str.append(numberNameRus(fractPart, false));
        str.append(partName[1][caseRussian(fractPart)]);
         */

        return str.toString();
    }

    public String toWeek (int day){
        if (day < 0){
            System.out.print("В метод передано отрицательное значение \"" + day + "\", результат для его модуля: ");
        }

        int weekCount = Math.abs(day / 7);

        StringBuilder str = new StringBuilder();
        str.append(weekCount);

        String[] weekCase = {" недель", " неделя", " недели"};
        str.append(weekCase[caseRussian(weekCount)]);

        return str.toString();
    }

    public String toHoursMinuteSecondMillisecond(long millisecond, boolean shortFormat){
        if (millisecond < 0){
            System.out.println("В метод передано отрицательное значение \"" + millisecond + "\", результат для его модуля: ");
        }

        long hours = Math.abs(millisecond / 3600000);
        long min = Math.abs((millisecond % 3600000) / 60000);
        long sec = Math.abs((millisecond % 60000) / 1000);
        long millisec = Math.abs(millisecond % 1000);

        StringBuilder str = new StringBuilder();
        str.append(millisec);
        if (shortFormat){
            // добавляем с конца пустой строки количество единиц времени и разделители, проверяя на необходимость
            // добавления нулей после разделителей
            if (millisec / 100 == 0){
                str.insert(0, 0);
                if (millisec / 10 == 0){
                    str.insert(0, 0);
                }
            }
            long[] arr = {sec, min, hours};
            for (int i = 0; i < arr.length; i++){
                str.insert(0, i == 0 ? "." : ":");
                str.insert(0, arr[i]);
                if (arr[i] / 10 == 0){
                    str.insert(0, 0);
                }
            }
        }else{
            // добавляем с конца строки количество единиц времени и словесное название такой единицы времени,
            // проверяя, нужно ли добавить следующий разряд
            String[][] timePart = {{" часов", " час", " часа"}, {" минут", " минута", " минуты"},
                    {" секунд", " секунда", " секунды"}, {" миллисекунд", " миллисекунда", " миллисекунды"}};

            str.append(timePart[3][caseRussian(millisec)]);
            if (Math.abs(millisecond)>=1000){
                str.insert(0, " ").insert(0, (timePart[2][caseRussian(sec)])).insert(0, sec);
                if (Math.abs(millisecond)>=60000){
                    str.insert(0, " ").insert(0, (timePart[1][caseRussian(min)])).insert(0, min);
                    if (Math.abs(millisecond)>=3600000){
                        str.insert(0, " ").insert(0, (timePart[0][caseRussian(hours)])).insert(0, hours);
                    }
                }
            }
        }
        return str.toString();
    }

    /**
     * Метод определяет, в каком падеже русского языка должно быть существительное, следующее за числом.
     * @param number передаваемое количество единиц времени
     * @return 0 - если нужен родительный падеж множественного числа (часов, недель, минут и т.д.),
     * 1 - если нужен именительный падеж единственного числа (час, неделя, минута и т.д.),
     * 2 - если нужен родительный падеж единственного числа (часа, недели, минуты и т.д.),
     */
    public byte caseRussian (long number){
        long lastDigit = number % 10;
        boolean one = lastDigit == 1;
        boolean twoThreeFour = (lastDigit == 2 || lastDigit == 3 || lastDigit == 4);
        boolean teenNumbers = (number % 100 / 10 == 1);
        if (one && !teenNumbers){
            return 1;
        }else if (twoThreeFour && !teenNumbers){
            return 2;
        }else{
            return 0;
        }
    }

    /**
     * Метод возвращает положительное число от 0 до 999 в виде строки прописью на русском языке
     * @param number передаваемое число
     * @param maleOrFem true - если род слова, следующего за числом, мужской; false - если женский
     * @return число прописью на русском языке
     */
    public String numberNameRus(int number, boolean maleOrFem){
        if (number > 999 || number < 0){
            System.out.println("В метод передано число за пределами диапазона.");
            return "";
        }

        String [][] numberNameArray = {
                {"", "", "", "", ""},
                {"сто ", "десять", "одиннадцать", "один", "одна"},
                {"двести ", "двадцать", "двенадцать", "два", "две"},
                {"триста ", "тридцать", "тринадцать", "три", "три"},
                {"четыреста ", "сорок", "четырнадцать", "четыре", "четыре"},
                {"пятьсот ", "пятьдесят", "пятнадцать", "пять", "пять"},
                {"шестьсот ", "шестьдесят", "шестнадцать", "шесть", "шесть"},
                {"семьсот ", "семьдесят", "семнадцать", "семь", "семь"},
                {"восемьсот ", "восемьдесят", "восемнадцать", "восемь", "восемь"},
                {"девятьсот ", "девяносто", "девятнадцать", "девять", "девять"},
        };

        int firstDigit = number / 100;
        int secondDigit = number % 100 / 10;
        int twoLastDigits = number % 100;
        int lastDigit = number % 10;

        StringBuilder str = new StringBuilder();

        str.append(numberNameArray[firstDigit][0]);

        if (twoLastDigits > 11 && twoLastDigits < 19){
            str.append(numberNameArray[lastDigit][2]);
        }else{
            str.append(numberNameArray[secondDigit][1]);
            if (twoLastDigits % 10 != 0 && secondDigit != 0){
                str.append(" ");
            }
            str.append(numberNameArray[lastDigit][maleOrFem ? 3 : 4]);
        }

        return str.toString();
    }
}

