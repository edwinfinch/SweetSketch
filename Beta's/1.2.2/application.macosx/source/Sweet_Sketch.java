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

public class Sweet_Sketch extends PApplet {

int lineHeight = 0;
int lineWidth = 750;
int circleMode = 0;
int linepls = 0;
PFont f;
int textplace1 = 35;
int circlesize = 20;

public void setup() {
  size(1500, 700);
  stroke(0);
  background(255);
  f = createFont("Tahoma", 16, true);
  rect(0, 0, 300, 700);
  textFont(f, 16);
  fill(123);
  text("Console (press 'i' to see commands):", 0, 15);
  fill(0);
} 

public void draw() {
  textFont(f, 16);
  fill(0);
  if (mousePressed) {
    lineHeight = mouseY;
    lineWidth = mouseX;
    println("MouseY set to: " +lineHeight +" and mouseX set to: " +lineWidth);
    text("Line point set.", 0, textplace1);
    textplace1 = textplace1 + 15;
    delay(500);
  }
  if (linepls == 1 && circleMode == 0) {
    line(lineWidth, lineHeight, mouseX, mouseY);
  }
  if (linepls == 0 && circleMode == 1) {
    ellipse(mouseX, mouseY, circlesize, circlesize);
  }
}

public void keyPressed() {
  textFont(f, 16);
  fill(0);
  if (key == 'e') {
    linepls = 1;
    println("Variable linepls set to 1");
    text("Line mode enabled", 0, textplace1);
    textplace1 = textplace1 + 15;
  }
  if (key == 'd') {
    linepls = 0;
    println("Variable linepls set to 0");
    text("Line mode disabled", 0, textplace1);
    textplace1 = textplace1 + 15;
  }
  if (key == 'r') {
    circleMode = 1;
    println("Variable circleMode set to 1");
    text("Circlemode enabled", 0, textplace1);
    textplace1 = textplace1 + 15;
  }
  if (key == 'f') {
    circleMode = 0;
    println("Variable circlemode set to 0");
    text("Circlemode disabled", 0, textplace1);
    textplace1 = textplace1 + 15;
  }
  if (key == 'c') {
    fill(255);
    rect(0, 0, 1500, 700);
    circleMode = 0;
    linepls = 0;
    textplace1 = 35;
    rect(0, 0, 300, 700);
    fill(123);
    text("Console (press 'i' to see commands): ", 0, 15);
    fill(0);
    text("Cleared canvas", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Cleared console", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Ready to draw.", 0, textplace1);
    fill(255);
  }
  if (key == 'w') {
    fill(255);
    text("Colour set to white", 0, textplace1);
    textplace1 = textplace1 + 15;
  }
  if (key == 'b') {
    fill(0);
    text("Colour set to black", 0, textplace1);
    textplace1 = textplace1 + 15;
  }
  if (textplace1 > 700) {
    textplace1 = 35;
    fill(255);
    rect(0, 0, 160, 700);
    circleMode = 0;
    linepls = 0;
    fill(0);
    text("Cleared text row", 0, textplace1);
    textplace1 = textplace1 + 15;
  }
  if (key == 'l') {
    f = createFont("Comic Sans MS", 16, true);
  }
  if (key == 'i') {
    text("Press 'e' to enable line mode", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Press 'd' to disable line mode", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Press 'r' to enable circles", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Press 'f' to disable circles", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Press 'b' to change the colour to black", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Press 'w' to change the colour to white", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Press 'c' to clear the canvas", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Press 'n' to change the circle size to small", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Press 'm' to change the circle size to big", 0, textplace1);
    textplace1 = textplace1 + 15;
  }
  if (key == 'n') {
    circlesize = 20;
    text("Circle size set to small", 0, textplace1);
    textplace1 = textplace1 + 15;
  }
  if (key == 'm') {
    circlesize = 50;
    text("Circle size set to big", 0, textplace1);
    textplace1 = textplace1 + 15;
  }
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Sweet_Sketch" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
