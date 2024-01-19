import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Solange{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		List<Propriedades> propriedade = new ArrayList<>();
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
		String[] msg = {"Programa para geração de classe básica",
			"Informe o Nome da Classe",
			"Informe o nome da propriedade",
			"Informe o tipo de dado da propriedade",
			"Informe se a propriedade é public private ou protected",
			"Informe se gera metodos set S/N",
			"Informe se gera metodos get S/N",
			"Informe se gera construtor com todas as propriedades S/N",
			"Informe se gera método toString"
		};

		System.out.println(msg[0]);
		System.out.println(msg[1]);
		String className = scanner.next();
		while(true) {
			System.out.println("Para sair digite sair");
			System.out.println(msg[2]);
			String sair = scanner.next();
			if(sair.equals("sair")) break;
			Propriedades prop = new Propriedades();
			prop.setName(sair);
			System.out.println(msg[3]);
			prop.setType(scanner.next());
			System.out.println(msg[4]);
			prop.setChangeAccess(scanner.next());
			propriedade.add(prop);
		}
		System.out.println(msg[5]);
		String setGeneration = scanner.next();
		if (setGeneration.equalsIgnoreCase("S")){ 
			Stgeneration=true;
		}
		System.out.println(msg[6]);
		String getGeneration = scanner.next();
		if (getGeneration.equalsIgnoreCase("S"))
			Gtgeneration=true;
		System.out.println(msg[7]);
		String getConstructor = scanner.next();
		if (getConstructor.equalsIgnoreCase("S"))
			Ctgeneration=true;
		System.out.println(msg[8]);
		String getStr = scanner.next();
		if (getStr.equalsIgnoreCase("S"))
			Togeneration=true;

		System.out.println("Gerar gets  : " + Gtgeneration);
		System.out.println("Gerar sets  : " + Stgeneration);
		System.out.println("Gerar construtores : " + Ctgeneration);
		System.out.println("Gerar metodos tostring : " + Togeneration);
		System.out.println(" Valor das propriedades : ");
		txtPropriedades = "\n return" + className + "{";
		for(Propriedades p : propriedade){
			txt2Propriedades = txt2Propriedades + "\""+p.getName()+"=\" + " + p.getName(); 
		} 
		txtPropriedades = txtPropriedades + txt2Propriedades;
                System.out.println("To string : "+ txtPropriedades);

		if (Stgeneration) {
			for (Propriedades p : propriedade) {
				StrSets = StrSets + "\npublic void set" + p.getName() + "(" + p.getType() + " " + p.getName() + ") {\n      this." + p.getName() + "=" + p.getName() + ";\n}";
			        StrHead = StrHead +" "+ p.getType() +" "+ p.getName() +",";	
			}
			System.out.println("StrSets  :  " + StrSets);
		}

		if (Gtgeneration) {
			for (Propriedades p : propriedade) {
				StrGets = StrGets + "\npublic " + p.getType() + " get" + p.getName() + "() {\n      return this." + p.getName() + ";\n}";
			}
			System.out.println("GtrSets  :  " + StrGets);
		}

                StrCons = "public " + className +"(){\n}";

		if (Ctgeneration) {
				StrConc = "public " + className +"("+StrHead+")\n{"; 

			for (Propriedades p : propriedade) {
				StrConcI = StrConcI + "\nthis." + p.getName() + " = " + p.getName() + ";";
			}
			StrConc = "\n"+ StrConc + StrConcI +  "\n}";
			System.out.println("Construtor completo  :  \n" + StrConc);
		}

	}
}
