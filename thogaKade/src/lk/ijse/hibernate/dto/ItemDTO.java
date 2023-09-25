package lk.ijse.hibernate.dto;

public class ItemDTO {
    private int Item_id;
    private String Item_name;
    private int QtyOnHand;
    private double UnitPrice;

    public ItemDTO(int item_id, String item_name, int qtyOnHand, double unitPrice) {
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
        return "ItemDTO{" +
                "Item_id=" + Item_id +
                ", Item_name='" + Item_name + '\'' +
                ", QtyOnHand=" + QtyOnHand +
                ", UnitPrice=" + UnitPrice +
                '}';
    }
}
