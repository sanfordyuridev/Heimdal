package com.impalinha.heimdal.Pref;

public class ModEntity {
    private final String name;
    private final String size;

    public ModEntity(String name, String size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }
}
