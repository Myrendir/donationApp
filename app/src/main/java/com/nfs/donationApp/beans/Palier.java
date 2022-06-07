package com.nfs.donationApp.beans;

import java.time.LocalDate;

public class Palier {
    private String title;
    private String description;
    private int price;
    private LocalDate dateEnvoi;

    public Palier(String title, String description, int price, LocalDate dateEnvoi) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.dateEnvoi = dateEnvoi;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(LocalDate dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    @Override
    public String toString() {
        return "Palier{" + "title=" + title + ", description=" + description + ", price=" + price + ", dateEnvoi=" + dateEnvoi + '}';
    }
}
