package model;

public class Member
{
private double credit;
private double discount;
private String name;
private String email;
private String phone;
private String address;

/**
 * @param discount
 * @param name
 * @param email
 * @param phone
 * @param address
 */
public Member(double discount, String name, String email, String phone, String address)
{
	this.credit = 25000; //Tilfældig bestemt værdi 
	this.discount = discount; //Udregnet som en double i procent - eks. 0.1 = 10%
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.address = address;

}
/**
 * @return credit
 */
public double getCredit()
{
	return credit;
}
/**
 * @param set credit 
 */
public void setCredit(double credit)
{
	this.credit = credit;
}
/**
 * @return discount
 */
public double getDiscount()
{
	return discount;
}

/**
 * @param set discount
 */
public void setDiscount(double discount)
{
	this.discount = discount;
}
/**
 * @return name
 */
public String getName()
{
	return name;
}
/**
 * @param set name
 */
public void setName(String name)
{
	this.name = name;
}
/**
 * @return email
 */
public String getEmail()
{
	return email;
}
/**
 * @param set email
 */
public void setEmail(String email)
{
	this.email = email;
}
/**
 * @return phone
 */
public String getPhone()
{
	return phone;
}
/**
 * @param set phone
 */
public void setPhone(String phone)
{
	this.phone = phone;
}
/**
 * @return address
 */
public String getAddress()
{
	return address;
}
/**
 * @param set address
 */
public void setAddress(String address)
{
	this.address = address;
}

}