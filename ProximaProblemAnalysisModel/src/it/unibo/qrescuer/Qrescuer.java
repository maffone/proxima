/* Generated by AN DISI Unibo */ 
/*
This code is generated only ONCE
*/
package it.unibo.qrescuer;
import java.awt.Color;

import it.unibo.baseEnv.basicFrame.EnvFrame;
import it.unibo.gui.RescuerGui;
import it.unibo.is.interfaces.IBasicEnvAwt;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.QActorContext;

public class Qrescuer extends AbstractQrescuer { 
	private RescuerGui gui;
	
	public Qrescuer(String actorId, QActorContext myCtx, IOutputEnvView outEnvView )  throws Exception{
		super(actorId, myCtx, outEnvView);
	}
	
	/* Added by the application designer */
	public void buildCustomGui(String logo){
		IBasicEnvAwt env = outEnvView.getEnv();
		if( env == null){
			env = new EnvFrame( logo, Color.yellow, Color.black );
			env.init();
			((EnvFrame)env).setSize(800,430);
		}
		env.writeOnStatusBar(logo + " | working ... ",14);
		this.gui = new RescuerGui( env , this);
	}
	
	public void showDataOnGUI(String name, String surname, String bloodGroup) {
		this.gui.showData(name, surname, bloodGroup);
	}
	
	public void showUnauthorizedMessageOnGUI() {
		this.gui.showUnauthorizedMessage();
	}
	
	public void showConnectionEstablished() {
		this.gui.showConnectionEstablished();
	}
	
	public void showConnectionError() {
		this.gui.showConnectionError();
	}
	
	public void showMalformedDataMessage() {
		this.gui.showMalformedDataMessage();
	}
	
	public String decryptData(String data) {
		return decipher(data, 2);
	}
	
	// Caesar cipher
	private String decipher(String msg, int shift) {
	    String s = "";
	    for (int x = 0; x < msg.length(); x++) {
	    	s += (char)(msg.charAt(x) - shift);
	    }
	    return s;
	}
}
