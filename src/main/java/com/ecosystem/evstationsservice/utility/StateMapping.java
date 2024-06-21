package com.ecosystem.evstationsservice.utility;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class StateMapping {
    @JsonIgnore
    private String stateName;
    private String abbreviation;

    @JsonProperty("cities")
    private CityMapping cityMapping;

    private Map<String, String> otherProperties = new HashMap<>();

    @JsonAnySetter
    public void set(String key, Object value) {
        if (value instanceof String) {
            if ("cities".equals(key)) {
                return;
            }
            this.stateName = key;
            this.abbreviation = (String) value;
        } else if (value instanceof Map) {
            this.cityMapping = new CityMapping();
            ((Map<?, ?>) value).forEach((k, v) -> {
                if (k instanceof String && v instanceof String) {
                    this.cityMapping.setCity((String) k, (String) v);
                }
            });
        } else {
            otherProperties.put(key, (String) value);
        }
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public CityMapping getCityMapping() {
        return cityMapping;
    }

    public void setCityMapping(CityMapping cityMapping) {
        this.cityMapping = cityMapping;
    }

    public Map<String, String> getOtherProperties() {
        return otherProperties;
    }

    public void setOtherProperties(Map<String, String> otherProperties) {
        this.otherProperties = otherProperties;
    }
}