/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdtssp;

/**
 *
 * @author shreeram
 */
public class Medicine
{
    boolean select ;
    String name; 
    int batch;
    int qty;
    int mrp; 
    int amount;

    public Medicine(boolean select, String name, int batch, int qty, int mrp, int amount) {
        this.select = select;
        this.name = name;
        this.batch = batch;
        this.qty = qty;
        this.mrp = mrp;
        this.amount = amount;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getMrp() {
        return mrp;
    }

    public void setMrp(int mrp) {
        this.mrp = mrp;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Medicine{" + "select=" + select + ", name=" + name + ", batch=" + batch + ", qty=" + qty + ", mrp=" + mrp + ", amount=" + amount + '}';
    }
 
}
