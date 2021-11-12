package test4.mvc.myself;
// VO = DTO = Bean = getter()&setter()
public class Product {

	private static int no = 0;
	private String name;
	private int price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public static int getNo() {
		return no;
	}

	public static void setNo(int no) {
		Product.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public static int getNextNo() {
		
		no = no + 1;
		
		return no;
	}
	
	
}
