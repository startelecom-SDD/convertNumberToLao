/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umoney.model;

/**
 *
 * @author stl_sdd_thavithong
 */
public class NumberMo {

    private String num;
    private String word;

    public NumberMo(String num, String word) {
        this.num = num;
        this.word = word;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

}
