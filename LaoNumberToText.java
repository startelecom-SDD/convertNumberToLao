/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umoney.model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stl_sdd_thavithong
 */
public class LaoNumberToText {

    public static String MoneyToLakWord(String priceAmount) {
        try {
            String price = String.valueOf(priceAmount).replace(".0", "");
            int pLength = price.length();
            if (pLength > 13) {
                return "Not support";
            }
            String word = "";
            String m = "";
            String n = "";
            LaoNumberToText frm = new LaoNumberToText();
            char[] priceArray = new char[price.length()];
            for (int i = 0; i < price.length(); i++) {
                n = "";
                m = "";
                priceArray[i] = price.charAt(i);
                String number = priceArray[i] + "";

                //find number
                n = frm.listNumber().stream().filter(v -> number.equals(v.getNum())).findAny().orElse(null).getWord();
                if (!number.equals("0")) {
                    //find money
                    String strPLength = String.valueOf(pLength);
                    m = frm.listMoney().stream().filter(v -> String.valueOf(v.getIndx()).equals(strPLength)).findAny().orElse(null).getWord();
                }
                if (number.equals("1") && pLength == 1 && price.length() >= 2) {
                    n = "ເອັດ";
                }

                if (number.equals("1") && pLength == 4 && price.length() >= 5) {
                    int len = price.length() - 5;
                    String zero = price.substring(len, len + 1);
                    if (zero.equals("0")) {
                        n = "ໜຶ່ງ";
                    } else {
                        n = "ເອັດ";
                    }
                }
                if (number.equals("1") && pLength == 7 && price.length() >= 8) {
                    int len = price.length() - 8;
                    String zero = price.substring(len, len + 1);
                    if (zero.equals("0")) {
                        n = "ໜຶ່ງ";
                    } else {
                        n = "ເອັດ";
                    }
                }
                if (number.equals("0") && pLength == 4 && price.length() >= 5) {
                    m = "ພັນ";
                }

                if (number.equals("0") && pLength == 4 && price.length() >= 6) {
                    int len = price.length() - 5;
                    String zero = price.substring(len, len + 1);
                    if (zero.equals("0")) {
                        m = "";
                    }
                }
                if (number.equals("0") && pLength == 7 && price.length() >= 8) {
                    int len = price.length() - 7;
                    String zero = price.substring(len, len + 1);
                    if (zero.equals("0")) {
                        m = "ລ້ານ";
                    }
                }
                if (number.equals("1") && pLength == 1 && price.length() >= 3) {
                    int len = price.length() - 2;
                    String zero = price.substring(len, len + 1);
                    if (zero.equals("0")) {
                        n = "ໜື່ງ";
                    }
                }
                if (number.equals("1") && (pLength == 2 || pLength == 5 || pLength == 8)) {
                    n = "";
                }
                if (number.equals("2") && (pLength == 2 || pLength == 5 || pLength == 8)) {
                    n = "ຊາວ";
                }
                if (n.equals("ຊາວ")) {
                    word += (n + m.replace("ສິບ", ""));
                } else {
                    word += (n + m);
                }
                pLength--;
            }
            return word;
        } catch (Exception e) {
            return null;
        }
    }

    public static String ToWord(String price) {
        try {
            return MoneyToLakWord(price);
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(MoneyToLakWord("90000000"));
    }

    public List<NumberMo> listNumber() {
        List<NumberMo> lst = new ArrayList<>();
        lst.add(new NumberMo("1", "ໜື່ງ"));
        lst.add(new NumberMo("2", "ສອງ"));
        lst.add(new NumberMo("3", "ສາມ"));
        lst.add(new NumberMo("4", "ສີ່"));
        lst.add(new NumberMo("5", "ຫ້າ"));
        lst.add(new NumberMo("6", "ຫົກ"));
        lst.add(new NumberMo("7", "ເຈັດ"));
        lst.add(new NumberMo("8", "ແປດ"));
        lst.add(new NumberMo("9", "ເກົ້າ"));
        lst.add(new NumberMo("0", ""));
        return lst;
    }

    public List<UnitMoneyMo> listMoney() {
        List<UnitMoneyMo> lst = new ArrayList<>();
        lst.add(new UnitMoneyMo("1", ""));
        lst.add(new UnitMoneyMo("2", "ສິບ"));
        lst.add(new UnitMoneyMo("3", "ຮ້ອຍ"));
        lst.add(new UnitMoneyMo("4", "ພັນ"));
        lst.add(new UnitMoneyMo("5", "ສິບ"));
        lst.add(new UnitMoneyMo("6", "ແສນ"));
        lst.add(new UnitMoneyMo("7", "ລ້ານ"));
        lst.add(new UnitMoneyMo("8", "ສິບ"));
        lst.add(new UnitMoneyMo("9", "ຮ້ອຍ"));
        lst.add(new UnitMoneyMo("10", "ພັນ"));
        lst.add(new UnitMoneyMo("11", "ຕື່"));
        lst.add(new UnitMoneyMo("12", "ແສນ"));
        lst.add(new UnitMoneyMo("13", "ລ້ານລ້ານ"));
        return lst;
    }
}
