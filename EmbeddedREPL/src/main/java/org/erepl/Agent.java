package org.erepl;

import java.lang.instrument.Instrumentation;

public class Agent extends Thread{
	
	private static final Agent INSTANCE = new Agent();
	
	public static void premain(String args, Instrumentation inst) {
		main(new String[0]);
	}
	
	public static void main(String[] args) {
		INSTANCE.start();
	}
	
	private Agent() {
		this.setName("EmbeddedREPL Agent");
		this.setDaemon(true);
	}
	
	@Override
	public void run() {
		
	}
}
