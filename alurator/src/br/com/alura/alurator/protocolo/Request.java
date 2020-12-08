package br.com.alura.alurator.protocolo;

import java.util.HashMap;
import java.util.Map;

public class Request {
	
	private String controller;
	private String methodName;
	private Map<String, Object> queryParams; 
	
	public Request(String url) {
		String[] paths = url.replaceFirst("/", "").split("[?]");
		// pra jvm entender ? como caracter é preciso []
		
		String[] ctrlMetodo = paths[0].split("/");
		controller = Character.toUpperCase(ctrlMetodo[0].charAt(0)) + ctrlMetodo[0].substring(1) 
				+ "Controller";
		// passando a 1° letra da 1° parte da url dividida pra maiúculo 
		// e concatenando com Controller -> mvc
		
		methodName = ctrlMetodo[1];	
		
		queryParams = paths.length > 1 
				? new QueryParamsBuilder().withParams(paths[1]).build()
				: new HashMap<String, Object>();
	}
	
	public String getController() {
		return controller;
	}
	
	public String getMethod() {
		return methodName;
	}
	
	public Map<String, Object> getQueryParams() {
		return queryParams;
	}
}
