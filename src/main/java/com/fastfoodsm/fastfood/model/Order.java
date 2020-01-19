/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastfoodsm.fastfood.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fastfoodsm.fastfood.model.customTypes.StatusType;
import jdk.net.SocketFlow;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "orders")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")})
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "notesOrder")
    private String notesOrder;
    @Column(name = "statusOrder")
    private String statusOrder;
    @Column(name = "dateOfOrder")
    private Date dateOfOrder;
    @OneToMany(mappedBy = "orderId")
    @JsonIgnore
    private List<FoodOrder> foodOrderList;
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    @ManyToOne
    private Restaurant restaurantId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public Order() {
    }

    public String getNotesOrder() { return notesOrder; }

    public void setNotesOrder(String notesOrder) { this.notesOrder = notesOrder; }

    public String getStatusOrder() { return statusOrder; }

    public void setStatusOrder(String statusOrder) { this.statusOrder = statusOrder; }

    public Order(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    @XmlTransient
    public List<FoodOrder> getFoodOrderList() {
        return foodOrderList;
    }

    public void setFoodOrderList(List<FoodOrder> foodOrderList) {
        this.foodOrderList = foodOrderList;
    }

    public Restaurant getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Restaurant restaurantId) {
        this.restaurantId = restaurantId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", notesOrder='" + notesOrder + '\'' +
                ", statusOrder='" + statusOrder + '\'' +
                ", foodOrderList=" + foodOrderList +
                ", restaurantId=" + restaurantId +
                ", userId=" + userId +
                '}';
    }
}
