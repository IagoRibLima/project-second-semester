package org.example;

import javax.swing.*;
import net.miginfocom.swing.*;

import java.io.*;

public class AnimeApp extends JFrame {
    private DefaultListModel<String> animeListModel;
    private static final String FILE_NAME = "./src/main/java/org/example/animes.txt";

    public AnimeApp() {
        animeListModel = new DefaultListModel<>();
        initComponents();
        list1.setModel(animeListModel);
        addEventListeners();
        loadAnimesFromFile();
    }

    // Métodos para inicializar o componente
    private void initComponents() {
        labelDetails = new JLabel();
        labelName = new JLabel();
        textFieldName = new JTextField();
        buttonClean = new JButton();
        labelNota = new JLabel();
        textFieldNota = new JTextField();
        buttonRemove = new JButton();
        labelComentario = new JLabel();
        textFieldComentario = new JTextField();
        buttonAdd = new JButton();
        labelItens = new JLabel();
        scrollPaneItens = new JScrollPane();
        list1 = new JList();
        buttonCarregar = new JButton();
        buttonAtualizar = new JButton();

        setTitle("Gerenciador de Animes");
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
                "hidemode 3",
                // colunas
                "[fill]" +
                        "[fill]" +
                        "[]" +
                        "[grow,push,fill]" +
                        "[grow,push,fill]" +
                        "[]" +
                        "[grow,push,fill]" +
                        "[grow,push,fill]" +
                        "[grow,push]" +
                        "[]" +
                        "[grow,push]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[fill]",
                // linhas
                "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[grow,push,fill]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));

        // Adicionando componentes ao contentPane
        contentPane.add(labelDetails, "cell 1 1 3 1");
        contentPane.add(labelName, "cell 1 2");
        contentPane.add(textFieldName, "cell 3 2 29 1, growx");
        contentPane.add(buttonClean, "cell 32 2, sg 1, align right");
        contentPane.add(labelNota, "cell 1 3");
        contentPane.add(textFieldNota, "cell 3 3 29 1, growx");
        contentPane.add(buttonRemove, "cell 32 3, sg 1, align right");
        contentPane.add(labelComentario, "cell 1 4");
        contentPane.add(textFieldComentario, "cell 3 4 29 1, growx");
        contentPane.add(buttonAdd, "cell 32 4, sg 1, align right");
        contentPane.add(labelItens, "cell 1 6 4 1");
        contentPane.add(scrollPaneItens, "cell 1 7 32 11, grow, push");
        contentPane.add(buttonCarregar, "cell 21 18, sg 2, align right");
        contentPane.add(buttonAtualizar, "cell 22 18, sg 2, align right");

        // Configurações básicas dos componentes
        labelDetails.setText("Detalhes do Item");
        labelName.setText("Nome:");
        buttonClean.setText("Limpar Campos");
        labelNota.setText("Nota:");
        buttonRemove.setText("Remover Selecionado");
        labelComentario.setText("Comentário:");
        buttonAdd.setText("Adicionar Item");
        labelItens.setText("Itens da Coleção");
        scrollPaneItens.setViewportView(list1);
        buttonCarregar.setText("Carregar Arquivo");
        buttonAtualizar.setText("Atualizar Arquivo");

        pack();
        setLocationRelativeTo(getOwner());
    }

    //Métodos para manipular a lógica do aplicativo

    // Adicionar listeners nos botões
    private void addEventListeners() {
        buttonClean.addActionListener(e -> cleanFields());
        buttonAdd.addActionListener(e -> addAnime());
        buttonRemove.addActionListener(e -> removeSelectedAnime());
        buttonCarregar.addActionListener(e -> loadAnimesFromFile());
        buttonAtualizar.addActionListener(e -> updateAnimesToFile());
    }

    // Limpar campos de texto
    private void cleanFields() {
        textFieldName.setText("");
        textFieldNota.setText("");
        textFieldComentario.setText("");
    }

    // Adicionar um anime na lista
    private void addAnime() {
        String nome = textFieldName.getText().trim();
        String nota = textFieldNota.getText().trim();
        String comentario = textFieldComentario.getText().trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O nome do anime não pode estar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double notaNumerica = Double.parseDouble(nota);
            if (notaNumerica < 0 || notaNumerica > 10) {
                JOptionPane.showMessageDialog(this, "A nota deve ser entre 0 e 10!", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "A nota deve ser um número válido!", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String animeInfoForList = String.format("Nome: %s | Nota: %s | Comentário: %s", nome, nota, comentario);
        animeListModel.addElement(animeInfoForList);
        cleanFields();
    }

    // Remover anime selecionado da lista
    private void removeSelectedAnime() {
        int selectedIndex = list1.getSelectedIndex();
        if (selectedIndex != -1) {
            animeListModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum item selecionado para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    //Função para Carregar Animes do Arquivo TXT
    private void loadAnimesFromFile(){
        animeListModel.clear();
        File file = new File(FILE_NAME);

        if (!file.exists()){
            JOptionPane.showMessageDialog(this, "Arquivo '" + FILE_NAME + "'não encontrado. Criando um novo.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null){
                if (line.trim().isEmpty()){
                    continue;
                }
                String[] parts = line.split(",", 3);

                if (parts.length >=3){
                    String nome = parts[0].trim();
                    String nota = parts[1].trim();
                    String comentario = parts[2].trim();
                    String animeInfoForList = String.format("Nome: %s | Nota: %s | Comentário: %s", nome, nota, comentario);
                    animeListModel.addElement(animeInfoForList);
                }else if (parts.length == 2){
                    String nome = parts[0].trim();
                    String nota = parts[1].trim();
                    String animeInfoForList = String.format("Nome: %s | Nota: %s | Comentário: (N/A)", nome, nota);
                    animeListModel.addElement(animeInfoForList);
                }else if (parts.length == 1){
                    String nome = parts[0].trim();
                    String animeInfoForList = String.format("Nome: %s | Nota: (N/A) | Comentário: (N/A)", nome);
                    animeListModel.addElement(animeInfoForList);
                }
            }
            JOptionPane.showMessageDialog(this, "Animes carregados com sucesso do arquivo '" + FILE_NAME + "'!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }catch (IOException e){
            JOptionPane.showMessageDialog(this, "Erro ao carregar animes do arquivo: " + e.getMessage(), "Erro de Leitura", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    //Função para atualizar (sobrescrever) o arquivo txt
    private void updateAnimesToFile(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
            for (int i = 0; i < animeListModel.getSize(); i++) {
                String fullAnimeInfo = animeListModel.getElementAt(i);

                String name = "";
                String nota = "";
                String comentario = "";

                if (fullAnimeInfo.startsWith("Nome: ")) {
                    String[] parts = fullAnimeInfo.split(" \\| ");
                    if (parts.length > 0) {
                        name = parts[0].substring("Nome: ".length()).trim();
                    }
                    if (parts.length > 1 && parts[1].startsWith("Nota: ")) {
                        nota = parts[1].substring("Nota: ".length()).trim();
                    }
                    if (parts.length > 2 && parts[2].startsWith("Comentário: ")) {
                        comentario = parts[2].substring("Comentário: ".length()).trim();
                    }
                }
                if (name.equals("(N/A)")) name = "";
                if (nota.equals("(N/A)")) nota = "";
                if (comentario.equals("(N/A)")) comentario = "";

                // Salva no formato Nome,Nota,Comentário
                writer.write(String.format("%s,%s,%s", name, nota, comentario));
                writer.newLine();
            }
            JOptionPane.showMessageDialog(this, "Animes salvos com sucesso no arquivo '" + FILE_NAME + "'!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }catch (IOException e){
            JOptionPane.showMessageDialog(this, "Erro ao salvar animes no arquivo: " + e.getMessage(), "Erro de Escrita", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private JLabel labelDetails;
    private JLabel labelName;
    private JTextField textFieldName;
    private JButton buttonClean;
    private JLabel labelNota;
    private JTextField textFieldNota;
    private JButton buttonRemove;
    private JLabel labelComentario;
    private JTextField textFieldComentario;
    private JButton buttonAdd;
    private JLabel labelItens;
    private JScrollPane scrollPaneItens;
    private JList list1;
    private JButton buttonCarregar;
    private JButton buttonAtualizar;

    //Main para iniciar o projeto
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AnimeApp frame = new AnimeApp();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}