package client.handler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import client.ClientUI;

public class MoveHandler implements KeyListener {
	ClientUI ui;
	public MoveHandler(ClientUI clientUI) {
		ui =clientUI;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 40:
			ui.net.sendMoveRequest("down");
			break;
		case 38:
			ui.net.sendMoveRequest("up");
			break;
		case 37:
			ui.net.sendMoveRequest("left");
			break;
		case 39:
			ui.net.sendMoveRequest("right");
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
