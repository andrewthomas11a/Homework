package home_work_4;

public class StringPractice {

    public String toWeek (int day){
        if (day < 0){
            System.out.print("В метод передано отрицательное значение \"" + day + "\", результат для его модуля: ");
            day = -day;
        }
        
        int weekCount = day / 7;

        StringBuilder str = new StringBuilder();
        str.append(weekCount);
        if (caseRussian(weekCount) == 1){
            str.append(" неделя");
        }else if (caseRussian(weekCount) == 2){
            str.append(" недели");
        }else{
            str.append(" недель");
        }
        return str.toString();
    }

    public String toHoursMinuteSecondMillisecond(long millisecond, boolean shortFormat){
        if (millisecond < 0){
            System.out.println("В метод передано отрицательное значение \"" + millisecond + "\", результат для его модуля: ");
            millisecond = -millisecond;
        }

        long hours = millisecond / 3600000;
        long min = (millisecond-hours * 3600000) / 60000;
        long sec = (millisecond - hours * 3600000 - min * 60000) / 1000;
        long millisec = millisecond % 1000;

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
            str.insert(0, ".").insert(0, sec);
            if (sec / 10 == 0){
                str.insert(0, 0);
            }
            long[] arr = {min, hours};
            for (long i : arr){
                str.insert(0, ":").insert(0, i);
                if (i / 10 == 0){
                    str.insert(0, 0);
                }
            }
        }else{
            // добавляем с конца строки количество единиц времени и словесное название такой единицы времени,
            // проверяя, нужно ли добавить следующий разряд
            String sp = " ";
            str.append(" милли").append(secRus(millisec));
            if (millisecond>=1000){
                str.insert(0, sp).insert(0, secRus(sec)).insert(0, sp).insert(0, sec);
                if (millisecond>=60000){
                    str.insert(0, sp).insert(0, minutesRus(min)).insert(0, sp).insert(0, min);
                    if (millisecond>=3600000){
                        str.insert(0, sp).insert(0, hoursRus(hours)).insert(0, sp).insert(0, hours);
                    }
                }
            }
        }
        return str.toString();
    }

    /**
     * Метод определяет, в каком падеже русского языка должно быть существительное, следующее за числом.
     * @param number передаваемое количество единиц времени
     * @return 1 - если нужен именительный падеж единственного числа (час, неделя, минута и т.д.), 2 - если нужен
     * родительный падеж единственного числа (часа, недели, минуты и т.д.), 0 - если нужен родительный падеж
     * множественного числа (часов, недель, минут и т.д.)
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
     * Метод определяет, в каком падеже русского языка должно быть слово "час" после определенного количества
     * @param hours количество часов
     * @return слово "час" в нужной форме
     */
    public String hoursRus (long hours){
        StringBuilder builder = new StringBuilder();
        if (caseRussian(hours) == 1){
            return builder.append("час").toString();
        }else if (caseRussian(hours) == 2){
            return builder.append("часа").toString();
        }else{
            return builder.append("часов").toString();
        }
    }

    /**
     * Метод определяет, в каком падеже русского языка должно быть слово "минута" после определенного количества
     * @param minutes количество минут
     * @return слово "минута" в нужной форме
     */
    public String minutesRus (long minutes){
        StringBuilder builder = new StringBuilder();
        if (caseRussian(minutes) == 1){
            return builder.append("минута").toString();
        }else if (caseRussian(minutes) == 2){
            return builder.append("минуты").toString();
        }else{
            return builder.append("минут").toString();
        }
    }

    /**
     * Метод определяет, в каком падеже русского языка должно быть слово "минута" после определенного количества
     * @param seconds количество секунд
     * @return слово "секунда" в нужной форме
     */
    public String secRus (long seconds){
        StringBuilder builder = new StringBuilder();
        if (caseRussian(seconds) == 1){
            return builder.append("секунда").toString();
        }else if (caseRussian(seconds) == 2){
            return builder.append("секунды").toString();
        }else{
            return builder.append("секунд").toString();
        }
    }
}

