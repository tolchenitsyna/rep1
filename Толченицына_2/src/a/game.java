package a;
import java.util.Scanner;
public class game {
    public static void main(String[] args) {
        System.out.print("ДОБРО ПОЖАЛОВАТЬ В МИР КРЕСТОВ НOЛЕЙ \n При введении координат сначала указывайте столбец, потом строку");
        Scanner scan = new Scanner(System.in);
        String current = "X";
        int column = 0;
        int line = 0;
        int check = 0;
        int ans = 0;
        boolean haveWinner = false;
        boolean notError = false;
        boolean gameOn = true;
        String[][] square = new String[3][3];
        for (int l = 0; l < 3; l++) {
            for (int k = 0; k < 3; k++) {
                square[l][k] = " ";
            }
        }
        while (gameOn == true && haveWinner == false) {
            for (int a = 0; a < 3; a++) {
                System.out.print("\n" + "|");
                for (int b = 0; b < 3; b++) {
                    System.out.print(" " + square[b][a] + " |");
                }
                System.out.print("\n-------------");
            }
            for (int i = 0; i < 9; i++) {
                if (i % 2 == 0) {
                    current = "X";
                } else {
                    current = "O";
                }
                System.out.print("\n Ход игрока " + current + "\n Координаты ячейки:");
                while (notError == false) {
                    column = scan.nextInt() - 1;
                    line = scan.nextInt() - 1;
                    if (square[column][line] == " ") {
                        square[column][line] = current;
                        notError = true;
                    } else {
                        System.out.print("\n Ячейка уже занята");
                    }
                }
                for (int a = 0; a < 3; a++) {
                    System.out.print("\n" + "|");
                    for (int b = 0; b < 3; b++) {
                        System.out.print(" " + square[b][a] + " |");
                    }
                    System.out.print("\n-------------");
                }
                for (int c = 0; c < 3; c++) {
                    for (int d = 0; d < 3; d++) {
                        if (c == d && square[c][d] == current) {
                            check++;
                        }else break;
                    }
                }
                if (check == 3) {
                    System.out.print("\n Победа игрока " + current);
                    haveWinner = true;
                }
                check = 0;
                for (int e = 0; e < 3; e++) {
                    for (int f = 0; f < 3; f++) {
                        if (square[f][e] != current) {
                            break;
                        }

                        if (f == 2) {
                            System.out.print("\n Победа игрока " + current);
                            haveWinner = true;
                            break;
                        }
                    }
                    if (haveWinner == true) break;
                }
                for (int u = 0; u < 3; u++){
                    for (int v = 0; v < 3; v++){
                        if (square[u][v] != current) {
                            break;
                        }
                        if (v == 2){
                            System.out.print("\n Победа игрока " + current);
                            haveWinner = true;
                            break;
                        }
                    }
                    if (haveWinner == true) break;
                }
                notError = false;
                if (i == 8) {
                    if (haveWinner == false) {
                        System.out.print("\n Это ничья");
                        haveWinner = true;
                    }
                    }
                    if (haveWinner == true) {
                        System.out.print("\n Напишите 4 если хотите повторить игру");
                        ans = scan.nextInt();
                        if (ans == 4) {
                            gameOn = true;
                        } else {
                            gameOn = false;
                            System.out.print("\n Конец");
                        }
                        haveWinner = false;
                        column = 0;
                        line = 0;
                        for (int x=0; x<3; x++){
                            for (int y=0; y<3; y++){
                                square[x][y] = " ";
                            }
                        }
                        ans = 0;
                        break;
                    }



            }

        }
    }
}
