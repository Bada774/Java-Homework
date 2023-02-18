package com.bada774;
import java.util.*;

public class Mathematics {

    // ---Генерация случайного числа в заданном диапазоне--- //
    public static int randomInterval (int start, int end) {
        Random random = new Random();
        return start + random.nextInt(end - start + 1);
    }

    // ---Генерация массива случайных чисел--- //
    public static int[] randomArray (int start, int end, int size) {
        int array[] = new int [size];
        for (int i = 0; i <= array.length - 1; i++) {
            array[i] = randomInterval(start, end);
        }
        return array;
    }
    
    // ---Вывод массива в строку--- //
    public static String arrayToString (int array[]) {
        String str = "";
        for (int i = 0; i <= array.length - 1; i++) {
            str += array[i] + " "; 
        }
        return str;
    }
    

    // ---Определение интегралла методом трапеции, до заданной точности--- //

    public static double calculateIntegral(double a, double b, double error) {

        double secondIntegral = Double.MAX_VALUE;
        double firstIntegral;
        double h = (b - a) / 10;
        do {
            firstIntegral = secondIntegral;
            double s = (f(a) + f(b)) / 2;
            for (double i = 1; a + i * h < b; i++) {
                double x = a + h * i;
                s += f(x);
            }
            secondIntegral = h * s;
            h /= 10;
        } while (Math.abs(secondIntegral - firstIntegral) > error);
        return secondIntegral;

    }
    
    public static double f(double x)   {
        return (7 * Math.pow(x, 2) + x - 2) / (4 * Math.sqrt(2 * Math.pow(x, 3) + 3));
    }

    // ---Определение интегралла методом трапеции, до заданной точности--- //

    // ---Определение площади треугольника--- //
    public static double triangle(double firstSide, double secondSide, double thirdSide) {
        double p = (firstSide + secondSide + thirdSide) / 2;
        double area = Math.sqrt(p * (p - firstSide) * (p - secondSide) * (p - thirdSide));
        return area;
    }
}
