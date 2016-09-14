package com.example.souvik.flappymenu.DumyModelAndAdapter;

/**
 * Created by Souvik on 14-Sep-16.
 */
public class DummyModel {

    private long mId;
    private int transactionFrom;
    private int transactionTo;
    private String transactionAmount;
    private String transactionDate;

    public DummyModel() {
    }

    public DummyModel(long id, int transactionFrom, int transactionTo, String transactionAmount, String transactionDate) {
        mId = id;
        this.transactionFrom = transactionFrom;
        this.transactionTo = transactionTo;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public int getTransactionTo() {
        return transactionTo;
    }

    public void setTransactionTo(int transactionTo) {
        this.transactionTo = transactionTo;
    }

    public int getTransactionFrom() {
        return transactionFrom;
    }

    public void setTransactionFrom(int transactionFrom) {
        this.transactionFrom = transactionFrom;
    }
}
