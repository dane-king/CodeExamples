package collections.immutable;

import java.util.ArrayList;
import java.util.List;

public class GenericImmutable {

	public static void main(String[] args) {
		GenericImmutable immutable=new GenericImmutable();
		List<? extends String> items=immutable.getList();
		for (String item : items) {
			System.out.println(item);
		}
		//items.add("Test"); compile error
		
	}
	public List<? extends String> getList() {
		List<String> items = new ArrayList<String>();
		items.add("One");
		items.add("Two");
		items.add("Thre");
		return items;
	}
}
