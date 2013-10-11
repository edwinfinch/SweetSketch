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

/*
Sweet Sketch 1.4.1 Beta
 Edwin Finch
 
 A program almost up to the standard of Window's Paint.
 
 Draw lines, circles, change the size of circles, read what the console has to say, and more
 I'm sorry that I became obsessed with making this better and it's really big now
 
 Written from the ground up, all 500+ lines. Nothing copied or pasted.
 */

int lineHeight = 0; //set variable lineHeight (like Y) to 0
int lineWidth = 750; //set variable lineWidth (like X) to 750
int circleMode = 0; //set variable circleMode to 0, disabling drawing circles
int linepls = 0; //set linepls variable to 0, disabling line drawing
PFont f; //define variable font 'f'
int textplace1 = 35; //set variable textplace1 to 35, which will later be the place of X in the console
int circleSize = 5; //set variable size of circle to 20
int colour = 0;
int saved = 0;
int lineX = 0;
int lineY = 0;
int lineY1 = 0;
int lineX1 = 0;
int colourhex1 = 0;
int colourhex2 = 0;
int colourhex3 = 0;
float random = random(10000);
int day = day();
int hour = hour();
int minute = minute();
int seconds = second();
int month = month();
int year = year();
int consoleEnable = 1;

public void setup() { //set up, unified across the whole program //DONT NEED CONSOLE ENABLE ON THIS BECAUSE IT IS SET UP
  size(1500, 700); //set window size
  stroke(0); //set the stroke colour to black
  background(255); //set the background colour to white
  f = createFont("Tahoma", 16, true); //set the font already defined 'f' to the font tahoma with a font size of 16 and enable font
  rect(0, 0, 300, 700); //make the rectangle to define the boarder of the console
  fill(0);
  rect(0, 675, 300, 600);
  textFont(f, 16); // set the font of the already defined font to 16
  fill(123); //set the shade to grey
  text("Console (press 'i' to see commands):", 0, 15); //print this line in grey
  fill(0); //set colour back to black
} //end void



public void draw() { //set up draw command
  textFont(f, 16); //define font for this void
  if (mousePressed && linepls == 1) { //if mouse is pressed,
    lineHeight = mouseY; //set the Y to where ever the mouse is
    lineWidth = mouseX; //set the X to where ever the mouse is
    if (consoleEnable == 1) {
      text("Line point set.", 0, textplace1); //print that into the console
      textplace1 = textplace1 + 15; //shift the text place down so we don't have over lapping text
    }
    else if (consoleEnable == 0) {
      println("MouseY set to: " +lineHeight +" and mouseX set to: " +lineWidth);
    }
    delay(250); //wait .5 seconds to prevent spamming on the console
  }
  if (linepls == 1 && circleMode == 0) { //if line is enabled and circle is disabled than...
    line(lineWidth, lineHeight, mouseX, mouseY); //draw a line from wherever the point is set to wherever the mouse is
  }
  if (linepls == 0 && circleMode == 1) { //if circle is enabled and line disabled...
    if (mousePressed) {
      ellipse(mouseX, mouseY, circleSize, circleSize); //draw a circle wherever the mouse is and the size that the user has set
    }
  }
  if (colour == 0) {
    fill(0);
    stroke(0);
    colourhex1 = 0;
    colourhex2 = 0;
    colourhex3 = 0;
    rect(0, 675, 300, 600);
  }

  if (colour == 1) {
    fill(255, 0, 0);
    stroke(255, 0, 0);
    colourhex1 = 255;
    colourhex2 = 0;
    colourhex3 = 0;
    rect(0, 675, 300, 600);
  }
  if (colour == 2) {
    fill(255, 0, 255);
    colourhex1 = 255;
    colourhex2 = 0;
    colourhex3 = 255;
    stroke(255, 0, 255);
    rect(0, 675, 300, 600);
  }
  if (colour == 3) {
    fill(0, 0, 255);
    colourhex1 = 0;
    colourhex2 = 0;
    colourhex3 = 255;
    stroke(0, 0, 255);
    rect(0, 675, 300, 600);
  }
  if (colour == 4) {
    fill(0, 232, 255);
    colourhex1 = 0;
    colourhex2 = 232;
    colourhex3 = 255;
    stroke(0, 232, 255);
    rect(0, 675, 300, 600);
  }
  if (colour == 4) {
    fill(0, 255, 40);
    colourhex1 = 0;
    colourhex2 = 255;
    colourhex3 = 40;
    stroke(0, 255, 40);
    rect(0, 675, 300, 600);
  }
  if (colour == 5) {
    fill(255, 247, 0);
    colourhex1 = 255;
    colourhex2 = 247;
    colourhex3 = 0;
    stroke(255, 247, 0);
    rect(0, 675, 300, 600);
  }
  if (colour == 6) {
    fill(255);
    colourhex1 = 255;
    colourhex2 = 0;
    colourhex3 = 0;
    stroke(255);
    rect(0, 675, 300, 600);
  }

  if (colour > 6) {
    colour = 0;
    if (consoleEnable == 1) {
      text("Colour reset", 0, textplace1);
      textplace1 = textplace1 + 15;
    }
    rect(0, 675, 300, 600);
  }
}//end void

public void keyPressed() { //if key pressed
  textFont(f, 16); //define font
  fill(0); //black shade
  if (key == 'e') { //if that key is equal to e
    if (linepls == 0) {
      linepls = 1; //enable the line
      delay(500);
      if (consoleEnable == 1) {
        text("Line mode enabled", 0, textplace1); //send message to in-program console
        textplace1 = textplace1 + 15; //move textplace down
      }
    }
    else if (linepls == 1) {//if d is pressed
      linepls = 0; //disable line
      delay(500);
      if (consoleEnable == 1) {
        text("Line mode disabled", 0, textplace1); //tell the in-program console
        textplace1 = textplace1 + 15; //move textplace down
      }
      else if (consoleEnable == 0) {
        println("Variable linepls set to 0"); //tell the console
      }
    }
    else if (consoleEnable == 0) {
      println("Variable linepls set to 1"); //send message to console
    }
  }
  if (key == 'r') { //if that key is equal to e
    if (circleMode == 0) {
      circleMode = 1; //enable the line
      delay(500);
      if (consoleEnable == 1) {
        text("Circlemode enabled", 0, textplace1); //send message to in-program console
        textplace1 = textplace1 + 15; //move textplace down
      }
    }
    else if (circleMode == 1) {//if d is pressed
      circleMode = 0; //disable line
      delay(500);
      if (consoleEnable == 1) {
        text("Circlemode disabled", 0, textplace1); //tell the in-program console
        textplace1 = textplace1 + 15; //move textplace down
      }
      else if (consoleEnable == 0) {
        println("Variable circleMode set to 0"); //tell the console
      }
    }
    else if (consoleEnable == 0) {
      println("Variable circleMode set to 1"); //send message to console
    }
  }
  if (key == 'c') { //if key is c
    fill(255); //change the shade to white
    rect(0, 0, 1500, 700); //make a rectangle covering the whole program, effectively clearing the canvas
    circleMode = 0; //disable circle
    linepls = 0; //disable lines
    textplace1 = 35; //set the textplace back to top
    if (consoleEnable == 1) {
      rect(0, 0, 300, 700); //make the console rectangle again
      rect(0, 0, 300, 675); //make the colour console boarder again
      fill(123); //make the shade grey
      text("Console (press 'i' to see commands): ", 0, 15); //make a console title
      fill(0); //make the shade black
      text("Cleared canvas", 0, textplace1); //say that the canvas was cleared
      textplace1 = textplace1 + 15; //move down
      text("Cleared console", 0, textplace1); //say the console was cleared
      textplace1 = textplace1 + 15; //move down
      text("Ready to draw.", 0, textplace1); //say ready to draw
      textplace1 = textplace1 + 15; //move down
    }
    else if (consoleEnable == 0) {
      println("Cleared canvas");
      println("Ready to draw");
    }
    fill(255); //set to white
  }
  if (textplace1 > 675) { //if the textplace has hit the bottom
    if (consoleEnable == 1) {
      textplace1 = 35; //go back to the top
      fill(255); //change colour to white
      rect(0, 0, 300, 675); //clear the canvas
      fill(123);
      text("Console (press 'i' to see commands", 0, 15);
      fill(0); //change shade to black
      text("Cleared text row", 0, textplace1); //tell the user that it was cleared
      textplace1 = textplace1 + 15; //make the text place move down
    }
  }
  if (key == 'l') { //EASTER EGG: if you press c it changes the consoles font to comic sans (the best font in the world)
    f = createFont("Comic Sans MS", 16, true); //hi mr. quosai
    text("COMIC SANS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!", 0, textplace1);
  }
  if (key == 'i' && consoleEnable == 1) { //if it was i
    fill(255); //change the shade to white
    rect(0, 0, 1500, 700); //make a rectangle covering the whole program, effectively clearing the canvas
    circleMode = 0; //disable circle
    linepls = 0; //disable lines
    textplace1 = 35; //set the textplace back to top
    rect(0, 0, 300, 700); //make the console rectangle again
    rect(0, 0, 300, 675); //make the colour console boarder again
    fill(123);
    text("Console (press 'i' to see commands):", 0, 15);
    textplace1 = 35;
    fill(0);
    text("Press 'e' to toggle lines (follows mouse)", 0, textplace1); //FROM HERE ON BELOW IT IS SOLELY ME EXPLAINING WHAT EACH KEY IS ASSIGNED TO, THEN A SHIFT DOWN THE LINE AND SO ON
    textplace1 = textplace1 + 15;
    text("Press 'r' to toggle circles", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Press 'c' to clear the canvas", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Press 'n' to reset the circle size", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Press 'm' to make the circle bigger", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Press 'v' to change the colour", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Press 's' to save your drawing", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Press 'b' to change background to colour", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Rightclick to set point one", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Leftclick to set point two", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Middleclick to place line", 0, textplace1);
    textplace1 = textplace1 + 15;
    text("Click and drag to draw after pressing r", 0, textplace1);
    textplace1 = textplace1 + 15;
  }
  // end instructions
  if (key == 'm') {
    circleSize = circleSize + 5;
    if (consoleEnable == 1) {
      text("Circlesize set to: " +circleSize, 0, textplace1);
      textplace1 = textplace1 + 15;
    }
    else if (consoleEnable == 0) {
      println("Circlesize set to: " +circleSize);
    }
  }
  if (key == 'n') {
    circleSize = 5;
    if (consoleEnable == 1) {
      text("Circlesize reset to 5", 0, textplace1);
      textplace1 = textplace1 + 15;
    }
    else if (consoleEnable == 0) {
      println("Circlesize reset back to 5.");
    }
  }
  if (key == '1') {
    colour = 1;
    if (consoleEnable == 1) {
      text("Changed colour to red.", 0, textplace1);
      textplace1 = textplace1 + 15;
    }
    else if (consoleEnable == 0) {
      println("Colour changed to red");
    }
  }
  if (key == '2') {
    colour = 2;
    if (consoleEnable == 1) {
      text("Changed colour to pink.", 0, textplace1);
      textplace1 = textplace1 + 15;
    }
    else if (consoleEnable == 0) {
      println("Colour changed to pink");
    }
  }
  if (key == '3') {
    colour = 3;
    if (consoleEnable == 1) {
      text("Changed colour to blue.", 0, textplace1);
      textplace1 = textplace1 + 15;
    }
    else if (consoleEnable == 0) {
      println("Colour changed to blue");
    }
  }
  if (key == '4') {
    colour = 4;
    if (consoleEnable == 1) {
      text("Changed colour to green.", 0, textplace1);
      textplace1 = textplace1 + 15;
    }
    else if (consoleEnable == 0) {
      println("Colour changed to green");
    }
  }
  if (key == '5') {
    colour = 5;
    if (consoleEnable == 1) {
      text("Changed colour to yellow.", 0, textplace1);
      textplace1 = textplace1 + 15;
    }
    else if (consoleEnable == 0) {
      println("Colour changed to yellow");
    }
  }
  if (key == '6') {
    colour = 6;
    if (consoleEnable == 1) {
      text("Changed colour to white.", 0, textplace1);
      textplace1 = textplace1 + 15;
    }
    else if (consoleEnable == 0) {
      println("Colour changed to white");
    }
  }
  if (key == '0') {
    colour = 0;
    if (consoleEnable == 1) {
      text("Changed colour to black.", 0, textplace1);
      textplace1 = textplace1 + 15;
    }
    else if (consoleEnable == 0) {
      println("Colour changed to black");
    }
  }

  if (key == 's') {
    day = day();
    hour = hour();
    minute = minute();
    seconds = second();
    save("Screenshots" +"/" +hour + "." + minute + "." + seconds + "-" + day +year +".jpg");
    text("Saved " +hour + "." + minute + "." + seconds + "-" + day +year +".jpg " +"to Screenshots", 0, textplace1);
    textplace1 = textplace1 + 15;
  }
  if (key == 'b') {
    background(colourhex1, colourhex2, colourhex3);
    if (consoleEnable == 1) {
      text("Background changed", 0, textplace1);
    }
    else if (consoleEnable == 0) {
      println("Background changed");
    }
  }
  if (key == 'x') {
    if (consoleEnable == 1) {
      stroke(255);
      fill(255);
      rect(0, 0, 300, 700);
      consoleEnable = 0;
      if (colour == 1) {
        fill(255, 0, 0);
        stroke(255, 0, 0);
        colourhex1 = 255;
        colourhex2 = 0;
        colourhex3 = 0;
        rect(0, 675, 300, 600);
      }
      if (colour == 2) {
        fill(255, 0, 255);
        colourhex1 = 255;
        colourhex2 = 0;
        colourhex3 = 255;
        stroke(255, 0, 255);
        rect(0, 675, 300, 600);
      }
      if (colour == 3) {
        fill(0, 0, 255);
        colourhex1 = 0;
        colourhex2 = 0;
        colourhex3 = 255;
        stroke(0, 0, 255);
        rect(0, 675, 300, 600);
      }
      if (colour == 4) {
        fill(0, 232, 255);
        colourhex1 = 0;
        colourhex2 = 232;
        colourhex3 = 255;
        stroke(0, 232, 255);
        rect(0, 675, 300, 600);
      }
      if (colour == 4) {
        fill(0, 255, 40);
        colourhex1 = 0;
        colourhex2 = 255;
        colourhex3 = 40;
        stroke(0, 255, 40);
        rect(0, 675, 300, 600);
      }
      if (colour == 5) {
        fill(255, 247, 0);
        colourhex1 = 255;
        colourhex2 = 247;
        colourhex3 = 0;
        stroke(255, 247, 0);
        rect(0, 675, 300, 600);
      }
      if (colour == 6) {
        fill(255);
        colourhex1 = 255;
        colourhex2 = 0;
        colourhex3 = 0;
        stroke(255);
        rect(0, 675, 300, 600);
      }
      println("Console disabled, using backup console for text output.");
    }
    else if (consoleEnable == 0) {
      consoleEnable = 1;
      println("Console enabled, disabling backup console.");
      stroke(0);
      fill(0);
      colour = 0;
    }
  }
}//end void

public void loop(){
    text(mouseX + "x " +mouseY + "y", 0, 650);
    fill(123);
    rect(0, 650, 300, 600);
    fill(colourhex1, colourhex2, colourhex3);
}

public void mousePressed() { //consoleEnable has been filled on this
  if (mouseButton == LEFT &&circleMode == 0 &&linepls == 0) {
    lineX = mouseX;
    lineY = mouseY;
    if (consoleEnable == 1) {
      fill(0);
      text("Coordinate 1 (" +lineY + "Y and " +lineX +"X) set.", 0, textplace1);
      textplace1 = textplace1 + 15;
      fill(colourhex1, colourhex2, colourhex3);
    }
    else if (consoleEnable == 0) {
      println("Coordinate " +lineY + "Y and " +lineX +"X set.");
    }
  }
  if (mouseButton == RIGHT &&circleMode == 0 &&linepls == 0) {
    lineY1 = mouseY;
    lineX1 = mouseX;
    if (consoleEnable == 1) {
      fill(0);
      text("Coordinate 2 (" +lineY1 + "Y and " +lineX1 +"X) set.", 0, textplace1);
      textplace1 = textplace1 + 15;
      fill(colourhex1, colourhex2, colourhex3);
    }

    else if (consoleEnable == 0) {
      println("Coordinate " +lineY1 + "Y and " +lineX1 +"X set.");
    }
  }
  if (mouseButton == CENTER &&circleMode == 0 &&linepls == 0) {
    line(lineX, lineY, lineX1, lineY1);
    if (consoleEnable == 1) {
      fill(0);
      text("Placed line ( " +lineY + "y " +lineX + "x - " +lineY1 +"y " +lineX1 +"x)", 0, textplace1);
      textplace1 = textplace1 + 15;
      fill(colourhex1, colourhex2, colourhex3);
    }
    else if (consoleEnable == 0) {
      println("Placed line.");
    }
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
