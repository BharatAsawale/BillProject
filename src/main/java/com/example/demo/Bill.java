package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bill")
public class Bill {
    @Id
    private String billNo;
    private String billTo;
    private String billDate;
    private float billAmount;
    private float billTax;
    private float billTotal;

    public Bill() {
    }

    public Bill(String billNo, String billTo, String billDate, float billAmount, float billTax, float billTotal) {
        this.billNo = billNo;
        this.billTo = billTo;
        this.billDate = billDate;
        this.billAmount = billAmount;
        this.billTax = billTax;
        this.billTotal = billTotal;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getBillTo() {
        return billTo;
    }

    public void setBillTo(String billTo) {
        this.billTo = billTo;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public float getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(float billAmount) {
        this.billAmount = billAmount;
    }

    public float getBillTax() {
        return billTax;
    }

    public void setBillTax(float billTax) {
        this.billTax = billTax;
    }

    public float getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(float billTotal) {
        this.billTotal = billTotal;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "bill_no='" + billNo + '\'' +
                ", billTo='" + billTo + '\'' +
                ", billDate='" + billDate + '\'' +
                ", billAmount=" + billAmount +
                ", billTax=" + billTax +
                ", billTotal=" + billTotal +
                '}';
    }
}
