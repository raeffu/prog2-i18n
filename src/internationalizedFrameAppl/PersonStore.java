package internationalizedFrameAppl;

import java.util.ArrayList;

@SuppressWarnings("hiding")
public class PersonStore<Person> extends ArrayList<Person>{
	
	private static final long serialVersionUID = 1L;
	
	public String toString(){
		String s="";
		for(Person p: this)s+=p+"\n";
		return s;
	}
	
	public boolean add(Person p){
		if(!this.contains(p)) return super.add(p);
		return false;
	}

}
