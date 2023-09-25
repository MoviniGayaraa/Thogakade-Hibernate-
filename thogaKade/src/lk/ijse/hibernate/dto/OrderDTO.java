package lk.ijse.hibernate.dto;

public class OrderDTO {
    private int order_id;
    private int customer_id;
    private String date;
    private int qty;

    public OrderDTO(int order_id, int customer_id, String date, int qty) {
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
        return "OrderDTO{" +
                "order_id=" + order_id +
                ", customer_id=" + customer_id +
                ", date='" + date + '\'' +
                ", qty=" + qty +
                '}';
    }
}
