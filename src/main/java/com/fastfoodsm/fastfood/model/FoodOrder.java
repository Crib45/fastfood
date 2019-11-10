package com.fastfoodsm.fastfood.model;

import javax.persistence.*;

@Entity
@Table(name = "food_order", schema = "fastfooddb", catalog = "")
public class FoodOrder {
    private int id;
    private Order orderByOrderId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodOrder foodOrder = (FoodOrder) o;

        if (id != foodOrder.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    public Order getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(Order orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }
}
