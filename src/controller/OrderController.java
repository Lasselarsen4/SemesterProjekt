package controller;

import java.util.List;

import model.*;
import model.OrderContainer;

public class OrderController
{
	private OrderContainer oCont = OrderContainer.getInstance();
	private MemberContainer mCont = MemberContainer.getInstance();
	private ProductContainer pCont = ProductContainer.getInstance();
	private Order aOrder;
	
	public OrderController()
	{
		
	}
	/**
	 * Opretter en ny ordre.
	 * @return
	 */
	public Order createOrder()
	{
		aOrder = new Order();
		return aOrder;
	}
	/**
	 * @param orderNum
	 * @return ordren
	 */
	public Order findOrder(int orderNum)
	{
		return oCont.findOrder(orderNum);
	}
	public Product findProductByBarcode(int barCode)
	{
		return pCont.findProductByBarcode(barCode);
	}
	/**
	 * @param email
	 * @return
	 * Tilføjer en specifik registreret kunde til ordren.
	 */
	public Member addMember(String email)
	{
		Member m = mCont.findMemberByEmail(email);
		if (m != null) {
			aOrder.setCustomer(m);
		}
		return m;
	}
	/**
	 * @param barCode
	 * @param quantity
	 * @return OrderLine for det produkt vi tílføjer
	 */
	public OrderLine addProduct(int barCode, int quantity)
	{
		Product p = findProductByBarcode(barCode);
		OrderLine ol = null;
		if (p != null) {
			ol = new OrderLine(p, quantity);
			aOrder.addOrderLine(ol);
		}
		return ol;
	}
	/**
	 * @return total pris
	 */
	public double getTotalCost()
	{
		return aOrder.getTotalCost();
	}
	/**
	 * @return alle orderlines til ordren
	 */
	public List<OrderLine> getOrderLines()
	{
		return aOrder.getOrderLines();
	}
	/**
	 * @return true
	 * Vi markerer ordren som værende færdig
	 */
	public boolean finishOrder()
	{
		aOrder.setFinished(true);
		oCont.addOrder(aOrder);
		return true;
	}
	
}
