package internationalizedFrameAppl;

@SuppressWarnings("rawtypes")
public final class Person implements Comparable{
	
	private String firstName, lastName, city, country;

	public Person(String firstName, String lastName, String city, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.country = country;
	}
	
	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public String getCity() {return city;}
	public void setCity(String city) {this.city = city;}
	public String getCountry() {return country;}
	public void setCountry(String country) {this.country = country;}

	public int compareTo(Object o) {
		Person p = (Person)o;
		if(lastName.compareTo(p.lastName)==0) return firstName.compareTo(p.firstName);
		return lastName.compareTo(p.lastName);
	}
	
	public String toString(){return lastName+" "+firstName+" "+city+" "+country;}
	
	public boolean equals(Object o){
		Person p= (Person)o;
		if(lastName.equals(p.lastName)) return firstName.equals(p.firstName);
		else return lastName.equals(p.lastName);
	}

}
