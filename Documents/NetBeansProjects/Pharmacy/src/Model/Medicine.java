/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 2ndyrGroupB
 */
public class Medicine {

    private String brandName;
    private String genericName;
    private double price;
    private int quantity;

    public Medicine() {
    }

    public Medicine(String brandName, String genericName, int quantity, double price) {
        this.brandName = brandName;
        this.genericName = genericName;
        this.price = price;
        this.quantity = quantity;
    }

    public Medicine(String medName, double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return String.format("%-20s %-20s %-20s %-20s", this.brandName, this.genericName,
                this.quantity, this.price);
    }

}
