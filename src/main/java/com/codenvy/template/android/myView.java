package com.codenvy.template.android;
// import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class myView extends View
{
   Canvas canvas ;
  	Lamp [] lamps = new Lamp[7];
  	
   public myView(Context context) 
   {
   	 	super(context);
    		init(context);
	}

	private void init(Context context) 
	{
     	this.canvas = new Canvas();
   	lamps[1] = new Lamp(canvas, "LDir", 100, 100);
     	lamps[2] = new Lamp(canvas, "RDir", 100, 400);
      lamps[3] = new Lamp(canvas, "LPWM", 400, 100);
     	lamps[3] = new Lamp(canvas, "RPWM", 400, 400);
	}

  	public void Cmd(String name, int power)
   {
     		for (int i = 1; i<5; i++) if (lamps[i].name == name) lamps[i].setPower(power);
   }
  
  
    @Override
    protected void onDraw(Canvas canvas) 
    { //вызывается каждый раз, как нужно перерисовать view
      	this.canvas = canvas;
			for (int i = 1; i<5; i++) lamps[i].Draw();
    }
}
