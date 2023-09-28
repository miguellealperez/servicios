package com.MiguelLeal.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;
public class UniversidadesWrapper {

    private List<UniversidadEntry> entries = new ArrayList<>();

    @XmlElement(name = "entry")
    public List<UniversidadEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<UniversidadEntry> entries) {
        this.entries = entries;
    }

    public static class UniversidadEntry {
        private String key;
        private Universidad value;

        @XmlElement(name = "key")
        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @XmlElement(name = "value")
        public Universidad getValue() {
            return value;
        }

        public void setValue(Universidad value) {
            this.value = value;
        }
    }
}
