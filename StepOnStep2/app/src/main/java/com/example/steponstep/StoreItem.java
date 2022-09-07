package com.example.steponstep;

public class StoreItem {

    private String ItemName;
    private String CpName;
    private int CpImage;

    public StoreItem(String itemName, String cpName, int cpImage) {
        ItemName = itemName;
        CpName = cpName;
        CpImage = cpImage;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getCpName() {
        return CpName;
    }

    public void setCpName(String cpName) {
        CpName = cpName;
    }

    public int getCpImage() {
        return CpImage;
    }

    public void setCpImage(int cpImage) {
        CpImage = cpImage;
    }
}
