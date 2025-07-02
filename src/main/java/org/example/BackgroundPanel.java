package org.example;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath){
        try{
            java.net.URL imgURL = getClass().getResource(imagePath);
            if (imgURL != null){
                this.backgroundImage = new ImageIcon(imgURL).getImage();
            }else {
                System.err.println("Erro: não foi possivel carregar a imagem de fundo: " + imagePath);
                setBackground(Color.DARK_GRAY);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("Exceção ao carregar imagem de fundo: " + imagePath);
            setBackground(Color.DARK_GRAY);
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if (backgroundImage != null){
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
