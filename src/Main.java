import java.util.Scanner;

public class Main {

    // Цвет текста в консоли.
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[42m";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Какой высоты ель Вас интересует ? - ");
        int h = in.nextInt();
        int[] matrix_h = new int[h + 2];            // Матрица ярусов ели.
        int n = 2;                                  // Счётчик для создания матрицы ярусов ели.
        int maxMaxW = 0;                            // Ширина матрицы картинки.

                                                    // Матрица ярусов ёлки в зависимости от высоты.
        for (int i = 0; i < h + 2; i++) {
            matrix_h[i] = n;
            n = n + 2;
            if ((i + 1) % 3 == 0) {
                n = n - 4;
            }
            if (matrix_h[i] > maxMaxW) {
                maxMaxW = matrix_h[i];
            }
        }

        char [][] yearTree = new char[h+1][maxMaxW];// Матрица картинки.

// Создание ели.
        int c = 0;                                  // Счётчик для определения яруса ели.
        for (int i = 0; i <= h; i++) {
            int k = 1;                              // Счётчик для чередования символов "/" и "\".

// Формирование ярусов ели.
            if (h - i == 1 || h - i == 2) {
                if ((h - 1) % 3 == 0 && i >= 3) {
                    c = i + 2;
                } else {
                    if ((h - 2) % 3 == 0 && i >= 3) {
                        c = i + 1;
                    } else {
                        c = i;
                    }
                }
            } else {
                c = i;
            }
            for (int j = 0; j < maxMaxW; j++) {
                if (i != h) {
                    if (j < (maxMaxW - matrix_h[c]) / 2 || j >= maxMaxW - (maxMaxW - matrix_h[c]) / 2) {
                        yearTree [i] [j] = ' ';
                    } else {
                        k++;
                        if (k % 2 == 0) {
                            yearTree [i][j] = 47;   // Символ "/".
                        } else {
                            yearTree [i][j] = 92;   // Символ "\".
                        }
                    }
                } else {

// Рисуем ствол ели.
                    int d = h / 5;                  // Счётчик для определения толщины ствола.
                    switch (d) {
                        case 1: k = 2;              // "к" - толщина ствола (от высоты).
                            break;
                        case 2: k = 4;
                            break;
                        case 3:
                        case 4:
                        case 5:
                        case 6: k = 6;
                            break;
                    }
                    if (j < (maxMaxW - k) / 2 || j >= maxMaxW - (maxMaxW - k) / 2) {
                        yearTree [i][j] = ' ';
                    } else {
                        yearTree [i][j] = '|';
                    }
                }
            }
        }

// Вывод матрицы в консоль.
        for (char [] yrus : yearTree) {
            for ( char needles : yrus  ) {
                System.out.print(ANSI_GREEN + needles + ANSI_RESET);
            }
            System.out.println("");
        }
    }
}
