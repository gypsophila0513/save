package controller;


import model.ChessComponent;
import view.ChessGameFrame;
import view.Chessboard;

import javax.swing.*;
import java.net.MalformedURLException;

public class ClickController {
    private final Chessboard chessboard;
    private ChessComponent first;

    public ClickController(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public void onClick(ChessComponent chessComponent) {
        if (first == null) {
            if (handleFirst(chessComponent)) {
                chessComponent.setSelected(true);
                try {
                    ChessGameFrame.playClickMusic();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                first = chessComponent;
                first.repaint();
            }
        } else {
            if (first == chessComponent) { // 再次点击取消选取
                chessComponent.setSelected(false);
                ChessComponent recordFirst = first;
                first = null;
                recordFirst.repaint();
            } else if (handleSecond(chessComponent)) {
                //repaint in swap chess method.
                chessboard.swapChessComponents(first, chessComponent);
                chessboard.swapColor();
                //chessboard.Judge();
                if(!chessboard.judge(chessboard.getCurrentColor())){
                    JOptionPane.showMessageDialog(null, "Checking", "Warning",JOptionPane.WARNING_MESSAGE);
                }
                ChessGameFrame.click();
                try {
                    ChessGameFrame.playClickMusic();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                first.setSelected(false);
                first = null;
            }
        }
    }

    /**
     * @param chessComponent 目标选取的棋子
     * @return 目标选取的棋子是否与棋盘记录的当前行棋方颜色相同
     */

    private boolean handleFirst(ChessComponent chessComponent) {
        return chessComponent.getChessColor() == chessboard.getCurrentColor();
    }

    /**
     * @param chessComponent first棋子目标移动到的棋子second
     * @return first棋子是否能够移动到second棋子位置
     */

    private boolean handleSecond(ChessComponent chessComponent) {
        return chessComponent.getChessColor() != chessboard.getCurrentColor() &&
                first.canMoveTo(chessboard.getChessComponents(), chessComponent.getChessboardPoint());
    }
}
