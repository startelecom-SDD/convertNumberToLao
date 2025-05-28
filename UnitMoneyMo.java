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
public class UnitMoneyMo {

    private String indx;
    private String word;

    public UnitMoneyMo(String indx, String word) {
        this.indx = indx;
        this.word = word;
    }

    public String getIndx() {
        return indx;
    }

    public void setIndx(String indx) {
        this.indx = indx;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

}
