package org.example;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AnimeApp extends JFrame {
    private JLabel labelDetails;
    private JLabel labelName;
    private JLabel labelNota;
    private JLabel labelComentario;
    private JLabel labelBusca;
    private JTextField textFieldName;
    private JTextField textFieldNota;
    private JTextField textFieldComentario;
    private JTextField textFieldBusca;
    private JButton buttonClean;
    private JButton buttonRemove;
    private JButton buttonAdd;
    private JButton buttonCarregar;
    private JButton buttonAtualizar;
    private JButton buttonEdit;
    private JButton buttonSearch;
    private JLabel labelItens;
    private JScrollPane scrollPaneItens;
    private JList <Anime> itemList;
    private DefaultListModel<Anime> listModel;
    private JLabel statusLabel;

    private List<Anime> colecao;

    private static final String ANIMETXT = "./src/main/java/org/example/animes.txt";

    public AnimeApp(){
        setTitle("Gerenciador de Animes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        colecao = new ArrayList<>();
        listModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);

        initComponents();
        setSize(1280, 780);
        setLocationRelativeTo(null);
        addListeners();
        atualizarListaVisual();
    }

    private void initComponents(){
        BackgroundPanel backgroundPanel = new BackgroundPanel("/images/background-dark.png");
        backgroundPanel.setLayout(new BorderLayout(15, 15));
        backgroundPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setContentPane(backgroundPanel);

        labelDetails = new JLabel("Detalhes do Item");
        labelDetails.setForeground(Color.WHITE);
        labelDetails.setFont(new Font("Segoe UI", Font.BOLD, 18));

        labelName = new JLabel("Nome:");
        labelName.setForeground(Color.WHITE);
        labelName.setFont(new Font("Segoe UI", Font.BOLD, 13));
        textFieldName = new JTextField();
        textFieldName.setOpaque(false);
        textFieldName.setForeground(Color.WHITE);
        textFieldName.setCaretColor(Color.WHITE);

        labelNota = new JLabel("Nota:");
        labelNota.setForeground(Color.WHITE);
        labelNota.setFont(new Font("Segoe UI", Font.BOLD, 13));
        textFieldNota = new JTextField();
        textFieldNota.setOpaque(false);
        textFieldNota.setForeground(Color.WHITE);
        textFieldNota.setCaretColor(Color.WHITE);

        labelComentario = new JLabel("Comentário:");
        labelComentario.setForeground(Color.WHITE);
        labelComentario.setFont(new Font("Segoe UI", Font.BOLD, 13));
        textFieldComentario = new JTextField();
        textFieldComentario.setOpaque(false);
        textFieldComentario.setForeground(Color.WHITE);
        textFieldComentario.setCaretColor(Color.WHITE);

        labelBusca = new JLabel("Buscar:");
        labelBusca.setForeground(Color.WHITE);
        labelBusca.setFont(new Font("Segoe UI", Font.BOLD, 13));
        textFieldBusca = new JTextField();
        textFieldBusca.setOpaque(false);
        textFieldBusca.setForeground(Color.WHITE);
        textFieldBusca.setCaretColor(Color.WHITE);

        labelItens = new JLabel("Itens da Coleção:");
        labelItens.setForeground(Color.WHITE);
        labelItens.setFont(new Font("Segoe UI", Font.BOLD, 16));

        scrollPaneItens = new JScrollPane();
        scrollPaneItens.setViewportView(itemList);
        scrollPaneItens.setOpaque(false);
        scrollPaneItens.getViewport().setOpaque(false);

        itemList.setBackground(new Color(0, 0, 0, 50));
        itemList.setForeground(Color.WHITE);
        itemList.setSelectionBackground(new Color(50, 150, 250, 90));
        itemList.setSelectionForeground(Color.WHITE);
        itemList.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 1));

        statusLabel = new JLabel("Pronto");
        statusLabel.setForeground(Color.WHITE);

        ImageIcon pesquisarIcon = loadImageIcon("pesquisar.png");
        ImageIcon addIcon = loadImageIcon("adicionar.png");
        ImageIcon removerIcon = loadImageIcon("remover.png");
        ImageIcon editarIcon = loadImageIcon("editar.png");
        ImageIcon limparIcon = loadImageIcon("limpar-campos.png");
        ImageIcon carregarIcon = loadImageIcon("carregar.png");
        ImageIcon salvarIcon = loadImageIcon("salvar.png");

        buttonSearch = new JButton(pesquisarIcon);
        buttonAdd = new JButton(addIcon);
        buttonRemove = new JButton(removerIcon);
        buttonEdit = new JButton(editarIcon);
        buttonClean = new JButton(limparIcon);
        buttonCarregar = new JButton(carregarIcon);
        buttonAtualizar = new JButton(salvarIcon);

        buttonSearch.setOpaque(false); // Torna o botão transparente
        buttonSearch.setContentAreaFilled(false); // Remove o preenchimento de área padrão
        buttonSearch.setBorderPainted(false); // Remove a borda padrão do botão
        buttonSearch.setFocusPainted(false); // Remove o retângulo de foco (ao clicar/tab)
        buttonSearch.setPreferredSize(new Dimension(150, 50));
        buttonSearch.setMaximumSize(new Dimension(150, 50));
        buttonSearch.setMinimumSize(new Dimension(150, 50));

        buttonAdd.setOpaque(false);
        buttonAdd.setContentAreaFilled(false);
        buttonAdd.setBorderPainted(false);
        buttonAdd.setFocusPainted(false);
        buttonAdd.setPreferredSize(new Dimension(150, 50));
        buttonAdd.setMaximumSize(new Dimension(150, 50));
        buttonAdd.setMinimumSize(new Dimension(150, 50));

        buttonRemove.setOpaque(false);
        buttonRemove.setContentAreaFilled(false);
        buttonRemove.setBorderPainted(false);
        buttonRemove.setFocusPainted(false);
        buttonRemove.setPreferredSize(new Dimension(150, 50));
        buttonRemove.setMaximumSize(new Dimension(150, 50));
        buttonRemove.setMinimumSize(new Dimension(150, 50));

        buttonEdit.setOpaque(false);
        buttonEdit.setContentAreaFilled(false);
        buttonEdit.setBorderPainted(false);
        buttonEdit.setFocusPainted(false);
        buttonEdit.setPreferredSize(new Dimension(150, 50));
        buttonEdit.setMaximumSize(new Dimension(150, 50));
        buttonEdit.setMinimumSize(new Dimension(150, 50));

        buttonClean.setOpaque(false);
        buttonClean.setContentAreaFilled(false);
        buttonClean.setBorderPainted(false);
        buttonClean.setFocusPainted(false);
        buttonClean.setPreferredSize(new Dimension(150, 50));
        buttonClean.setMaximumSize(new Dimension(150, 50));
        buttonClean.setMinimumSize(new Dimension(150, 50));

        buttonCarregar.setOpaque(false);
        buttonCarregar.setContentAreaFilled(false);
        buttonCarregar.setBorderPainted(false);
        buttonCarregar.setFocusPainted(false);
        buttonCarregar.setPreferredSize(new Dimension(150, 50));
        buttonCarregar.setMaximumSize(new Dimension(150, 50));
        buttonCarregar.setMinimumSize(new Dimension(150, 50));


        buttonAtualizar.setOpaque(false);
        buttonAtualizar.setContentAreaFilled(false);
        buttonAtualizar.setBorderPainted(false);
        buttonAtualizar.setFocusPainted(false);
        buttonAtualizar.setPreferredSize(new Dimension(150, 50));
        buttonAtualizar.setMaximumSize(new Dimension(150, 50));
        buttonAtualizar.setMinimumSize(new Dimension(150, 50));

        backgroundPanel.add(labelDetails, BorderLayout.NORTH);

        JPanel centralPanel = new JPanel(new BorderLayout(0, 15));
        centralPanel.setOpaque(false);
        centralPanel.setBorder(BorderFactory.createEmptyBorder());

        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(labelName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        inputPanel.add(textFieldName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        inputPanel.add(labelNota, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        inputPanel.add(textFieldNota, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        inputPanel.add(labelComentario, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1;
        inputPanel.add(textFieldComentario, gbc);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setForeground(Color.GRAY);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 0, 10, 0);
        inputPanel.add(separator, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        inputPanel.add(labelBusca, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1;
        inputPanel.add(textFieldBusca, gbc);

        centralPanel.add(inputPanel, BorderLayout.NORTH);

        JPanel listAndButtonsPanel = new JPanel(new BorderLayout(15, 0));
        listAndButtonsPanel.setOpaque(false);

        JPanel listAreaPanel = new JPanel(new BorderLayout(0, 5));
        listAreaPanel.setOpaque(false);
        listAreaPanel.add(labelItens, BorderLayout.NORTH);
        listAreaPanel.add(scrollPaneItens, BorderLayout.CENTER);

        listAndButtonsPanel.add(listAreaPanel, BorderLayout.CENTER);

        JPanel rightButtonsPanel = new JPanel();
        rightButtonsPanel.setOpaque(false); // Torna-o transparente
        rightButtonsPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.gridx = 0;

        gbc.gridy = 0; rightButtonsPanel.add(buttonSearch, gbc);
        gbc.gridy = 1; rightButtonsPanel.add(buttonAdd, gbc);
        gbc.gridy = 2; rightButtonsPanel.add(buttonRemove, gbc);
        gbc.gridy = 3; rightButtonsPanel.add(buttonEdit, gbc);
        gbc.gridy = 4; rightButtonsPanel.add(buttonClean, gbc);
        gbc.gridy = 5; rightButtonsPanel.add(buttonCarregar, gbc);
        gbc.gridy = 6; rightButtonsPanel.add(buttonAtualizar, gbc);

        listAndButtonsPanel.add(rightButtonsPanel, BorderLayout.EAST);
        centralPanel.add(listAndButtonsPanel, BorderLayout.CENTER);
        backgroundPanel.add(centralPanel, BorderLayout.CENTER);
        backgroundPanel.add(statusLabel, BorderLayout.SOUTH);
    }

    private void addListeners(){
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisarItem();
            }
        });

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarItem();
            }
        });

        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerItemSelecionado();
            }
        });

        buttonEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarItem();
            }
        });

        buttonClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCamposDeEntrada();
            }
        });

        buttonCarregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarArquivo();
            }
        });

        buttonAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarArquivo();
            }
        });

        itemList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()){
                    buttonRemove.setEnabled(itemList.getSelectedIndex() != -1);
                    if (itemList.getSelectedIndex() != -1){
                        carregarItemSelecionadoNosCampos();
                    }
                }
            }
        });
    }

    private void pesquisarItem(){
        String termoBusca = textFieldBusca.getText().trim();
        listModel.clear();
        if (termoBusca.isEmpty()) {
            for (Anime anime : colecao) {
                listModel.addElement(anime);
            }
            statusLabel.setText("Exibindo todos os " + colecao.size() + " animes.");
        } else {
            int resultadosEncontrados = 0;
            for (Anime anime : colecao) {
                if (anime.getNome().toLowerCase().contains(termoBusca.toLowerCase()) ||
                        anime.getComentario().toLowerCase().contains(termoBusca.toLowerCase())) {
                    listModel.addElement(anime);
                    resultadosEncontrados++;
                }
            }
            if (resultadosEncontrados > 0) {
                statusLabel.setText(resultadosEncontrados + " resultado(s) encontrado(s) para '" + termoBusca + "'.");
            } else {
                statusLabel.setText("Nenhum anime encontrado com o termo '" + termoBusca + "'.");
            }
        }
        itemList.repaint();
        scrollPaneItens.repaint();
    }

    private void adicionarItem(){
        String nome = textFieldName.getText().trim();
        String nota = textFieldNota.getText().trim();
        String comentario = textFieldComentario.getText().trim();

        if (nome.isEmpty()){
            JOptionPane.showMessageDialog(this,
                    "O campo 'Nome' não pode estar vazio.",
                    "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            textFieldName.requestFocus();
            statusLabel.setText("Erro: Nome é obrigatório");
            return;
        }
        try {
            double notaNumerica = Double.parseDouble(nota);
            if (notaNumerica < 0 || notaNumerica > 10) {
                JOptionPane.showMessageDialog(this,
                        "A nota deve ser entre 0 e 10!",
                        "Erro de Validação",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "A nota deve ser um número válido!",
                    "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Anime novoItem = new Anime(nome, nota, comentario);
        colecao.add(novoItem);

        atualizarListaVisual();
        limparCamposDeEntrada();
        textFieldName.requestFocus();
        statusLabel.setText("Item '" + nome + "' adicionado com sucesso!");
    }

    private void removerItemSelecionado(){
        int selectedIndex = itemList.getSelectedIndex();
        if (selectedIndex != -1){
            Anime itemRemovido = colecao.get(selectedIndex);
            int confirmacao = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja remover o item: " + itemRemovido.getNome() + "?",
                    "Confirmar Remoção",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (confirmacao == JOptionPane.YES_OPTION){
                colecao.remove(selectedIndex);
                atualizarListaVisual();
                limparCamposDeEntrada();
                statusLabel.setText("Item '" + itemRemovido.getNome() + "' removido.");
                buttonRemove.setEnabled(true);
            }else {
                statusLabel.setText("Remoção cancelada");
                buttonRemove.setEnabled(true);
            }
        }else {
            JOptionPane.showMessageDialog(this,
                    "Nenhum item selecionado para remover.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            statusLabel.setText("Nenhum item selecionado.");
            buttonRemove.setEnabled(true);
        }
    }

    private void editarItem(){
        int selectedIndex = itemList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this,
                    "Nenhum anime selecionado para editar.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            statusLabel.setText("Nenhum anime selecionado para editar.");
            return;
        }

        Anime selectedAnimeFromList = itemList.getSelectedValue();
        Anime itemParaEditar = null;
        for (Anime anime : colecao) {
            if (anime.equals(selectedAnimeFromList)) {
                itemParaEditar = anime;
                break;
            }
        }

        if (itemParaEditar == null) {
            JOptionPane.showMessageDialog(this,
                    "Item selecionado não encontrado na coleção principal. Tente pesquisar novamente e selecionar.",
                    "Erro de Edição",
                    JOptionPane.ERROR_MESSAGE);
            statusLabel.setText("Erro ao encontrar item para edição.");
            return;
        }

        String nome = textFieldName.getText().trim();
        String nota = textFieldNota.getText().trim();
        String comentario = textFieldComentario.getText().trim();

        if (nome.isEmpty()){
            JOptionPane.showMessageDialog(this,
                    "O campo 'Nome' não pode estar vazio.",
                    "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            textFieldName.requestFocus();
            statusLabel.setText("Erro: Nome é obrigatório para edição.");
            return;
        }
        try {
            double notaNumerica = Double.parseDouble(nota);
            if (notaNumerica < 0 || notaNumerica > 10) {
                JOptionPane.showMessageDialog(this,
                        "A nota deve ser entre 0 e 10!",
                        "Erro de Validação",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "A nota deve ser um número válido!",
                    "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Atualiza os dados do item
        itemParaEditar.setNome(nome);
        itemParaEditar.setNota(nota);
        itemParaEditar.setComentario(comentario);

        statusLabel.setText("Anime '" + nome + "' atualizado com sucesso!");
        atualizarListaVisual();
        limparCamposDeEntrada();
    }

    private void limparCamposDeEntrada(){
        textFieldName.setText("");
        textFieldNota.setText("");
        textFieldComentario.setText("");
        textFieldBusca.setText("");
        itemList.clearSelection();
        textFieldName.requestFocus();
        statusLabel.setText("Campos limpos");
    }

    private void carregarArquivo(){
        File arquivoDados = new File(ANIMETXT);

        if (!arquivoDados.exists()) {
            statusLabel.setText("Arquivo de dados '" + ANIMETXT + "' não encontrado. Iniciando com coleção vazia.");
            colecao.clear();
            atualizarListaVisual();
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoDados))) {
            colecao.clear();
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 3) {
                    colecao.add(new Anime(partes[0], partes[1], partes[2]));
                }
            }
            atualizarListaVisual();
            limparCamposDeEntrada(); // Opcional: limpa campos após carregar
            statusLabel.setText("Dados carregados de '" + ANIMETXT + "'. Total: " + colecao.size() + " animes.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar o arquivo '" + ANIMETXT + "': " + e.getMessage(),
                    "Erro de Leitura",
                    JOptionPane.ERROR_MESSAGE);
            statusLabel.setText("Erro ao carregar arquivo de dados.");
            e.printStackTrace();
        }
    }

    private void atualizarArquivo(){
        File arquivoDados = new File(ANIMETXT);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoDados))) {
            for (Anime anime : colecao) {
                writer.write(anime.getNome() + "," + anime.getNota() + "," + anime.getComentario());
                writer.newLine();
            }
            statusLabel.setText("Dados salvos em '" + ANIMETXT + "'. Total: " + colecao.size() + " animes.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao salvar o arquivo '" + ANIMETXT + "': " + e.getMessage(),
                    "Erro de Escrita",
                    JOptionPane.ERROR_MESSAGE);
            statusLabel.setText("Erro ao salvar arquivo de dados.");
            e.printStackTrace();
        }
    }

    private void carregarItemSelecionadoNosCampos(){
        Anime itemSelecionado = itemList.getSelectedValue();
        if (itemSelecionado != null){
            textFieldName.setText(itemSelecionado.getNome());
            textFieldNota.setText(itemSelecionado.getNota());
            textFieldComentario.setText(itemSelecionado.getComentario());
            statusLabel.setText("Item '" + itemSelecionado.getNome() + "' carregado para edição ou exclusão.");
        }
    }

    private void atualizarListaVisual(){
        listModel.clear();
        for (Anime item : colecao){
            listModel.addElement(item);
        }
        itemList.repaint();
        scrollPaneItens.repaint();
    }

    private ImageIcon loadImageIcon (String path){
        try{
            java.net.URL imgURL = getClass().getResource("/images/" + path);
            if (imgURL != null) {
                return new ImageIcon(imgURL);
            }else {
                System.err.println("Não foi possível encontrar o arquivo: " + path);
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}