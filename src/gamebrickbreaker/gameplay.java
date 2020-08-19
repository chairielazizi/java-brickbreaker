package gamebrickbreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.util.Timer;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author chairiel
 */
public class gameplay extends JPanel implements KeyListener, ActionListener {
    private boolean play = false;
    private int score = 0;
    
    private int totalBricks = 21;
    
    private Timer time;
    private int delay=1;

    private int playerX = 310;
    
    private int ballposX = 120;
    private int ballposY = 350;
    private int balldirX = -1;
    private int balldirY = -2;
    
    public gameplay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time = new Timer(delay,this);
        time.start();
    }
    
    public void paint(Graphics g){
        // background
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);
        
        // border
        g.setColor(Color.orange);
        g.fillRect(0,0,3,592);
        g.fillRect(0,0,692,3);
        g.fillRect(684,0,3,592);
        
        // player
        g.setColor(Color.MAGENTA);
        g.fillRect(playerX, 550, 100, 8);
        
        // ball
        g.setColor(Color.GREEN);
        g.fillOval(ballposX, ballposY, 20, 20);
        
        g.dispose();
        
    }
    

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(playerX >= 600){ // check not to go outside of panel
                playerX = 600;
            }
            else{
                moveRight();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(playerX < 10){ // check not to go outside of panel
                playerX = 10;
            }
            else{
                moveLeft();
            }
        }
    }
    
    public void moveRight(){
        play = true;
        playerX+=20;
    }
    public void moveLeft(){
        play = true;
        playerX-=20;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        time.start();
        if(play){
            // to intersect with player
            if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX,550,100,8))){
                balldirY = -balldirY;
            }
            
            ballposX += balldirX;
            ballposY += balldirY;
            //left border
            if(ballposX < 0){
                balldirX = -balldirX;
            }
            // top border
            if(ballposY < 0){
                balldirY = -balldirY;
            }
            // right border
            if(ballposX > 670){
                balldirX = -balldirX;
            }
        }
        repaint(); // redraw the paint method again
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
