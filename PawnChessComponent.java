package model;

import controller.ClickController;
import view.ChessboardPoint;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PawnChessComponent extends ChessComponent{
    private static Image PAWN_WHITE;
    private static Image PAWN_BLACK;
    private Image pawnImage;
    public void loadResource() throws IOException {
        if (PAWN_WHITE == null) {
            PAWN_WHITE = ImageIO.read(new File("src./images/pawn-white.png"));
        }

        if (PAWN_BLACK == null) {
            PAWN_BLACK = ImageIO.read(new File("src./images/pawn-black.png"));
        }
    }
    private void initiatePawnImage(ChessColor color) {
        try {
            loadResource();
            if (color == ChessColor.WHITE) {
                pawnImage = PAWN_WHITE;
            } else if (color == ChessColor.BLACK) {
                pawnImage = PAWN_BLACK;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public PawnChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor color, ClickController listener, int size) {
        super(chessboardPoint, location, color, listener, size);
        initiatePawnImage(color);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(pawnImage, 0, 0, getWidth() , getHeight(), this);
        g.setColor(Color.BLACK);
        if (isSelected()) {
            g.setColor(Color.PINK);
            g.drawOval(0, 0, getWidth() , getHeight());
        }
    }
    @Override
    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination){
        ChessboardPoint source=getChessboardPoint();
        ChessColor color=getChessColor();
        if(color==ChessColor.BLACK&&source.getX()==1&&destination.getY()==source.getY()&&destination.getX()-source.getX()==2){
            if(!(chessComponents[source.getX()+1][source.getY()]instanceof EmptySlotComponent)&&!(chessComponents[destination.getX()+2][destination.getY()]instanceof EmptySlotComponent)){
                return false;
            }
        }
        else if(color==ChessColor.WHITE&&source.getX()==6&&destination.getY()==source.getY()&&destination.getX()-source.getX()==-2){
            if(!(chessComponents[source.getX()-1][source.getY()]instanceof EmptySlotComponent)&&!(chessComponents[destination.getX()-2][destination.getY()]instanceof EmptySlotComponent)){
                return false;
            }
        }
        else if(source.getY()==destination.getY()&&source.getX()-destination.getX()==1&&color==ChessColor.WHITE){
            if(!(chessComponents[destination.getX()][destination.getY()]instanceof EmptySlotComponent)){return false;}
        }
        else if(source.getY()==destination.getY()&&source.getX()-destination.getX()==-1&&color==ChessColor.BLACK){
            if(!(chessComponents[destination.getX()][destination.getY()]instanceof EmptySlotComponent)){return false;}
        }
        else if(Math.abs(source.getY()-destination.getY())==1&&source.getX()-destination.getX()==-1&&color==ChessColor.BLACK){
            if(chessComponents[destination.getX()][destination.getY()].getChessColor()!=ChessColor.WHITE){return false;}
        }
        else if(Math.abs(source.getY()-destination.getY())==1&&source.getX()-destination.getX()==1&&color==ChessColor.WHITE){
            if(chessComponents[destination.getX()][destination.getY()].getChessColor()!=ChessColor.BLACK){return false;}
        }
        else {
            return false;
        }
        return true;
    }
}
