package model;

public class Employee extends User
{
	private double sales;
	
	/**
	 * @param name
	 * @param email
	 * @param id
	 */
	public Employee(String name, String email, int id)
	{
		super(name, email, id);
	}
	/**
	 * @return sales
	 */
	public double getSales()
	{
		return sales;
	}
	/**
	 * @param set sales
	 */
	public void setSales(double sales)
	{
		this.sales = sales;
	}

}
