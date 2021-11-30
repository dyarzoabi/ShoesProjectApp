package com.example.loginsingupapp;

enum Companysnames{
    nike, adidas,Reebok,PUMA,NEWBalance,Vans,Skechers,Underarmour, Coverse, Gucci,Louisvuitton,Salomon,Fila
}
public class Sneakers {
    private double size;
    private String colorsho;
    private Companysnames Companysname;
    private int phone;
    private int price;
    private String address;
    private String photo;

    public Sneakers(double size, String colorsho, Companysnames companysname, int phone, int price, String address, String photo) {
        this.size = size;
        this.colorsho = colorsho;
        Companysname = companysname;
        this.phone = phone;
        this.price = price;
        this.address = address;
        this.photo = photo;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getColorsho() {
        return colorsho;
    }

    public void setColorsho(String colorsho) {
        this.colorsho = colorsho;
    }

    public Companysnames getCompanysname() {
        return Companysname;
    }

    public void setCompanysname(Companysnames companysname) {
        Companysname = companysname;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Sneakers{" +
                "size=" + size +
                ", colorsho='" + colorsho + '\'' +
                ", Companysname=" + Companysname +
                ", phone=" + phone +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}