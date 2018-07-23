import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class frattali extends PApplet {

float theta;   
float a=0;
boolean c=true;
int colore=color(0,0,0);
CloseButton g;
Button f;
public void setup() {
  
  colorMode(HSB, 360, 100, 100);
  g = new CloseButton(40,40);
  f = new Button(80,40);
}
public void draw() {
  background(colore);
  frameRate(30);
  g.display();
  f.display();
  a=a+1.5f;
  if(a > 359) {
          a = 0;
  }
  stroke(a,97,100);
  float a = (mouseX / (float) width) * 90f;
  theta = radians(a);
  translate(width/2,height);
  line(0,0,0,-120);
  translate(0,-120);
  branch(120);

}

public void branch(float h) {
  h *= 0.66f;
  if (h > 1) {
    /* 
       ♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥
       ♥puoi variare 1 con un valore compreso tra 1 e 120♥
       ♥valori di riferimento:                           ♥
       ♥  120 = 1 ramo                                   ♥
       ♥  79 = 2 rami                                    ♥
       ♥  52 = 3 rami                                    ♥
       ♥  34 = 4 rami                                    ♥
       ♥  22 = 5 rami                                    ♥
       ♥  14 = 6 rami                                    ♥
       ♥  9 = 7 rami                                     ♥
       ♥  5 = 8 rami                                     ♥
       ♥  3 = 9 rami                                     ♥
       ♥  2 = 10 rami                                    ♥
       ♥  1 = 11 rami                                    ♥
       ♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥
    */
    pushMatrix();    
    rotate(theta);   
    line(0, 0, 0, -h);  
    translate(0, -h); 
    branch(h);       
    popMatrix();     
    pushMatrix();
    rotate(-theta);
    line(0, 0, 0, -h);
    translate(0, -h);
    branch(h);
    popMatrix();
  }
}

public void mousePressed() {
  if (g.isClicked(mouseX, mouseY))
     exit();
  if (f.isClicked(mouseX, mouseY)){
    if(c){
      colore=color(0,0,100);
      c=false;
    }
    else {
      colore=color(0,0,0);
      c=true;
    }
  }
      
}

// a button with side equal to 30 pixels

class Button 
{
  int minX, minY, side;
  
  Button(int x1, int y1)
 {
    minX = x1; minY = y1; side = 30; 
 } 
  
  public boolean isClicked( int x, int y)
  {
   if (( x >= minX) && (x <= (minX+side)) && ( y >= minY) && (y <= (minY+side)))
     return true;
   else
     return false;
  }
 
  public void display()
   {
     rectMode(CORNER); 
     rect( minX, minY, side, side);
   } 
  
}

class CloseButton extends Button
{
  
  CloseButton(int x1, int y1)
  {
      super(x1, y1);
   }
   
   public void display()
   {
      super.display();
      strokeWeight(2);
      ellipse(minX+15,minY+15,20,20);
      strokeWeight(1);
   }
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "frattali" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
