package com.MiguelLeal.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;

public class VehiculosWrapper {

    private List<VehiculoEntry> entries = new ArrayList<>();

    @XmlElement(name = "entry")
    public List<VehiculoEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<VehiculoEntry> entries) {
        this.entries = entries;
    }


    public static class VehiculoEntry {
        private String key;
        private Vehiculo value;

        @XmlElement(name = "key")
        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @XmlElement(name = "value")
        public Vehiculo getValue() {
            return value;
        }

        public void setValue(Vehiculo value) {
            this.value = value;
        }
    }
}
