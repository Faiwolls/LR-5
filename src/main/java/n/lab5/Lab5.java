/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package n.lab5;
import java.util.Scanner;

/**
 *
 * @author Назар
 */

public class Lab5 {
   
    public static void main( String[] args) {
        int i=0;
        System.setProperty("console.encoding", "Cp65001");
        Scanner scanner = new Scanner(System.in);
       
        int n = 0;
        int sbs_max = 10;
        boolean done = false;

        do {
            try {
                System.out.printf("Введите кол-во собственников (1-%d): ", sbs_max);
                n = scanner.nextInt();
                scanner.nextLine();

                if (n < 1 || n > sbs_max) {
                    throw new Exception("Число вне диапазона!");
                } else {
                    done = true;
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        } while (!done);

        int w = 0;
        do {
            System.out.println("\nПрочитать из файла?\n1 - одномерный массив\n2 - двумерный массив\n3 - нет, ввод вручную: ");
            w = scanner.nextInt();
            scanner.nextLine();
        } while (w != 1 && w != 2 && w != 3);

        
    
        sobst[] sbs = new sobst[n];
        for (i=0; i < n; i++) {
          sbs[i] = new sobst();
        }
        
        int n1;
        switch (w) {
            case 1 -> sbs[0].filein(sbs,n);
            case 2 -> {
                sobst[][] sbs1 = new sobst[1][n];
                for (i=0; i < n; i++) {
                sbs1[0][i] = new sobst();
                }
                sbs1[0][0].filein(sbs1[0],n);
                for (n1 = 0; n1 < n; n1++) {
                    sbs[n1] = sbs1[0][n1];
                }
                n1 = 0;
                do {
                    System.out.println("\n--- Вывод из двумерного массива собственников 1x" + n + " --- ");
                    System.out.printf("Введите номер элемента от 1 до %d: ", n);
                    n1 = scanner.nextInt();
                    scanner.nextLine();
                } while (n1 < 1 || n1 > n);
                sbs1[0][n1 - 1].printinfo();

                System.out.println("\nВывод " + n1 + " собственника под номером " + sbs1[0][n1 - 1].sobstnum + " окончен.");
                System.out.println("Для продолжения нажмите любую клавишу...");
                scanner.nextLine();
            }
            case 3 -> sbs[0].vvod(sbs, n);
        }
        // Создание товара с пустым названием для вызова исключения
       
        
        w = 0;
        System.out.println("Записать в файл? (1 - да, 2 - нет): ");
        w = scanner.nextInt();
        scanner.nextLine();
        while (w != 1 && w != 2) {
            System.out.println("Некорректное значение. Записать в файл? (1 - да, 2 - нет): ");
            w = scanner.nextInt();
            scanner.nextLine();
        }
        if (w == 1) {
            sbs[0].fileout(sbs,n);
        }
        w = 0;
        do {
            System.out.println("Провести поиск? (1 - да, 2 - нет): ");
            w = scanner.nextInt();
            scanner.nextLine();
            while (w != 1 && w != 2) {
                System.out.println("Некорректное значение. Провести поиск? (1 - да, 2 - нет): ");
                w = scanner.nextInt();
                scanner.nextLine();
            }
            if (w == 1) {
                sbs[0].poisk(sbs,n);
            }
            System.out.println("Нажмите Enter, чтобы продолжить...");
            scanner.nextLine();
        } while (w == 1);
    }
}
