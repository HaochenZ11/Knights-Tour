package codes;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		LinkedGrid LG = new LinkedGrid(8);
		LG.display();
		LG.set();
		LG.move();
		LG.display();	
	}

}
