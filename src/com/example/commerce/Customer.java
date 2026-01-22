package com.example.commerce;

public class Customer {
    private String name;
    private String email;
    private String rank;
    private int totalPurchase;

    public Customer(String name, String email, String rank, int totalPurchase) {
        this.name = name;
        this.email = email;
        this.rank = rank;
        this.totalPurchase = totalPurchase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(int totalPurchase) {
        this.totalPurchase = totalPurchase;
    }

    private void updateGrade() {
        if (totalPurchase >= 2000000) {
            this.rank = "플래티넘";
        } else if (totalPurchase >= 1000000) {
            this.rank = "골드";
        } else if (totalPurchase >= 500000) {
            this.rank = "실버";
        } else {
            this.rank = "브론즈";
        }
    }
}
