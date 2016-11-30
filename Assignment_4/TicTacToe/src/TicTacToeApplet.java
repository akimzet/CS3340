import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
/*
   Applet version of the Earlier commane-line application. Uses the same Board object as
   a member variable of the Applet.
*/
public class TicTacToeApplet extends Applet implements ActionListener 
{
    SquareButton[] buttons = new SquareButton[26];
    Board board;
    boolean gameOver;
    public void init()
    {
        this.setLayout(new GridLayout(5, 5, 1, 1));
        for (int i = 1; i <= 25; i++)
        {
            (buttons[i] = new SquareButton(i)).addActionListener(this);
            this.add(buttons[i]);
        }
        startGame();
    }
    
    public void startGame()
    {
        gameOver = false;
        board = new Board();
        SquareButton.clearLast();
        //Get 1 ~ 4 for Board Setup
        int setup = 1 + (int)(Math.random() * ((4 - 1) + 1));
        //1             Clear Board
        if(setup == 1)
        {
            if (Math.random() < 0.5) board.computerMove();
            drawBoard();
        }
        //2             2 Moves
        if(setup == 2)
        {
            if (Math.random() < 0.5)
            {
                //Computer First
                board.computerMove();
                board.computerMove();
                board.computerMove();
                drawBoard();
            }
            else
            {
                //User First
                board.computerMove();
                board.computerMove();
                drawBoard();
            }
        }
        //3             4 Moves
        if(setup == 3)
        {
            if (Math.random() < 0.5)
            {
                //Computer First
                board.computerMove();
                board.computerMove();
                board.computerMove();
                board.computerMove();
                drawBoard();
            }
            else
            {
                //User First
                board.computerMove();
                board.computerMove();
                board.computerMove();
                drawBoard();
            }
        }
        //4             6 Moves
        if(setup == 4)
        {
            if (Math.random() < 0.5)
            {
                //Computer First
                board.computerMove();
                board.computerMove();
                board.computerMove();
                board.computerMove();
                board.computerMove();
                drawBoard();
            }
            else
            {
                //User First
                board.computerMove();
                board.computerMove();
                board.computerMove();
                board.computerMove();
                drawBoard();
            }
        }
    }
    public void endGame(boolean computerWin, boolean humanWin)
    {
        gameOver = true;
        String message = (computerWin ? "I Win." : (humanWin ? "You Win." : "Tie Game.")) +
        " Play again?";
        if (JOptionPane.showOptionDialog(null, message, "",
                JOptionPane.YES_NO_OPTION, 0, null, null, null) == JOptionPane.YES_OPTION)
            startGame();
    }
    
    public void drawBoard()
    {
        for (int i = 1; i < 26; i++)
            buttons[i].setLabel(Character.toString(board.squares[i]));
    }
    
    public void actionPerformed(ActionEvent e)
    {
        int squareNum = ( (SquareButton) e.getSource()).id;
        if (!board.isFreeSquare(squareNum) || gameOver) return; // can't move here
        if (move(squareNum,true)) return ; // human move
        try {Thread.sleep(500);} catch (InterruptedException e1) {} // a slight pause
        move(board.bestMove(0).square,false);  // computer move
    }

// Make the move.
// If the game is determined to be over then call endGame() and return true.
// Otherwise return false.
    boolean move(int squareNum, boolean humanMove)
    {
        board.moveToSquare(squareNum); // human move
        this.drawBoard();
        if (board.boardValue() == 4 || board.boardValue() == -4) /* someone won */ 
        {
            endGame(!humanMove, humanMove);
            return true;  // game over
        }
        if (board.boardFull())  /* tie game */ 
        {
            endGame(false, false);
            return true;  // game over
        }
        return false;  // game continues
    }


}
// Provides a colored button to represent one of the the nine squares.
class SquareButton extends Button implements ActionListener {
    private static SquareButton lastClicked = null;
    private static final Color defaultColor = new Color(80,180,255), clickedColor = new Color(80,230,220);
    int id;
    public SquareButton(int id) {
      super();
      this.id = id;
      this.setFont(new Font("Courier",Font.BOLD,54));
      this.setBackground(defaultColor);
      this.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
      String s = e.getActionCommand();
       if (s.equals("X") || s.equals("O")) return;
       clearLast();
       setLast(this);
    }
    public static void clearLast() {
      if (lastClicked != null) {
        lastClicked.setBackground(defaultColor);
        lastClicked = null;
      }
    }
    public static void setLast(SquareButton b) {
      b.setBackground(clickedColor);
      lastClicked = b;
    }
  }