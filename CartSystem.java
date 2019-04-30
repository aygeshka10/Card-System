package cartSystemExample;



public class CartSystem extends TheSystem {
	CartSystem() {
	}

	@Override
	public void display() {
		
		
		double subtotal = 0.00, tax=0.00, total=0.00;
		
		System.out.printf("%-15s%-20s%-15s%-15s","Item Name", "Item Description", "Item Price", "Available Quantity");
		System.out.println();
		
		for (Item i : getItemCollection().values()) {
			
			System.out.printf("%-15s%-20s%-15.2f%-15d%n",i.getItemName(), i.getItemDesc(), i.getItemPrice(), i.getQuantity());
		
			subtotal= Double.sum(subtotal, i.getItemPrice() * i.getQuantity() );
			tax=subtotal * 0.05;
			total = subtotal + tax;
		}
		
		System.out.printf("%s%.2f%n","Sub Total: ",subtotal);
		System.out.printf("%s%.2f%n","Tax: ", tax);
		System.out.printf("%s%.2f%n","Total: ", total);
		
}
}
