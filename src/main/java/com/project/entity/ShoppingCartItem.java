package com.project.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "shopping_cart_item")
public class ShoppingCartItem {

    private Long id;
    private Item item;
    private ShoppingCart shoppingCart;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item")
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_shopping_cart", referencedColumnName = "id")
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingCartItem)) return false;
        ShoppingCartItem that = (ShoppingCartItem) o;
        return Objects.equals(id, that.id) && Objects.equals(item, that.item) && Objects.equals(shoppingCart, that.shoppingCart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item, shoppingCart);
    }

    @Override
    public String toString() {
        return "ShoppingCartItem{" +
                "id=" + id +
                ", item=" + item +
                ", shoppingCart=" + shoppingCart +
                '}';
    }
}
