import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Exemplo {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		ProblemaNRainhas pnr = new ProblemaNRainhas("/home/romulo/Desktop/IA/f2.txt");
		
		pnr.pnr(4);
		
	}

}
