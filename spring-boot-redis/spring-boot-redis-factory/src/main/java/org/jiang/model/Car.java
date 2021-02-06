package org.jiang.model;

import lombok.Data;

/**
 * @Description TODO
 * @Author jiang
 * @Create 2021/2/6
 * @Version 1.0
 */
public class Car {
    private String name;
    private Long price;
    private String color;

    public Car() {
    }

    public Car(String name, Long price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
