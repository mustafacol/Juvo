package com.mustafa.juvo.Model;

public class CagriItem {
    int resourceId;
    String itemName;




    public CagriItem(int resourceId, String itemName) {
        this.resourceId = resourceId;
        this.itemName = itemName;
    }

    public CagriItem(String itemName) {
        this.itemName = itemName;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "CagriItem{" +
                "resourceId=" + resourceId +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
