import java.io.File;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;


public class ger_rsln {
    public static void main(String[] args) throws IOException {
        String varchars = "";
        String strInteger = "";
        String lineInt="";

	System.out.print("\033[H\033[2J");
        System.out.println("***** Programa para geracao de arquivo sql *****");
        System.out.println("Entre com o nome de uma classe Java");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();
        File arquivo = new File(fileName);

        FileReader reader = new FileReader(arquivo);
        BufferedReader buffer = new BufferedReader(reader);

        Pattern pattern = Pattern.compile("(private|public|protected|final)\\s+(\\w+)\\s+(\\w+);"); 
	String linha = "";

	System.out.println("Informe o nome da Base de Dados");
	String base = scanner.next();
	System.out.println("Informe o nome da Tabela");
	String tabela = scanner.next();
        List<String> header = new ArrayList<>(); 
        
        System.out.println("Analisando as variaveis");
        try {
            while ((linha = buffer.readLine()) != null) {
                Matcher matcher = pattern.matcher(linha);
                if (matcher.find()==true) {
		    System.out.println("Tipo : "+matcher.group(2));
		    System.out.println("Nome : "+matcher.group(3));
                      if (matcher.group(2).matches("(.*)?String(.*)?")){
		         System.out.println("Entre com o tamanho do campo de String");
			 Integer tam = scanner.nextInt();
			 System.out.println("Este campo pode conter valor nulo ? S/N");
                         String resp = scanner.next();
			 if(resp.toUpperCase().equals("S")){
				 varchars = matcher.group(3) + "  " + "VARCHAR(" + tam + ")" + "NOT NULL";
		         header.add(varchars);
	                 }else{
			         varchars = matcher.group(3) + "  " + "VARCHAR(" + tam + ")";
		         header.add(varchars);
			 }		 
		      }
	              if (matcher.group(2).matches("(.*)?Integer(.*)?")){
		         System.out.println("Seu campo Integer tem restricao de quantidade de casas? S/N");
			 String respInt = scanner.next();
                         lineInt = "\n" + matcher.group(3);
			 if (respInt.toUpperCase().equals("S")){
			      System.out.println("Entre com o tamanho para restringir Int");
                                try{ 
				Integer tamInt = scanner.nextInt();
                                lineInt = lineInt + "   Integer(" + tamInt + ")";
                                }catch(Exception e){
				 System.out.println("Voce deve informar um campo Inteiro");
				}finally{
				 System.out.println("Entrada da restricao de tamanho do campo inteiro");
				}

			 } 
                         System.out.println("Seu campo Integer aceita numeros menores que zero?  S/N");
                         String respIntUnsi = scanner.next();
                         if (respIntUnsi.toUpperCase().equals("S")){
			       lineInt = lineInt + " UNSIGNED ";
                               
			 }
                         System.out.println("Seu campo Integer devera ser complementado com zeros a esquerda ate atingir tamanho padrao? S/N");
                       	 String respzerofill = scanner.next();
                         if (respzerofill.toUpperCase().equals("S")){
                               lineInt = lineInt + " ZEROFILL ";
			 }			 
		         System.out.println("Este campo aceitara valores nulos ?  S/N");
			 String respnotnull = scanner.next();
			 if(respnotnull.toUpperCase().equals("S")){
                               lineInt = lineInt + " NOT NULL ";			  
			 }	
                         System.out.println("Este campo eh autoincrementavel ?  S/N");
			 String respautoincr = scanner.next();
       			 if(respautoincr.toUpperCase().equals("S")){
                                lineInt = lineInt + " AUTO_INCREMENT ";
			 }
                     	 System.out.println("Este campo eh chave primaria");
	                 String resprimarykey = scanner.next();
	             	 if(resprimarykey.toUpperCase().equals("S")){
                               lineInt = lineInt  + " PRIMARY KEY";
			 }	 
                         header.add(lineInt);
		      }
                }
            }
        } catch (IOException e) {
            System.out.println("Nao econtrou pladrao");
            System.out.println(e);
        } finally {
            System.out.println("rotina processada.");
        }

        buffer.close();
        reader.close();
        scanner.close();
        String txt = "/n CREATE TABLE(";
                   for(String hd: header){
//                         System.out.println("Valor de header :  " + hd);
                         txt = txt + "/n" + hd;

			}
         txt = txt + ");";
         System.out.println("Comando para o SQL criar a tabela  " + txt + "\n") ;
           
         System.out.println("Programa terminado com sucesso !!!! arquivo gravado em :  " + base + "  " + arquivo);



    }
}
// meu_inteiro INT;
// meu_float FLOAT;
// meu_char CHAR(10);
// meu_varchar VARCHAR(255);
// meu_texto TEXT;
// minha_data DATE;
// minha_datahora DATETIME;
// meu_timestamp TIMESTAMP;
// meu_booleano BOOLEAN;
// meu_blob BLOB;
// meu_enum ENUM('valor1', 'valor2', 'valor3');
// meu_set SET('opcao1', 'opcao2', 'opcao3');

