import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class geraFile{
       private String name;
       private String Text;       

       public geraFile(String name, String Text){
          this.name = name + ".java";
   	  this.Text = Text;	  
       }
       public boolean geraFileExecute(){
        String diretorioAtual = System.getProperty("user.dir");
        File arquivo = new File(diretorioAtual, this.name);
        try {
            FileWriter escritor = new FileWriter(arquivo, true);
            escritor.write(this.Text);
            escritor.close();
	    return(true);
        } catch (IOException e) {
            e.printStackTrace();
	    return(false);
        }
}


}
