package com.yin.myboot.model;

import java.io.Serializable;

/**
 * Created by zcy on 2017/12/18.
 */
public class TaoItem implements Serializable {
    private String itemId;

    private String itemName;

    private String itemAttrs;

    private String mainInage;

    private String brand;

    private String mode;

    private String category;

    private ItemStatus status;


    public enum ItemStatus {
        ON_SELF(1, "上架"), OFF_SELF(-1, "下架"), AUDIT(0, "待审核");
        private final Integer value;
        private final String description;

        ItemStatus(Integer value, String description) {
            this.value = value;
            this.description = description;
        }

        public int value() {
            return value;
        }

        public String toString() {
            return description;
        }
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemAttrs() {
        return itemAttrs;
    }

    public void setItemAttrs(String itemAttrs) {
        this.itemAttrs = itemAttrs;
    }

    public String getMainInage() {
        return mainInage;
    }

    public void setMainInage(String mainInage) {
        this.mainInage = mainInage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }
}
