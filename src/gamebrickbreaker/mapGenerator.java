package gamebrickbreaker;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author chairiel
 */
public class mapGenerator {
    public int map[][];
    public int brickWidth;
    public int brickHeight;
    
    public mapGenerator(int row,int column){
        map = new int[row][column];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                map[i][j] = 1; // indicate the brick is not intersected by the ball
            }
        }
        
        brickWidth = 540/column;
        brickHeight = 150/row;
    }
    
    public void draw(Graphics2D g){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j] > 0){
                    g.setColor(Color.CYAN);
                    g.fillRect(i * brickWidth, i * brickHeight +50, brickWidth, brickHeight);
                }
            }
        }
    }
}
