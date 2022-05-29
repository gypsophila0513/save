
package view;



import controller.GameController;
import model.ChessColor;
import model.ChessComponent;

import javax.swing.*;
//import javax.swing.JLayeredPane;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import javax.swing.ImageIcon;
//import javax.swing.JPanel;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
//import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.AttributedCharacterIterator;
import java.util.List;

/**
 * 这个类表示游戏过程中的整个游戏界面，是一切的载体
 */

public class ChessGameFrame extends JFrame {
    //    public final Dimension FRAME_SIZE ;
    private final int WIDTH;
    private final int HEIGTH;
    public final int CHESSBOARD_SIZE;
    private static GameController gameController;
    private Chessboard chessboard;
    private static JLabel statusLabel = new JLabel("White Turn");
    JButton button = new JButton("Restart");
    JButton button2 = new JButton("Theme");
    boolean judge = true;
    JPanel panel = new JPanel();
    public static int decide = 0;


    public ChessGameFrame(int width, int height) {
        setTitle("Chess"); //设置标题
        this.WIDTH = width;
        this.HEIGTH = height;
        this.CHESSBOARD_SIZE = HEIGTH * 4 / 5;


        //this.getContentPane().setBackground(Color.red);
        //this.getContentPane().setVisible(false);
        //this.setLayout(null);


        setSize(WIDTH, HEIGTH);
        setLocationRelativeTo(null); // Center the window.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);
        panel.setLayout(null);
        ImageIcon image = new ImageIcon("src./images/background(1).png");
        int width1 = image.getIconWidth();
        int height1 = image.getIconHeight();


        setContentPane(panel);
        JLabel background = new JLabel(image);
        background.setSize(width1, height1);
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        ((JPanel) this.getContentPane()).setOpaque(false);
        background.setFont(new Font("Rockwell", Font.BOLD, 20));


        addChessboard();
        addLabel();
        addHelloButton();
        addLoadButton();
        addSaveButton();
        addUndoButton();
        addReStartButton();
        addThemeButton();

    }

    private void addChessboard() {
        Chessboard chessboard = new Chessboard(CHESSBOARD_SIZE, CHESSBOARD_SIZE);
        gameController = new GameController(chessboard);
        chessboard.setLocation(HEIGTH / 10, HEIGTH / 10);
        add(chessboard);
    }

    private void addThemeButton() {


        button2.setLocation(HEIGTH, HEIGTH / 10 + 480);
        button2.setSize(200, 60);
        button2.setFont(new Font("Rockwell", Font.BOLD, 20));
        this.add(button2);

        Graphics g = new Graphics() {
            @Override
            public Graphics create() {
                return null;
            }

            @Override
            public void translate(int x, int y) {

            }

            @Override
            public Color getColor() {
                return null;
            }

            @Override
            public void setColor(Color c) {

            }

            @Override
            public void setPaintMode() {

            }

            @Override
            public void setXORMode(Color c1) {

            }

            @Override
            public Font getFont() {
                return null;
            }

            @Override
            public void setFont(Font font) {

            }

            @Override
            public FontMetrics getFontMetrics(Font f) {
                return null;
            }

            @Override
            public Rectangle getClipBounds() {
                return null;
            }

            @Override
            public void clipRect(int x, int y, int width, int height) {

            }

            @Override
            public void setClip(int x, int y, int width, int height) {

            }

            @Override
            public Shape getClip() {
                return null;
            }

            @Override
            public void setClip(Shape clip) {

            }

            @Override
            public void copyArea(int x, int y, int width, int height, int dx, int dy) {

            }

            @Override
            public void drawLine(int x1, int y1, int x2, int y2) {

            }

            @Override
            public void fillRect(int x, int y, int width, int height) {

            }

            @Override
            public void clearRect(int x, int y, int width, int height) {

            }

            @Override
            public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

            }

            @Override
            public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

            }

            @Override
            public void drawOval(int x, int y, int width, int height) {

            }

            @Override
            public void fillOval(int x, int y, int width, int height) {

            }

            @Override
            public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

            }

            @Override
            public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

            }

            @Override
            public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void drawString(String str, int x, int y) {

            }

            @Override
            public void drawString(AttributedCharacterIterator iterator, int x, int y) {

            }

            @Override
            public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public void dispose() {

            }
        };
        button2.addActionListener(e -> {
            System.out.printf("Click Theme");
            decide = decide + 1;
            Color[] colors1 = new Color[]{Color.WHITE, Color.black};
            Color[] colors2 = new Color[]{Color.LIGHT_GRAY, Color.BLUE};
            int i;
            int j;
            if (chessboard.getChessComponents()[0][0].getBACKGROUND_COLORS()[0] == Color.WHITE) {
                for (i = 0; i < 8; ++i) {
                    for (j = 0; j < 8; ++j) {
                        chessboard.getChessComponents()[i][j].setBACKGROUND_COLORS(colors2);
                        chessboard.getChessComponents()[i][j].repaint();
                    }
                }
            } else {
                for (i = 0; i < 8; ++i) {
                    for (j = 0; j < 8; ++j) {
                        chessboard.getChessComponents()[i][j].setBACKGROUND_COLORS(colors1);
                        chessboard.getChessComponents()[i][j].repaint();

                    }
                }
            }
        });


//        panel.setLayout(null);
//        ImageIcon image = new ImageIcon("project./images/background(1).png");
//        JLabel background = new JLabel(image);
        if (decide % 2 == 0) {
            panel.setLayout(null);
            Image image = new ImageIcon("src./images/background(1).png").getImage();
            g.drawImage(image, 0, 0, 1000, 760, this);


//            int width1 = image.getWidth();
//            int height1 = image.getHeight();


            setContentPane(panel);

//            background.setSize(width1, height1);
//            getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
//            ((JPanel) this.getContentPane()).setOpaque(false);
//            background.setFont(new Font("Rockwell", Font.BOLD, 20));


        }
        if (decide % 2 == 1) {

//            background.setVisible(false);
//            image.setImage(null);
            panel.setLayout(null);

//            ImageIcon image2 = new ImageIcon("project./images/background(1).png");

            Image image2 = new ImageIcon("src./images/bb(1).png").getImage();
            g.drawImage(image2, 0, 0, 1000, 760, this);
//            int width1 = image2.getIconWidth();
//            int height1 = image2.getIconHeight();
            imageUpdate(image2, 0, 0, 0, 0, 0);
            setContentPane(panel);

//            setContentPane(panel);
//            JLabel background2 = new JLabel(image2);
//            background2.setSize(width1, height1);
//            getLayeredPane().add(background2, new Integer(Integer.MIN_VALUE));
//            ((JPanel) this.getContentPane()).setOpaque(false);
//            background2.setFont(new Font("Rockwell", Font.BOLD, 20));
        }
    }
    private void addChangeColor(Chessboard chessboard){
        button2.addActionListener(e -> {
            System.out.printf("Click Theme");
            decide = decide + 1;
            Color[] colors1 = new Color[]{Color.WHITE, Color.black};
            Color[] colors2 = new Color[]{Color.LIGHT_GRAY, Color.BLUE};
            int i;
            int j;
            if (chessboard.getChessComponents()[0][0].getBACKGROUND_COLORS()[0] == Color.WHITE) {
                for (i = 0; i < 8; ++i) {
                    for (j = 0; j < 8; ++j) {
                        chessboard.getChessComponents()[i][j].setBACKGROUND_COLORS(colors2);
                        chessboard.getChessComponents()[i][j].repaint();
                    }
                }
            } else {
                for (i = 0; i < 8; ++i) {
                    for (j = 0; j < 8; ++j) {
                        chessboard.getChessComponents()[i][j].setBACKGROUND_COLORS(colors1);
                        chessboard.getChessComponents()[i][j].repaint();

                    }
                }
            }
        });

    }


    /**
     * 在游戏面板中添加棋盘
     */


    /**
     * 在游戏面板中添加标签
     */
    public void addLabel() {
        statusLabel.setLocation(HEIGTH, HEIGTH / 10);
        statusLabel.setSize(200, 60);
        statusLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(statusLabel);


//        if(gameController.getChessboard().getCurrentColor() == ChessColor.WHITE){
//            statusLabel.setVisible(true);
//            statusLabel2.setVisible(false);
//        }else if(gameController.getChessboard().getCurrentColor() == ChessColor.BLACK){
//            statusLabel2.setVisible(true);
//            statusLabel.setVisible(false);
//        }
    }

    /**
     * 在游戏面板中增加一个按钮，如果按下的话就会显示Hello, world!
     */

    private void addHelloButton() {
        JButton button = new JButton("Show Hello Here");
        button.addActionListener((e) -> JOptionPane.showMessageDialog(this, "Hello, world!"));
        button.setLocation(HEIGTH, HEIGTH / 10 + 80);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }


    public void addLoadButton() {
        JButton button = new JButton("Load");
        button.setLocation(HEIGTH, HEIGTH / 10 + 160);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
//        if(){
//            judge = true;
//        }else{
//            judge = false;
//        }

        button.addActionListener(e -> {
            System.out.println("Click load");
            String path = JOptionPane.showInputDialog(this, "Input Path here");

            if (judge == false) {
                JOptionPane.showConfirmDialog(this, "Wrong format save");
            }
////            if () {
//
//            } else {
//                gameController.loadGameFromFile(path);
//            }
        });
    }

    private void addSaveButton() {
        JButton button = new JButton("Save");
        button.setLocation(HEIGTH, HEIGTH / 10 + 240);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
        button.addActionListener(e -> {
            System.out.println("Click save");
            String path = JOptionPane.showInputDialog(this, "Name this save");
            List<String> chessData = gameController.saveGameFile();
            StringBuilder save = new StringBuilder();
            for (int i = 0; i < chessData.size(); i++) {
                save.append(chessData.get(i));
                save.append("\n");
            }
            File file = new File("src./save/" + path + ".txt");
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            DataOutputStream os = null;
            try {
                os = new DataOutputStream(new FileOutputStream(file));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            try {
                os.writeBytes(save.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void addUndoButton() {
        JButton button = new JButton("Undo");
        button.setLocation(HEIGTH, HEIGTH / 10 + 320);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }

    private void addReStartButton() {
        JButton button2 = new JButton("Restart");
        button2.setLocation(HEIGTH, HEIGTH / 10 + 400);
        button2.setSize(200, 60);
        button2.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button2);
        button2.addActionListener(e -> {
            System.out.println("Click Restart");
            String path = ("src./save/initial.txt");
            gameController.loadGameFromFile(path);
        });

    }

    public static void click() {

        if (gameController.getChessboard().getCurrentColor() == ChessColor.WHITE) {
            statusLabel.setText("White Turn");
        } else if (gameController.getChessboard().getCurrentColor() == ChessColor.BLACK) {
            statusLabel.setText("Black Turn");
        }
    }

    public static void playClickMusic() throws MalformedURLException {
        File file = new File("src./music/eat.wav");
        AudioClip ac = Applet.newAudioClip(file.toURL());
        ac.play();
    }

//    public boolean ErrorCheck() {
//        if () {
//            return false;
//
//        }
//    }
}