package collections.immutable;

import java.util.ArrayList;
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
		
	}
	public List<? extends String> getList() {
		List<String> items = new ArrayList<>();
		items.add("One");
		items.add("Two");
		items.add("Thre");
		return items;
	}
}
