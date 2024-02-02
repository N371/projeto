import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class slg{
	class enterProperties{
	     private String nameProperties;
	     private String typeProperties;
	     private String acessPropertie;

	     public void setNameProperties(String nameProperties){
	            this.nameProperties = nameProperties;
	     }
	     public String getNameProperties(){
	            return this.nameProperties;
	     }

	     public void setTypeProperties(String typeProperties){
	     	    this.typeProperties = typeProperties;	
	     }
	     public String getTypeProperties(){
	            return this.typeProperties;		
	     }

             public void setAccesProperties(String acessPropertie){
	     	    this.acessPropertie = acessPropertie;
	     }
	     public String getAccesProperties(){
	     	    return this.acessPropertie;
	     }

	}
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		List<propriedades> propriedade = new ArrayList<>();
		boolean Stgeneration = false;
		boolean Gtgeneration = false;
		boolean Ctgeneration = false;
		boolean Togeneration = false;
		String txtPropriedades = "";
		String txt2Propriedades = "";
		String StrSets = "";
		String StrGets = "";
		String StrStr  = "";
		String StrCons = "";	
		String StrConc = "";
		String StrConcI = "";
		String StrHead = "";
		String StrNms  = "";
	        String SendTxt = "";
	        String access  = "";	
		String[] msg = {"Programa para geracao de classe",
			"Informe o Nome da Classe",
			"Informe o nome da propriedade",
			"Informe o Classe Wrapper da variavel Byte, Short, Integer, Long, Float, Double ou Character",
			"Informe regras de acesso public, private, protected ou default",
			"Informe se gera metodos set S/N",
			"Informe se gera metodos get S/N",
			"Informe se gera construtor com todas as propriedades S/N",
			"Informe se gera metodo toString S/N"
		};
	

		System.out.println(msg[0]);
		System.out.println(msg[1]);
		String className = scanner.next();
		while(true) {
			System.out.print("\033[H\033[2J");
			System.out.println("Para sair digite sair");
			System.out.println(msg[2]);
			String sair = scanner.next();
			if(sair.equals("sair")) break;
			propriedades prop = new propriedades();
			prop.setName(sair);
			System.out.println(msg[3]);
			prop.setType(scanner.next());
			System.out.println(msg[4]);
			prop.setChangeAccess(scanner.next());
			propriedade.add(prop);
		}
		System.out.print("\033[H\033[2J");
		System.out.println(msg[5]);
		String setGeneration = scanner.next();
		if (setGeneration.equalsIgnoreCase("S")){ 
			Stgeneration=true;
		}
		System.out.print("\033[H\033[2J");
		System.out.println(msg[6]);
		String getGeneration = scanner.next();
		if (getGeneration.equalsIgnoreCase("S"))
			Gtgeneration=true;
		System.out.print("\033[H\033[2J");
		System.out.println(msg[7]);
		String getConstructor = scanner.next();
		if (getConstructor.equalsIgnoreCase("S"))
			Ctgeneration=true;
                System.out.print("\033[H\033[2J");
		System.out.println(msg[8]);
		String getStr = scanner.next();
		if (getStr.equalsIgnoreCase("S"))
			Togeneration=true;
                System.out.print("\033[H\033[2J");
		System.out.println("Gerar gets  : " + Gtgeneration);
		System.out.println("Gerar sets  : " + Stgeneration);
		System.out.println("Gerar construtores : " + Ctgeneration);
		System.out.println("Gerar metodos tostring : " + Togeneration);
		System.out.println(" Valor das propriedades : ");
		txtPropriedades = "\n@Override\n public String toString(){" + "\n return " + "\"" + className + "{\" + ";
		for(propriedades p : propriedade){
		       if(p == propriedade.get(propriedade.size() - 1)){
				txt2Propriedades = txt2Propriedades + "\""+p.getName()+"=\" + " + p.getName();
		       }else{
				txt2Propriedades = txt2Propriedades + "\""+p.getName()+"=\" + " + p.getName() + "+";
		       }

		} 
		txtPropriedades = txtPropriedades + txt2Propriedades + " + " + "\'}\';";
          //      System.out.println("To string : "+ txtPropriedades);

		if (Stgeneration) {
			for (propriedades p : propriedade) {
				StrSets = StrSets + "\npublic void set" + p.getName() + "(" + p.getType() + " " + p.getName() + ") {\n      this." + p.getName() + "=" + p.getName() + ";\n}";
				    // Naoo concatena a virgula se for do ultimo element
    					if (p == propriedade.get(propriedade.size() - 1)) {
        					 StrHead = StrHead +" "+ p.getType() +" "+ p.getName();
    					} else {
			        		StrHead = StrHead +" "+ p.getType() +" "+ p.getName() +",";
    					}	
			}
	//		System.out.println("StrSets  :  " + StrSets);
		}

		if (Gtgeneration) {
			for (propriedades p : propriedade) {
				StrGets = StrGets + "\npublic " + p.getType() + " get" + p.getName() + "() {\n      return this." + p.getName() + ";\n}";
			}
	//		System.out.println("GtrSets  :  " + StrGets);
		}

                StrCons = "public " + className +"(){\n}";

		if (Ctgeneration) {
				StrConc = "public " + className +"("+StrHead+")\n{"; 

			for (propriedades p : propriedade) {
				StrConcI = StrConcI + "\nthis." + p.getName() + " = " + p.getName() + ";";
			}
			StrConc = "\n"+ StrConc + StrConcI +  "\n}";
	//		System.out.println("Construtor completo  :  \n" + StrConc);
		}

              for(propriedades p :  propriedade){
	            access =  access + "\n" + p.getChangeAccess() + " " + p.getType() + " " + p.getName() + ";";
	      }

            
            SendTxt = "public class " + className + "{" + "\n" + access + "\n" + StrConc + "\n" + StrCons + StrSets + StrGets + txtPropriedades + "\n}" + "\n}"; 
            file GeraFile = new file(className,SendTxt,"java");
	    GeraFile.geraFileExecute();
	    System.out.println(SendTxt);
	}
}
