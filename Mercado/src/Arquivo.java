import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Arquivo {
    private File arquivo;
    private FileReader leitor = null;
    Arquivo(){
    }

    public void gravar(ArrayList<ArrayList<String>> dados){
        try {
            arquivo = new File("Arquivo1.txt");
            FileWriter escritor;
    
            if (arquivo.exists()) {
                escritor = new FileWriter(arquivo, true);
            } else {
                arquivo.createNewFile();
                escritor = new FileWriter(arquivo);
            }
    
            for (ArrayList<String> grupo : dados) {
                String linha = String.join(" ", grupo);
                escritor.write(linha + "\n");
            }
    
            escritor.close();
            System.out.println("Dados gravados com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   public void ler(ArrayList<ArrayList<String>> dados) throws IOException {
    
    try {
        leitor = new FileReader("Arquivo1.txt");
        try (BufferedReader bufferedReader = new BufferedReader(leitor)) {
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {              
                String[] elementos = linha.split(" ");
                ArrayList<String> grupo = new ArrayList<>(Arrays.asList(elementos)); 
                dados.add(grupo); 
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } finally {
        if (leitor != null) {
            leitor.close();
        }
    }
}

    public String getLinha(String temp){
        return temp;
    }
    
}
