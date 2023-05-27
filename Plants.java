package com.mirea.kt.datastorageapplication;

public class Plants {

    private String name;
    private String variety;
    private Boolean type;

    public Plants(String name, String variety, boolean type) {
        this.name = name;
        this.variety = variety;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }
}
