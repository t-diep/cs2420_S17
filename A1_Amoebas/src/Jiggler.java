/**
 * Tony Diep
 * u0934661
 * 1/19/17
 * CS 2420
 * Assignment 1
 * The following text:
 * I pledge that the work done here was my own and that I have learned how to write this program, such that I could throw it out and restart and finish it in a timely manner. I am not 
 * turning in any work that I cannot understand, describe, or recreate. 
 *
 * -Tony Diep
 */
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * Represents a jiggler system where the circles drawn will jiggle
 * 
 * @author Tony Diep, last updated 1-19-17
 */
public class Jiggler extends Thread
{
	//Represents the collection of drawables currently drawn onto the JFrame
	private ArrayList<JComponent> drawables;
	//Represents a label that consistently updates the frames per second (fps)
	private JLabel fps;
	//Represents a flag that checks if the circles are spread out
	private boolean spreadOut = true;

	/**
	 * Constructor
	 * 
	 * @param fps -- a JLabel displaying frames per second
	 * @param drawables -- an ArrayList containing JComponents
	 */
	public Jiggler(ArrayList<JComponent> drawables, JLabel fps)
	{
		this.fps = fps;
		this.drawables = drawables;
	}

	/**
	 * Begins frame count and jiggling
	 */
	@Override
	public void run()
	{		
		while (true)
		{	
			jiggle();
			long start = 0;
			long end = 0;
			long elapsed = 0;
			int frameCount = 0;

			start = System.nanoTime();

			for(int i = 0; i < drawables.size() - 1; i++)
			{
				Circle myAmoeba = (Circle) drawables.get(i);
				Rectangle r1 = drawables.get(i).getBounds();

//				r1 = myAmoeba.getBounds();

				for(int j = i + 1; j < drawables.size() - 1; j++)
				{
					Rectangle r2 = drawables.get(j).getBounds();

					if(r1.intersects(r2) && spreadOut)
					{
						boolean addOne = new Random().nextBoolean();

						if(addOne)
						{
							myAmoeba.setLocation(myAmoeba.getLocation().x + 1,myAmoeba.getLocation().y + 1);
						}
						else
						{
							myAmoeba.setLocation(myAmoeba.getLocation().x - 1,myAmoeba.getLocation().y - 1);
						}
					}
					frameCount++;

					end = System.nanoTime();
					elapsed += end - start;

					if(elapsed > 1_000_000_000 && elapsed % 100_000 == 0)
					{
						fps.setText("Frames per second: " + frameCount);
						System.out.println("Frames per second: " + frameCount + "\tTime: " + elapsed/100000000);
						System.out.println(frameCount);
						frameCount = 0;
						elapsed = 0;
					}
				}
			}
		}
	}

	/**
	 * Constructs the jiggling aspect for this thread
	 */
	private void jiggle()
	{
		int currX;
		int currY;
		int xDist = (int) (Math.random() * 1.001);
		int yDist = (int) (Math.random() * 1.001);

		for(JComponent component : drawables)
		{	
			currX = component.getX();
			currY = component.getY();

			if(new Random().nextBoolean())
			{
				component.setLocation(currX, currY + yDist);

				if(new Random().nextBoolean())
				{
					component.setLocation(currX + xDist, currY + yDist);
				}
				else
				{
					component.setLocation(currX - xDist, currY + yDist);
				}
			}
			else
			{
				component.setLocation(currX, currY - yDist);

				if(new Random().nextBoolean())
				{
					component.setLocation(currX + xDist, currY - yDist);
				}
				else
				{
					component.setLocation(currX - xDist, currY - yDist);
				}
			}
		}
	}
}

