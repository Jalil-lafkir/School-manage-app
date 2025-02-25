package com.example.models;

import com.example.utils.Generator;

public class Module {

    private String id;
    private String name;
    private String description;

    private Integer coefficient;

    private Float firstExame;
    private Float secondExame;
    private Float continuousMonitoring;

    public Module() {
    }
    
    public Module(String name, String description) {
        this.id = Generator.generateModuleId();
        this.name = name;
        this.description = description;
    }

    public Module(String id, String name, String description, Integer coefficient, Float firstExame, Float secondExame,Float continuousMonitoring) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.coefficient = coefficient;
        this.firstExame = firstExame;
        this.secondExame = secondExame;
        this.continuousMonitoring = continuousMonitoring;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Integer getCoefficient() {
        return coefficient;
    }
    public Float getFirstExame() {
        return firstExame;
    }
    public Float getSecondExame() {
        return secondExame;
    }
    public Float getContinuousMonitoring() {
        return continuousMonitoring;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }
    public void setFirstExame(Float firstExame) {
        this.firstExame = firstExame;
    }
    public void setSecondExame(Float secondExame) {
        this.secondExame = secondExame;
    }
    public void setContinuousMonitoring(Float continuousMonitoring) {
        this.continuousMonitoring = continuousMonitoring;
    }

    @Override
    public String toString(){
        return "The module '" + this.name + "' with the id '" + this.id + "' and description '" + this.description + "' is registered in ";
    }
}
