package collections.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericImmutable {

	public static void main(String[] args) {
		GenericImmutable immutable=new GenericImmutable();
		//by extending string makes list immutable
		List<? extends String> items=immutable.getList();
		for (String item : items) {
			System.out.println(item);
		}
		//items.add("Test"); //compile error

		List<String> immutable2= Collections.unmodifiableList(immutable.getList1());
		//is runtime exception, throws UnsupportedException
		immutable2.add("Test");
		
	}
	public List<? extends String> getList() {
		List<String> items = new ArrayList<>();
		items.add("One");
		items.add("Two");
		items.add("Three");
		return items;
	}
	public List<String> getList1(){
		List<String> items = new ArrayList<>();
			items.add("One");
			items.add("Two");
			items.add("Three");
			return items;
	}
}
