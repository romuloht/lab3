import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ProblemaNRainhas {
	
	// Caminho do arquivo
	public String filePath;
	
	public ProblemaNRainhas(String filePath) {
		this.filePath = filePath;
	}
	
	// Função que cria e preenche o arquivo
	public void pnr(int n) throws FileNotFoundException {
	
		int t = n;
		int v = t*t;
		int[][] tabuleiro = new int[t][t];
		int k = 1;
		String line;
		
		// Preenchimento do tabuleiro com as variaveis
		for (int i = 0; i < t; ++i) {
			for (int j = 0; j < t; ++j) {
				tabuleiro[i][j] = k;
				++k;
			}
		}
		
		// Comando que cria o arquivo
		File file = new File(filePath);
		PrintWriter writer = new PrintWriter(file);
		
		// Comando que escreve uma linha no arquivo e automaticamente vai para a proxima linha
		writer.println("p cnf " + v + " " + 3*v);
		
		// Preenchimento do arquivo com todas as clausulas
		for (int i = 0; i < t; ++i) {
			for (int j = 0; j < t; ++j) {
				
				line = ""+tabuleiro[i][j];
				
				for (int l = j-1; l >= 0; --l) {
					line += " -" + tabuleiro[i][l];
				}
				
				for (int l = j+1; l < t; ++l) {
					line += " -" + tabuleiro[i][l];
				}
				
				writer.println(line+" 0");
				line = ""+tabuleiro[i][j];
				
				
				for (int l = i-1; l >= 0; --l) {
					line += " -" + tabuleiro[l][j];
				}
				
				for (int l = i+1; l < t; ++l) {
					line += " -" + tabuleiro[l][j];
				}
				
				writer.println(line+" 0");
				line = ""+tabuleiro[i][j];
				
				for (int l = i-1, m = j-1; l >= 0 && m >= 0; --l, --m) {
					line += " -" + tabuleiro[l][m];
				}
				
				for (int l = i+1, m = j+1; l < t && m < t; ++l, ++m) {
					line += " -" + tabuleiro[l][m];
				}
				
				for (int l = i-1, m = j+1; l >= 0 && m < t; --l, ++m) {
					line += " -" + tabuleiro[l][m];
				}
				
				for (int l = i+1, m = j-1; l < t && m >= 0; ++l, --m) {
					line += " -" + tabuleiro[l][m];
				}
				
				writer.println(line+" 0");
				
			}
		}
		
		writer.close();
		
	}

}
