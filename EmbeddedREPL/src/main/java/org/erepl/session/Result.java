package org.erepl.session;

public class Result {
	
	private final String output, error, returnValue;
	
	Result(String output, String error, String returnValue) {
		this.output = output;
		this.error = error;
		this.returnValue = returnValue;
	}

	public String getOutput() {
		return output;
	}

	public String getError() {
		return error;
	}

	public String getReturnValue() {
		return returnValue;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Result:\n")
			   .append("\tOutput:\t").append(output).append("\n")
			   .append("\tError:\t").append(error).append("\n")
			   .append("\tReturn:\t").append(returnValue).append("\n");
		
		return builder.toString();
	}
}
