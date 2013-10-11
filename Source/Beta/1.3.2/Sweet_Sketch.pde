/*
Sweet Sketch 1.3.2 Beta
 Edwin Finch
 
 A program almost up to the standard of Window's Paint.
 
 Draw lines, circles, change the size of circles, read what the console has to say, and more
 */

int lineHeight = 0; //set variable lineHeight (like Y) to 0
int lineWidth = 750; //set variable lineWidth (like X) to 750
int circleMode = 0; //set variable circleMode to 0, disabling drawing circles
int linepls = 0; //set linepls variable to 0, disabling line drawing
PFont f; //define variable font 'f'
int textplace1 = 35; //set variable textplace1 to 35, which will later be the place of X in the console
int circlesize = 20; //set variable size of circle to 20
int colour = 0;

void setup() { //set up, unified across the whole program
  size(1500, 700); //set window size
  stroke(0); //set the stroke colour to black
  background(255); //set the background colour to white
  f = createFont("Tahoma", 16, true); //set the font already defined 'f' to the font tahoma with a font size of 16 and enable font
  rect(0, 0, 300, 700); //make the rectangle to define the boarder of the console
  fill(0);
  rect(0, 674, 300, 600);
  textFont(f, 16); // set the font of the already defined font to 16
  fill(123); //set the shade to grey
  text("Console (press 'i' to see commands):", 0, 15); //print this line in grey
  fill(0); //set colour back to black
} //end void

void draw() { //set up draw command
  textFont(f, 16); //define font for this void
  if (mousePressed && circleMode == 0) { //if mouse is pressed,
    lineHeight = mouseY; //set the Y to where ever the mouse is
    lineWidth = mouseX; //set the X to where ever the mouse is
    println("MouseY set to: " +lineHeight +" and mouseX set to: " +lineWidth); //say in the console of the actual IDE that it has set, should take out this feature though
    text("Line point set.", 0, textplace1); //print that into the console
    textplace1 = textplace1 + 15; //shift the text place down so we don't have over lapping text
    delay(500); //wait .5 seconds to prevent spamming on the console
  }
  if (linepls == 1 && circleMode == 0) { //if line is enabled and circle is disabled than...
    line(lineWidth, lineHeight, mouseX, mouseY); //draw a line from wherever the point is set to wherever the mouse is
  }
  if (linepls == 0 && circleMode == 1) { //if circle is enabled and line disabled...
    if (mousePressed) {
      ellipse(mouseX, mouseY, circlesize, circlesize); //draw a circle wherever the mouse is and the size that the user has set
    }
  }
  if (colour == 1) {
    fill(255, 0, 0);
    stroke(255, 0, 0);
    rect(0, 675, 300, 600);
  }
  if (colour == 2) {
    fill(255, 0, 255);
    stroke(255, 0, 255);
    rect(0, 675, 300, 600);
  }
  if (colour == 3) {
    fill(0, 0, 255);
    stroke(0, 0, 255);
    rect(0, 675, 300, 600);
  }
  if (colour == 4) {
    fill(0, 232, 255);
    stroke(0, 232, 255);
    rect(0, 675, 300, 600);
  }
  if (colour == 4) {
    fill(0, 255, 40);
    stroke(0, 255, 40);
    rect(0, 675, 300, 600);
  }
  if (colour == 5) {
    fill(255, 247, 0);
    stroke(255, 247, 0);
    rect(0, 675, 300, 600);
  }
  if (colour > 5) {
    colour = 0;
    text("Colour reset", 0, textplace1);
    textplace1 = textplace1 + 15;
    rect(0, 675, 300, 600);
  }
}//end void

void keyPressed() { //if key pressed
  textFont(f, 16); //define font
  fill(0); //black shade
  if (key == 'e') { //if that key is equal to e
    linepls = 1; //enable the line
    println("Variable linepls set to 1"); //send message to console
    text("Line mode enabled", 0, textplace1); //send message to in-program console
    textplace1 = textplace1 + 15; //move textplace down
  }
  if (key == 'd') {//if d is pressed
    linepls = 0; //disable line
    println("Variable linepls set to 0"); //tell the console
    text("Line mode disabled", 0, textplace1); //tell the in-program console
    textplace1 = textplace1 + 15; //move textplace down
  }
  if (key == 'r') { //if it is r
    circleMode = 1; //enable circle mode (draw circles)
    println("Variable circleMode set to 1"); //tell the console
    text("Circlemode enabled", 0, textplace1); //tell the in-program console
    textplace1 = textplace1 + 15; //move textplace down
  }
  if (key == 'f') { //if it is f
    circleMode = 0; //disable circles
    println("Variable circlemode set to 0"); //tell console
    text("Circlemode disabled", 0, textplace1); //tell inprogram console
    textplace1 = textplace1 + 15; //move textplace down
  }
  if (key == 'c') { //if key is c
    fill(255); //change the shade to white
    rect(0, 0, 1500, 700); //make a rectangle covering the whole program, effectively clearing the canvas
    circleMode = 0; //disable circle
    linepls = 0; //disable lines
    textplace1 = 35; //set the textplace back to top
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
    fill(255); //set to white
  }
  if (key == 'w') { //if the key was w
    text("Colour set to white", 0, textplace1); //tell the user through console
    stroke(255);
    fill(255); //change to white
    textplace1 = textplace1 + 15; //move down
  }
  if (key == 'b') { //if it was b
    fill(0); //set shade to black
    text("Colour set to black", 0, textplace1); //tell the user
    textplace1 = textplace1 + 15; //move down
  }
  if (textplace1 > 675) { //if the textplace has hit the bottom
    textplace1 = 35; //go back to the top
    fill(255); //change colour to white
    rect(0, 0, 300, 675); //clear the canvas
    fill(123);
    text("Console (press 'i' to see commands", 0, 15);
    fill(0); //change shade to black
    text("Cleared text row", 0, textplace1); //tell the user that it was cleared
    textplace1 = textplace1 + 15; //make the text place move down
  }
  if (key == 'l') { //EASTER EGG: if you press c it changes the consoles font to comic sans (the best font in the world)
    f = createFont("Comic Sans MS", 16, true); //hi mr. quosai
  }
  if (key == 'i') { //if it was i
    text("Press 'e' to enable line mode", 0, textplace1); //FROM HERE ON BELOW IT IS SOLELY ME EXPLAINING WHAT EACH KEY IS ASSIGNED TO, THEN A SHIFT DOWN THE LINE AND SO ON
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
    text("Press 'v' to change the colour", 0, textplace1);
    textplace1 = textplace1 + 15;
  } // end instructions
  if (key == 'n') { //if the key was n
    circlesize = 20; //set the circle size to small (20)
    text("Circle size set to small", 0, textplace1); //tell the user through the console
    textplace1 = textplace1 + 15; //move the text place down
  }
  if (key == 'm') { //if the key was m
    circlesize = 50; //change the circlesize to large
    text("Circle size set to big", 0, textplace1); //tell the user through the console inprogram
    textplace1 = textplace1 + 15; //move text line down
  }
  if (key == 'v') {
    colour++;
    text("Colour changed to: " +colour, 0, textplace1);
    textplace1 = textplace1 + 15;
  }
}//end void

