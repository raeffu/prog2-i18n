package _excercise.person;


public class PersonModel implements Comparable {

  private String firstname, lastname, city, country;
  
  public PersonModel(String firstname, String lastname, String city,
      String country) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.city = city;
    this.country = country;
  }

  public String toString(){
    String result;  
    result = firstname + ", " + lastname + ", " + city + ", " + country; 
    return result;
  }
  
  public boolean equals(Object o){    
    if(o==null) return false;
    if(!(o instanceof PersonModel)) return false;
    PersonModel person = (PersonModel) o;
    
    return firstname.equals(person.getFirstname()) && lastname.equals(person.getLastname());
  }

  @Override
  public int compareTo(Object o) {
    return lastname.compareTo(((PersonModel) o).getLastname());
  }
  
  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  
  
  
}
