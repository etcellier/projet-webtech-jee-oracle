package com.project.dto;

public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private Double pricePt;
    private CategoryDTO category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPricePt() {
        return pricePt;
    }

    public void setPricePt(Double pricePt) {
        this.pricePt = pricePt;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}
