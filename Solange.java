import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Solange extends JFrame {

    private JTextField nomeDaClasseField;
    private JTextField propriedadesField;
    private JCheckBox gerarConstrutoresCheckbox;
    private JCheckBox gerarSetsCheckbox;
    private JCheckBox gerarGetsCheckbox;
    private JCheckBox gerarToStringCheckbox;

    public Solange() {
        setTitle("Gerador de Classes - Solange");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Desabilita a opção de maximizar
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2, 10, 10));

        // Adiciona espaçamento interno aos elementos
        Insets insets = new Insets(0, 5, 0, 0);

        // Espaço Vazio
        panel.add(new JLabel());
        panel.add(new JLabel());

        // Nome da Classe
        panel.add(new JLabel("Nome da Classe:"));
        nomeDaClasseField = new JTextField();
        nomeDaClasseField.setPreferredSize(new Dimension(200, 30));
        nomeDaClasseField.setMargin(insets);
        panel.add(nomeDaClasseField);

        // Nova entrada de texto para Propriedades
        panel.add(new JLabel("Propriedades:"));
        propriedadesField = new JTextField();
        propriedadesField.setPreferredSize(new Dimension(200, 30));
        propriedadesField.setMargin(insets);
        panel.add(propriedadesField);

        // Gerar Construtores
        panel.add(new JLabel("Gerar Construtores:"));
        gerarConstrutoresCheckbox = new JCheckBox();
        gerarConstrutoresCheckbox.setMargin(insets);
        panel.add(gerarConstrutoresCheckbox);

        // Gerar Sets
        panel.add(new JLabel("Gerar Sets:"));
        gerarSetsCheckbox = new JCheckBox();
        gerarSetsCheckbox.setMargin(insets);
        panel.add(gerarSetsCheckbox);

        // Gerar Gets
        panel.add(new JLabel("Gerar Gets:"));
        gerarGetsCheckbox = new JCheckBox();
        gerarGetsCheckbox.setMargin(insets);
        panel.add(gerarGetsCheckbox);

        // Gerar toString
        panel.add(new JLabel("Gerar toString:"));
        gerarToStringCheckbox = new JCheckBox();
        gerarToStringCheckbox.setMargin(insets);
        panel.add(gerarToStringCheckbox);

        // Espaço Vazio
        panel.add(new JLabel());
        panel.add(new JLabel());

        // Botão "OK"
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerarCodigo();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(okButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void gerarCodigo() {
        String nomeDaClasse = nomeDaClasseField.getText();
        String propriedades = propriedadesField.getText();
        boolean gerarConstrutores = gerarConstrutoresCheckbox.isSelected();
        boolean gerarSets = gerarSetsCheckbox.isSelected();
        boolean gerarGets = gerarGetsCheckbox.isSelected();
        boolean gerarToString = gerarToStringCheckbox.isSelected();

        // Criação do conteúdo do arquivo
        String codigoGerado = gerarConteudoClasse(nomeDaClasse, propriedades, gerarConstrutores, gerarSets, gerarGets, gerarToString);

        // Nome do arquivo
        String nomeArquivo = nomeDaClasse + ".java";

        // Caminho do arquivo no mesmo diretório onde a aplicação está sendo executada
        String caminhoArquivo = System.getProperty("user.dir") + "/" + nomeArquivo;

        // Gravação do conteúdo no arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            writer.write(codigoGerado);
            System.out.println("Arquivo gerado com sucesso: " + caminhoArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para gerar o conteúdo da classe com base nas opções selecionadas
    private String gerarConteudoClasse(String nomeDaClasse, String propriedades, boolean gerarConstrutores,
                                        boolean gerarSets, boolean gerarGets, boolean gerarToString) {
        StringBuilder codigo = new StringBuilder();

        // Pacote
        codigo.append("package pacote;\n\n");

        // Imports
        codigo.append("/**\n");
        codigo.append(" *\n");
        codigo.append(" * @author nelson.correa@unimedsaocarlos.local\n");
        codigo.append(" *\n");
        codigo.append(" */\n");
        codigo.append("\n");
       


	codigo.append("public class ").append(nomeDaClasse).append(" {\n\n");

        // Construtores
        if (gerarConstrutores) {
            codigo.append("    public ").append(nomeDaClasse).append("() {\n");
            codigo.append("    }\n\n");
        }


    // Propriedades
    if (!propriedades.isEmpty()) {
        String[] props = propriedades.split(",");
        for (String prop : props) {
            String[] partes = prop.trim().split(" ");
            if (partes.length == 2) {
                String tipo = partes[0];
                String nome = partes[1];
                codigo.append("    private ").append(tipo).append(" ").append(nome).append(";\n");

                // Getter
                codigo.append("    public ").append(tipo).append(" get").append(capitalize(nome)).append("() {\n");
                codigo.append("        return ").append(nome).append(";\n");
                codigo.append("    }\n\n");

                // Setter
                codigo.append("    public void set").append(capitalize(nome)).append("(").append(tipo).append(" ").append(nome).append(") {\n");
                codigo.append("        this.").append(nome).append(" = ").append(nome).append(";\n");
                codigo.append("    }\n\n");
            }
        }
        codigo.append("\n");
    }




        // Getters
        if (gerarGets) {
            if (!propriedades.isEmpty()) {
                String[] props = propriedades.split(",");
                for (String prop : props) {
                    String[] partes = prop.trim().split(" ");
                    if (partes.length == 2) {
                        String tipo = partes[0];
                        String nome = partes[1];
                        codigo.append("    public ").append(tipo).append(" get").append(capitalize(nome)).append("() {\n");
                        codigo.append("        return ").append(nome).append(";\n");
                        codigo.append("    }\n\n");
                    }
                }
            }
        }

        // Setters
        if (gerarSets) {
            if (!propriedades.isEmpty()) {
                String[] props = propriedades.split(",");
                for (String prop : props) {
                    String[] partes = prop.trim().split(" ");
                    if (partes.length == 2) {
                        String tipo = partes[0];
                        String nome = partes[1];
                        codigo.append("    public void set").append(capitalize(nome)).append("(").append(tipo).append(" ").append(nome).append(") {\n");
                        codigo.append("        this.").append(nome).append(" = ").append(nome).append(";\n");
                        codigo.append("    }\n\n");
                    }
                }
            }
        }

        // toString
        if (gerarToString) {
            codigo.append("    @Override\n");
            codigo.append("    public String toString() {\n");
            codigo.append("        return \"").append(nomeDaClasse).append("{\"");
            if (!propriedades.isEmpty()) {
                String[] props = propriedades.split(",");
                for (String prop : props) {
                    String[] partes = prop.trim().split(" ");
                    if (partes.length == 2) {
                        String nome = partes[1];
                        codigo.append(" + \"").append(nome).append("=\" + ").append(nome).append(" + \", \"");
                    }
                }
            }
            codigo.append(" + '}'").append(";\n");
            codigo.append("    }\n\n");
        }

        // Fim da classe
        codigo.append("}\n");

        return codigo.toString();
    }

    // Método auxiliar para capitalizar a primeira letra de uma string
    private String capitalize(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Solange();
            }
        });
    }
}

