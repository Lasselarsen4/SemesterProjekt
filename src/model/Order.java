package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Member customer;
    private List<OrderLine> items;
    private double totalCost;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private LocalDate paymentDate;
    private static int orderNumCount = 1;
    private int orderNum;
    @SuppressWarnings("unused")
	private boolean isFinished;

    /**
     * Constructor
     */
    public Order() {
        items = new ArrayList<>();
        orderDate = LocalDate.now();
        paymentDate = LocalDate.now();
        orderNum = orderNumCount;
        orderNumCount++;
        }

    /**
     * @return
     */
    public int getOrderNumber() {
        return orderNum;
    }

    /**
     * @param set orderNumber
     */
    public void setOrderNumber(int orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * @return Customer
     */
    public Member getCustomer() {
        return customer;
    }

    /**
     * @param set customer
     */
    public void setCustomer(Member customer) {
        this.customer = customer;
    }


    /**
     * @return totalCost
     */
    public double getTotalCost() {
        double totalCost = this.totalCost;
        if (customer != null) {
            totalCost *= (1 - customer.getDiscount());
        }
        return totalCost;
    }

    /**
     * @param orderLine
     */
    public void addOrderLine(OrderLine orderLine) {
        if (orderLine.getProduct() != null) {
            items.add(orderLine);
            totalCost += orderLine.getPrice();
        }
    }

    /**
     * @param isFinished
     */
    public void setFinished(boolean isFinished)
    {
    	this.isFinished = isFinished;
    }

    /**
     * @return ArrayList items
     */
    public List<OrderLine> getOrderLines() {
        return new ArrayList<>(items);
    }

    /**
     * @return Orderdate
     */
    public LocalDate getOrderDate() {
        return orderDate;
    }

    /**
     * @param set orderDate
     */
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return deliveryDate
     */
    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @param set deliveryDate
     */
    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * @return paymentDate
     */
    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param set paymentDate
     */
    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

	public void setM(Member m) {
		// TODO Auto-generated method stub
		
	}
}