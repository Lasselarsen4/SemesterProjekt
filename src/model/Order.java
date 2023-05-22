package model;

import java.time.LocalDate;

/**
 * @author lasse
 *
 */
public class Order 
{
	private Member member;
	private int orderNum;
	private static int orderNumCount = 1;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private double totalCost;
	private LocalDate payDate;
	private boolean finished;
	// Mangler OrderLine (List eller ArrayList)
	
	/**
	 *  Constructor
	 */
	public Order()
	{
		this.orderNum = orderNumCount;
		orderNumCount++;
		orderDate = LocalDate.now();
		setPayDate(LocalDate.now());
		finished = false;
	}
	/**
	 * @return Member her kaldt member.
	 */
	public Member getMember()
	{
		return member;
	}
	/**
	 * @param set Member
	 */
	public void setMember(Member member)
	{
		this.member = member;
	}
	
	/**
	 * @return orderNumber
	 */
	public int getOrderNum()
	{
		return orderNum;
	}
	/**
	 * @param set OrderNumber
	 */
	public void setOrderNum(int orderNum)
	{
		this.orderNum = orderNum;
	}
	/**
	 * @return order date
	 */
	public LocalDate getOrderDate()
	{
		return orderDate;
	}
	/**
	 * @param set orderDate
	 */
	public void setOrderDate(LocalDate orderDate)
	{
		this.orderDate = orderDate;
	}
	/**
	 * @return Deliverydate
	 */
	public LocalDate getDeliveryDate()
	{
		return deliveryDate;
	}
	/**
	 * @param set deliveryDate
	 */
	public void setDeliveryDate(LocalDate deliveryDate)
	{
		this.deliveryDate = deliveryDate;
	}
	/**
	 * @return total cost
	 */
	public double getTotalCost()
	{
		return totalCost;
	}
	/**
	 * @return payDate
	 */
	public LocalDate getPayDate()
	{
		return payDate;
	}
	/**
	 * @param set payDate
	 */
	public void setPayDate(LocalDate payDate)
	{
		this.payDate = payDate;
	}
	/**
	 * @return if the order is finished or not
	 */
	public boolean isFinished()
	{
		return finished;
	}
	/**
	 * Mark the order as finished
	 */
	public void markAsFinished()
	{
		this.finished = true;
	}

}
