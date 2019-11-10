package com.fastfoodsm.fastfood.model;

import javax.persistence.*;

@Entity
public class Favorites {
    private int id;
    private String notes;
    private String createdAt;
    private Restaurant restaurantByRestaurantId;
    private Users usersByUserId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "notes", nullable = true, length = 255)
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "created at", nullable = true, length = 255)
    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Favorites favorites = (Favorites) o;

        if (id != favorites.id) return false;
        if (notes != null ? !notes.equals(favorites.notes) : favorites.notes != null) return false;
        if (createdAt != null ? !createdAt.equals(favorites.createdAt) : favorites.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    public Restaurant getRestaurantByRestaurantId() {
        return restaurantByRestaurantId;
    }

    public void setRestaurantByRestaurantId(Restaurant restaurantByRestaurantId) {
        this.restaurantByRestaurantId = restaurantByRestaurantId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
