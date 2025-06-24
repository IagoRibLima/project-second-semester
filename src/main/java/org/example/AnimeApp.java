/*
 * Created by JFormDesigner on Tue Jun 17 23:56:17 BRT 2025
 */

package org.example;

import javax.swing.*;
import net.miginfocom.swing.*;

import java.awt.*;

/**
 * @author iago-lima
 */
public class AnimeApp extends JFrame {
    public AnimeApp() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Iago
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

        //======== this ========
        setTitle("Gerenciador de Animes");
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
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
            "[]"));

        //---- labelDetails ----
        labelDetails.setText("Detalhes do Item");
        contentPane.add(labelDetails, "cell 1 1 3 1");

        //---- labelName ----
        labelName.setText("Nome:");
        contentPane.add(labelName, "cell 1 2");
        contentPane.add(textFieldName, "cell 3 2 29 1");

        //---- buttonClean ----
        buttonClean.setText("Limpar Campos");
        contentPane.add(buttonClean, "cell 32 2");

        //---- labelNota ----
        labelNota.setText("Nota:");
        contentPane.add(labelNota, "cell 1 3");
        contentPane.add(textFieldNota, "cell 3 3 29 1");

        //---- buttonRemove ----
        buttonRemove.setText("Remover Selecionado");
        contentPane.add(buttonRemove, "cell 32 3");

        //---- labelComentario ----
        labelComentario.setText("Coment\u00e1rio:");
        contentPane.add(labelComentario, "cell 1 4");
        contentPane.add(textFieldComentario, "cell 3 4 29 1");

        //---- buttonAdd ----
        buttonAdd.setText("Adicionar Item");
        contentPane.add(buttonAdd, "cell 32 4");

        //---- labelItens ----
        labelItens.setText("Itens da Cole\u00e7\u00e3o");
        contentPane.add(labelItens, "cell 1 6 4 1");

        //======== scrollPaneItens ========
        {
            scrollPaneItens.setViewportView(list1);
        }
        contentPane.add(scrollPaneItens, "cell 1 7 32 11");

        //---- buttonCarregar ----
        buttonCarregar.setText("Carregar Arquivo");
        contentPane.add(buttonCarregar, "cell 21 18");

        //---- buttonAtualizar ----
        buttonAtualizar.setText("Atualizar Arquivo");
        contentPane.add(buttonAtualizar, "cell 22 18");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Iago
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
