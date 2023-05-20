package model;

import java.time.LocalDate;

/**
 * @author lasse
 *
 */
public class Order {
	private Member m;
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
		payDate = LocalDate.now();
		finished = false;
	}
	/**
	 * @return Member her kaldt m.
	 */
	public Member getM()
	{
		return m;
	}
	public void setM(Member m)
	{
		this.m = m;
	}
	
	public int getOrderNum()
	{
		return orderNum;
	}
	public void setOrderNum(int orderNum)
	{
		this.orderNum = orderNum;
	}

}
