package it.unibo.gui;

import it.unibo.is.interfaces.IActivityBase;
import it.unibo.is.interfaces.IBasicEnvAwt;
import it.unibo.qactors.akka.QActor;
import it.unibo.system.SituatedPlainObject;

public class RescuerGui extends SituatedPlainObject{
	private IActivityBase cmdHandler;
	private IBasicEnvAwt envAwt;
	
	public RescuerGui(IBasicEnvAwt env, QActor qa) {
		super(env);
		//env is declared of type IBasicUniboEnv in SituatedPlainObject
		//that does not provide any addPanel method. Thus, we memorize it
		envAwt = env;
		init(qa);
	}
	
	protected void init(QActor qa){
		cmdHandler = new CmdHandler(envAwt, qa);
		envAwt.addCmdPanel("commandPanel",
				new String[]{"Start Discovery" }, cmdHandler );
	}

	public void showData(String name, String surname, String bloodGroup) {
		println("Name: " + name + "\nSurname: " + surname + "\nBlood Group: " + bloodGroup);
	}
	
	public void showUnauthorizedMessage() {
		println("Unauthorized");
	}
	
	public void showConnectionEstablished() {
		println("Connection established");
	}
	
	public void showConnectionError() {
		println("Connection error");
	}
	
	public void showMalformedDataMessage() {
		println("Malformed data");
	}
}
