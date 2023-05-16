package model;

public class Member
{
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
	this.discount = discount;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.address = address;

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