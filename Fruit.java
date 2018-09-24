	
	public class Fruit {
	
	    private String name;
	    private int price=0; // Rupees per kg
		private int stock=0;//In Kg
		 int total_stock=100;
		
	    public Fruit(String name)
		{
	        this.name=name;
			this.price=0;
			this.stock=0;
	    }
	    public String getName()
		{ 
	        return name;
	    }
	    public void setPrice(int price)
		{
			this.price=price;
		}
	    public int getPrice()
		{  
	        return price;
	    }
		public void changeStock(int stock)
		{
			this.stock=stock;
		}
		public int getStock()
		{
				return stock;
		}
	}
