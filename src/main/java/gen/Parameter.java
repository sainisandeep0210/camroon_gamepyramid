package gen;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.sql.rowset.serial.SerialArray;

import gen.Subscription;

public class Parameter {

	ConnectionManager connectionManager = Subscription.connectionManager[0];
    
	
	private String combination="";
	private String ani="";
	private String input="";
	private String dnis="";
	private String service, Linput, output, type, queryResponse;
	
	private String status, promptStatus;
	
	public String getQueryResponse() {
		return queryResponse;
	}
	public void setQueryResponse(String queryResponse) {
		this.queryResponse = queryResponse;
	}
	public String getCombination() {
		return combination;
	}
	public void setCombination(String combination) {
		this.combination = combination;
	}
	public String getAni() {
		return ani;
	}
	public void setAni(String ani) {
		this.ani = ani;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getDnis() {
		return dnis;
	}
	public void setDnis(String dnis) {
		this.dnis = dnis;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getLinput() {
		return Linput;
	}
	public void setLinput(String linput) {
		Linput = linput;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPromptStatus() {
		return promptStatus;
	}
	public void setPromptStatus(String promptStatus) {
		this.promptStatus = promptStatus;
	}
	
	

}
