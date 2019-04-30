package cartSystemExample;



public class AppSystem extends TheSystem {
	AppSystem()  {
		
	}

	@Override
	public void display() {
		
		System.out.printf("%-15s%-20s%-15s%-15s","Item Name", "Item Description", "Item Price", "Available Quantity");
		System.out.println();
		
			for (Item i : getItemCollection().values()) {
			
				System.out.printf("%-15s%-20s%-15.2f%-15d%n", i.getItemName(), i.getItemDesc(), i.getItemPrice(), i.getAvailableQuantity());
						
		}		
	}

	@Override
	public Boolean add(Item item) {
		
		if (item==null) {
			return false;
		}
		else if (getItemCollection().containsKey(item.getItemName())) {
			System.out.println(item + " is already in the App System");
			return false;
		}
		else {
			getItemCollection().put(item.getItemName(), item);
			return true;
		}
	}
}
