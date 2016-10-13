package org.erepl.session;

import java.io.CharArrayWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Session {
	private static final int HISTORY_LIMIT = 1000;
	
	private final ScriptEngine engine;
	
	private final CharArrayWriter out;
	private final CharArrayWriter err;
	
	private final Deque<String> history;
	private final Deque<String> future;
	
	public Session() {
		engine = new ScriptEngineManager().getEngineByName("nashorn");
		
		out = new CharArrayWriter(4096);
		engine.getContext().setWriter(out);
		
		err = new CharArrayWriter(4096);
		engine.getContext().setErrorWriter(err);
		
		history = new ArrayDeque<>();
		future = new ArrayDeque<>();
	}
	
	public synchronized Result execute(String command) {
		addToHistory(command);
		
		String output = null, error = null, returnValue = null;
		try {
			out.reset();
			err.reset();
			
			Object result = engine.eval(command);
			if (null != result)
				returnValue = String.valueOf(result);
			
			if (out.size() > 0)
				output = out.toString();
			if (err.size() > 0)
				error = err.toString();
		} catch (Exception e) {
			error = e.getMessage();
		}
		
		return new Result(output, error, returnValue);
	}
	
	public synchronized String back() {
		final String result = history.pop();
		if (null != result)
			future.push(result);
		return result;
	}
	
	public synchronized String forward() {
		final String result = future.pop();
		if (null != result)
			history.push(result);
		return result;
	}
	
	private synchronized void addToHistory(String command) {
		resetHistory();
		while (history.size() > HISTORY_LIMIT) {
			history.poll();
		}
		history.push(command);
	}
	
	private synchronized void resetHistory() {
		history.addAll(future);
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		final Session session = new Session();
		final Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("\n> ");
			System.out.println(session.execute(scanner.nextLine()));
		} while (true);
	}
}
