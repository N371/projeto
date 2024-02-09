import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class slg {
    public static void main(String[] args) {
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
        String StrCons = "";
        String StrConc = "";
        String StrConcI = "";
        String StrHead = "";
        String StrNms = "";
        String SendTxt = "";
        String access = "";
        String[] msg = {"Programa para geracao de classe",
                "Informe o Nome da Classe",
                "Informe o nome da propriedade",
                "Informe o Classe Wrapper da variavel <String>, Byte, Short, Integer, Long, Float, Double ou Character",
                "Informe regras de acesso public, <private>, protected ou default",
                "Informe se gera metodos set S/N",
                "Informe se gera metodos get S/N",
                "Informe se gera construtor com todas as propriedades S/N",
                "Informe se gera metodo toString S/N"
        };

        System.out.print("\033[H\033[2J");
        System.out.println(msg[0]);
        System.out.println(msg[1]);
        String className = scanner.next();

        while (true) {
            System.out.println("Para sair digite sair");
            System.out.println(msg[2]);
            String sair = scanner.next();
            if (sair.equals("sair")) {
                scanner.nextLine();
                break;
            }

            scanner.nextLine();

            propriedades prop = new propriedades();
            prop.setName(sair);

            System.out.println(msg[3]);
            String StrEnter = scanner.nextLine().trim();
            if (StrEnter.isEmpty()) StrEnter = "String";
            prop.setType(StrEnter);

            System.out.println(msg[4]);
            String AccesEnt = scanner.nextLine().trim();
            if (AccesEnt.isEmpty()) AccesEnt = "private";
            prop.setChangeAccess(AccesEnt);

            propriedade.add(prop);
        }




        System.out.print("\033[H\033[2J");
        System.out.println(msg[5]);
        String setGeneration = scanner.next();
        if (setGeneration.equalsIgnoreCase("S")) {
            Stgeneration = true;
        }

        System.out.print("\033[H\033[2J");
        System.out.println(msg[6]);
        String getGeneration = scanner.next();
        if (getGeneration.equalsIgnoreCase("S"))
            Gtgeneration = true;

        System.out.print("\033[H\033[2J");
        System.out.println(msg[7]);
        String getConstructor = scanner.next();
        if (getConstructor.equalsIgnoreCase("S"))
            Ctgeneration = true;

        System.out.print("\033[H\033[2J");
        System.out.println(msg[8]);
        String getStr = scanner.next();
        if (getStr.equalsIgnoreCase("S"))
            Togeneration = true;



            System.out.print("\033[H\033[2J");


//        for (propriedades prop : propriedade) {
            System.out.println("Gerar gets  : " + Gtgeneration);
            System.out.println("Gerar sets  : " + Stgeneration);
            System.out.println("Gerar construtores : " + Ctgeneration);
            System.out.println("Gerar metodos tostring : " + Togeneration);
            System.out.println(" Valor das propriedades : ");
            txtPropriedades = "\n@Override\n public String toString(){" + "\n return " + "\"" + className + "{\" + ";

            for (propriedades p : propriedade) {
                if (p == propriedade.get(propriedade.size() - 1)) {
                    txt2Propriedades = txt2Propriedades + "\""+p.getName()+"=\" + " + p.getName();
                } else {
                    txt2Propriedades = txt2Propriedades + "\""+p.getName()+"=\" + " + p.getName() + "+";
                }
            }
            txtPropriedades = txtPropriedades + txt2Propriedades + " + " + "\'}\';";

            if (Stgeneration) {
                for (propriedades p : propriedade) {
                    StrSets = StrSets + "\npublic void set" + p.getName() + "(" + p.getType() + " " + p.getName() + ") {\n      this." + p.getName() + "=" + p.getName() + ";\n}";

                    if (p == propriedade.get(propriedade.size() - 1)) {
                        StrHead = StrHead +" "+ p.getType() +" "+ p.getName();
                    } else {
                        StrHead = StrHead +" "+ p.getType() +" "+ p.getName() +",";
                    }
                }
            }

            if (Gtgeneration) {
                for (propriedades p : propriedade) {
                    StrGets = StrGets + "\npublic " + p.getType() + " get" + p.getName() + "() {\n      return this." + p.getName() + ";\n}";
                }
            }

            StrCons = "public " + className +"(){\n}";

            if (Ctgeneration) {
                StrConc = "public " + className +"("+StrHead+")\n{";

                for (propriedades p : propriedade) {
                    StrConcI = StrConcI + "\nthis." + p.getName() + " = " + p.getName() + ";";
                }
                StrConc = "\n"+ StrConc + StrConcI +  "\n}";
            }

            for (propriedades p :  propriedade) {
                access =  access + "\n" + p.getChangeAccess() + " " + p.getType() + " " + p.getName() + ";";
            }
  //      }

//        String imports = "import java.util.Date;\nimport javax.persistence.Entity;\nimport javax.persistence.GeneratedValue;\nimport javax.persistence.GenerationType;\nimport javax.persistence.Id;\nimport javax.persistence.Temporal;\nimport javax.persistence.TemporalType;\nimport javax.persistence.Column;\n\n\n@Entity\n";

        SendTxt = "public class " + className + "{" + "\n" + access + "\n" + StrConc + "\n" + StrCons + StrSets + StrGets + txtPropriedades + "\n}" + "\n}";
        file GeraFile = new file(className, SendTxt, "java");
        GeraFile.geraFileExecute();
    }
}

