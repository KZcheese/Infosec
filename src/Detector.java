import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Detector implements KeyListener, MouseListener, MouseMotionListener {
	private boolean keyTriggered = false;
	private boolean mouseTriggered = false;
	
//	public Detector(){
//		System.out.println("detect enabled");
//	}

	public boolean getKeyTriggered() {
		boolean temp = keyTriggered;
		keyTriggered = false;
		return temp;
	}

	public boolean getMouseTriggered(){
		boolean temp = mouseTriggered;
		mouseTriggered = false;
		return temp;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		keyTriggered = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyTriggered = true;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		keyTriggered = true;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouse");
		mouseTriggered = true;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mouse");
		mouseTriggered = true;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouse");
		mouseTriggered = true;

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("mouse");
		mouseTriggered = true;		
	}

}
