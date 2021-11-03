/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectai;

import java.util.Random;
import java.util.Scanner;

public class ProjectAI {

    final public String numberS = "5436";
    public String numberM = "";
    public int solanchoi = 6;
    public boolean flag = true;
    public char soluu;
    public int vitriluu;
    public int batdau = 1;

    public ProjectAI() {
    }

    /* xử lý đoán số */
    public boolean doanSo() {
        Scanner input = new Scanner(System.in);
        int ileng = this.numberS.length();
        for (int i = 1; i <= solanchoi; i++) {
            do {
                System.out.print("Nhập vào số cần đoán có " + ileng + " chữ số:");
                this.numberM = input.nextLine();
                if (flag == false && batdau>=2) {
                    System.out.println("Bạn còn có " + (solanchoi) + " lần đoán.");
                    break;
                } else {
                    System.out.println("Bạn còn có " + (solanchoi - i) + " lần đoán.");
                }
                if (this.numberM.length() != this.numberS.length()) {
                    System.out.println("Nhập sai đô dài số đã cho mời nhập lại.");
                } else {
                    break;
                }
            } while (true);

            if (this.numberM.equals(this.numberS)) {
                return true;
            }

            for (int j = 0; j < ileng; j++) {
                if (this.numberM.charAt(j) == this.numberS.charAt(j)) {
                    System.out.println("Bạn đã nhập đúng số có giá trị " + this.numberS.charAt(j)
                            + " ở vị trí thứ " + j);
                } else {
                    System.out.println("Bạn đã nhập sai số có giá trị " + this.numberM.charAt(j)
                            + " ở vị trí thứ " + j);
                    ++batdau;
                    flag = false;
                    vitriluu = j;
                    soluu = this.numberM.charAt(j);
//                    System.out.println(this.numberM.charAt(j));
//                    System.out.println(vitriluu  + "--" + soluu );
                    if (flag == false && batdau >= 2) {
                        System.out.println("Bạn đã nhập số  " + soluu + " này ở vị trí " + vitriluu + ", vui lòng không nhập lại");

                        System.out.println("Lần sau nhập sai ở vị trí " + j +" sẽ khi bị trừ số lần đi ");
                    }
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        ProjectAI doanso = new ProjectAI();
        if (doanso.doanSo()) {
            System.out.println("Bạn đã trả lời đúng số cần đoán là:" + doanso.numberS);
        } else {
            System.out.println("Bạn đã trả lời sai số cần đoán là:" + doanso.numberS
                    + " và đã hết lượt đoán.");
        }

        System.gc();
    }

    public static String randomNumber() {

        Random rand = new Random();
        int ranNum = rand.nextInt(9999) + 1000;
        System.out.println("Random number is " + ranNum);
        String ranNum1 = String.valueOf(ranNum);
        return ranNum1;

    }
}