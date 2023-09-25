package lk.ijse.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Item {
    @Id
    @Column(name = "Item_id")
     private int Item_id;

    @Column(name = "Item_name")
     private String Item_name;

    @Column(name = "QtyOnHand")
     private int QtyOnHand;

    @Column(name = "UnitPrice")
     private double UnitPrice;

    public Item(int item_id, String item_name, int qtyOnHand, double unitPrice) {
        Item_id = item_id;
        Item_name = item_name;
        QtyOnHand = qtyOnHand;
        UnitPrice = unitPrice;
    }

    public int getItem_id() {
        return Item_id;
    }

    public void setItem_id(int item_id) {
        Item_id = item_id;
    }

    public String getItem_name() {
        return Item_name;
    }

    public void setItem_name(String item_name) {
        Item_name = item_name;
    }

    public int getQtyOnHand() {
        return QtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        QtyOnHand = qtyOnHand;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "Item_id=" + Item_id +
                ", Item_name='" + Item_name + '\'' +
                ", QtyOnHand=" + QtyOnHand +
                ", UnitPrice=" + UnitPrice +
                '}';
    }
}
