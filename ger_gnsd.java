  import java.util.Scanner;
  

  public class ger_gnsd{
  	public static void main(String[] arg){
		String head = "";
                String usuario = "";
 		String senha = "";
                String projetos = "";		

        Scanner scanner = new Scanner(System.in);

	System.out.println("Entre com no nome do usuario do banco");
	usuario = scanner.next();
	System.out.print("\033[H\033[2J");
	System.out.println("Entre com a senha de usuario do banco");
	senha = scanner.next();
	System.out.print("\033[H\033[2J");
	System.out.println("Enrre com o nome do projeot ");
	projetos = scanner.next();
	System.out.print("\033[H\033[2J");

	head ="import java.sql.*;" + "\n" + "public class conexaoBandoCados{\n" + 
        "Connection conBanco;" + "\n" + "public boolean abrirConexao(){" + "\n" + 
	"String url = \"jdbc:mysql://localhost/" + projetos + "?user=" + usuario +"password="  + senha +";\";"  +
	"\n try{ \n" + "}catch(Exception erro){erro.printStackTrace();" + "\n" + "return false;" + "\n" + "}" + "\n" + "}" + "}";
	
//System.out.println(head);
         ger_file GeraFile = new ger_file("conexaoBandoCados",head);
         GeraFile.geraFileExecute();
            	 
	
	}
  }
