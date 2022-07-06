package com.techzone.item;

public class Laptop extends Item{
    
    private String processor;
    private String graphicCard;
    private String ram;
    private String diskType;
    private String diskDescription;
    private String operatingSystem;    

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getDiskType() {
        return diskType;
    }

    public void setDiskType(String diskType) {
        this.diskType = diskType;
    }

    public String getDiskDescription() {
        return diskDescription;
    }

    public void setDiskDescription(String diskDescription) {
        this.diskDescription = diskDescription;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
    
}
