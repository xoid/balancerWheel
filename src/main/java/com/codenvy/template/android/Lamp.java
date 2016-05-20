package com.codenvy.template.android;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Lamp  extends Thread
{
  private Canvas canvas  = new Canvas();
  private Paint  black   = new Paint();
  private Paint  white   = new Paint();
  String name;
  int x,y; 
  boolean state = false;
  int power = 50;
  
  public void setPower(int power)
  {	
    	this.power = power;
  }
  
   @Override
   public void run() 
   {
        super.run();
     		while (true)    // forever loop, on and wait, off and wait
         {
     			canvas.drawRect(x, y, 100, 100, white);
     				try {                Thread.sleep(power);                } catch (InterruptedException e) {         e.printStackTrace();        }	
     			canvas.drawRect(x, y, 100, 100, black);
     				try {                Thread.sleep(100-power);            } catch (InterruptedException e) {         e.printStackTrace();        }	
         }
   }
  
  public Lamp(String name, int x, int y)     // CONSTRUCTOR
  {
    	this.name 	= name;
    	this.x		= x;    	this.y		= y;
    	white.setColor(Color.WHITE);    	black.setColor(Color.BLACK);
    	this.run();
  }
  
  public void Draw()
  {
		if (state) 
    			canvas.drawRect(x, y, 100, 100, white);
    	else
        		canvas.drawRect(x, y, 100, 100, black);
  }
  
  public void On()
  {
    	state = true;
 		Draw();
  }
  
  public void Off()
  {
    	state = false;
      Draw();
  }
  
  public void Change()
  {
    	if (state) state = false; else state = true;
    	Draw();
  }

}
