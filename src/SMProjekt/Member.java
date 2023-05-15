package SMProjekt;

public class Member
{
private double discount;
private String name;
private String email;
private String phone;
private String address;

public Member(double discount, String name, String email, String phone, String address)
{
	this.discount = discount;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.address = address;
}
public double getDiscount()
{
	return discount;
}
public void setDiscount()
{
	this.discount = discount;
}
public String getName()
{
	return name;
}
public void setName()
{
	this.name = name;
}
public String getEmail()
{
	return email;
}
public void setEmail()
{
	this.email = email;
}
public String getPhone()
{
	return phone;
}
public void setPhone()
{
	this.phone = phone;
}
public String getAddress()
{
	return address;
}
public void setAddress()
{
	this.address = address;
}

}
