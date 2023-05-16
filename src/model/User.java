package model;

// Skal muligvis være en abstract class
public class User
{
	private String name;
	private String email;
	private int id;
	
	/**
	 * @param name
	 * @param email
	 * @param id
	 */
	public User(String name, String email, int id)
	{
		this.name = name;
		this.email = email;
		this.id = id;
		
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
	 * @return id
	 */
	public int getId()
	{
		return id;
	}
	/**
	 * @param set id
	 */
	public void setId(int id)
	{
		this.id = id;
	}

}
