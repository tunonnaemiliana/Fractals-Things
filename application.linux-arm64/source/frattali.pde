float theta;   
float a=0;
boolean c=true;
color colore=color(0,0,0);
CloseButton g;
Button f;
void setup() {
  fullScreen();
  colorMode(HSB, 360, 100, 100);
  g = new CloseButton(40,40);
  f = new Button(80,40);
}
void draw() {
  background(colore);
  frameRate(30);
  g.display();
  f.display();
  a=a+1.5;
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

void branch(float h) {
  h *= 0.66;
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

void mousePressed() {
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
