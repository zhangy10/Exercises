package Programming;

public class MainDriver {

	public static void main(String[] args) {
		ChessPiece a1 = new Rook(4, 6);
		System.out.println(a1);
		a1 = new Bishop(4, 6);
		System.out.println(a1);
		a1 = new Knight(4, 6);
		System.out.println(a1);
	}
}
