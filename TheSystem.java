package cartSystemExample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;



public abstract class TheSystem {
	private HashMap<String, Item> itemCollection;

	public HashMap<String, Item> getItemCollection() {
		return itemCollection;
	}

	public void setItemCollection(HashMap<String, Item> itemCollection) {
		this.itemCollection = itemCollection;
	}
	
	
	TheSystem() {
		try {
        itemCollection = new HashMap<String, Item>();
        
        if (getClass().getSimpleName().equals("AppSystem")) {
        	String filePath = "src\\sample.txt";
     
        	String line;
        	BufferedReader reader = new BufferedReader(new FileReader(filePath));
        	while ((line = reader.readLine()) != null) {
        		 String[] itemInfo = line.split("\\s\\s");
        		 Item it = new Item();
        		 it.setItemName(itemInfo[0]);
        		 it.setItemDesc(itemInfo[1]);
        		 it.setItemPrice(Double.valueOf(itemInfo[2]));
        		 it.setAvailableQuantity(Integer.valueOf(itemInfo[3]));
        		 this.itemCollection.put(itemInfo[0], it); 
        		}
        	reader.close();
        }
		}catch(IOException e) {}
	}

	
	public Boolean checkAvailability(Item item) {
	
		if ( item.getQuantity() >= item.getAvailableQuantity()) {
			System.out.print("System is unable to add "+ item.getItemName() +" to the card. System only has "+ item.getAvailableQuantity() +" "+ item.getItemName()+"s.");
			return false;
		}
		else
			return true;
	}
	
	
	public Boolean add(Item item) {
		
		if (item==null) {
			return false;
			}
		else if (this.itemCollection.containsKey(item.getItemName())){
			if (checkAvailability(item)) {
				item.setQuantity(item.getQuantity() + 1);
				
				return true;
			}
			
			else {return false;
			}
		}
		else {
			this.itemCollection.put(item.getItemName(), item);
			return true;	
		}
	}
	
	public Item remove(String itemName) {
	
		if (this.itemCollection.containsKey(itemName)) {
			Item old = this.itemCollection.get(itemName);
			this.itemCollection.remove(itemName);

			return old;
		}
		else {
			return null;
			}
	}

	public abstract void display();
}
