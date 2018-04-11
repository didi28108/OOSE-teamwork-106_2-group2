package view;

import java.awt.Canvas;

import controller.MainMediator;

public class DrawCanvas extends Canvas{
	MainMediator guiMdtr;
	public DrawCanvas(MainMediator mdtr){
		this.guiMdtr = mdtr;
		mdtr.registerDrawCanvas(this);
	}
}
