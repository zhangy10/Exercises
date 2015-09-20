package Programming;

public abstract class Shape {
	public abstract Double perimeter();
	public abstract Double area();
	public String toString() {
		return getClass().getName();
	}
	
	public static void main(String[] args) {
		Shape c1 = new Circle(1.0);
		System.out.println(c1.perimeter());
		System.out.println(c1.area());
		System.out.println(c1.toString());
		
		Shape r1 = new Rectangle(2.0, 4.0);
		System.out.println(r1.perimeter());
		System.out.println(r1.area());
		System.out.println(r1.toString());
	}
}
