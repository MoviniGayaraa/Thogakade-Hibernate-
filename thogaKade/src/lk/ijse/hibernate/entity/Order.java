package lk.ijse.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    private int order_id;

    @Column(name = "customer_id")
    private int customer_id;

    @Column(name = "date")
    private String date;

    @Column(name = "qty")
    private int qty;

    public Order(int order_id, int customer_id, String date, int qty) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.date = date;
        this.qty = qty;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", customer_id=" + customer_id +
                ", date='" + date + '\'' +
                ", qty=" + qty +
                '}';
    }
}
