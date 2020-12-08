package br.com.alura.alurator;

import java.util.Map;

import br.com.alura.alurator.ioc.Container;
import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflection.ObjectHandler;
import br.com.alura.alurator.reflection.Reflection;
import br.com.alura.alurator.reflection.XMLConverter;

public class Alurator {

	private String basePackage;
	private Container container;

	public Alurator(String basePackage) {
		this.basePackage = basePackage;
		this.container = new Container();
	}

	public Object executa(String url) {
		// TODO - processa a requisicao executando o metodo
		// da classe em questao

		Request request = new Request(url);
		String classController = request.getController();
		String methodName = request.getMethod();
		Map<String, Object> params = request.getQueryParams();

		Class<?> controle = new Reflection().getClass(basePackage+classController);
		Object instance = container.getInstance(controle);
		
		Object objetoRetorno = new ObjectHandler(instance).getMethod(methodName, params).invoke();
		//new Reflection().reflect(basePackage+classController).newInstance()

		objetoRetorno = new XMLConverter().convert(objetoRetorno);
		
		return objetoRetorno;
	}

//	fazendo a verificação de compaibilidade em tempo de desenvolvimento
	public <T, K extends T> void register(Class<T> source, Class<K> recipient) {
		container.register(source, recipient);
	}
}
