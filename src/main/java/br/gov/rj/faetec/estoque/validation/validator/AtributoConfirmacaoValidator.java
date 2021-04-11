package br.gov.rj.faetec.estoque.validation.validator;

//import java.io.IOException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import org.apache.commons.beanutils.BeanUtils;

//import com.jcraft.jsch.JSchException;

//import br.com.epdvr.sismobiliario.connection.ConnectionSSH;
import br.gov.rj.faetec.estoque.validation.AtributoSku;

public class AtributoConfirmacaoValidator  implements ConstraintValidator<AtributoSku, Object> {

	private String atributo;
	
	@Override
	public void initialize(AtributoSku constraintAnnotation) {
		this.atributo = constraintAnnotation.atributo();
	}

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		boolean valido = false;
		try {
			Object valorAtributo = BeanUtils.getProperty(object, this.atributo);
			
			valido = validaSku(valorAtributo);
		} catch (Exception e) {
			throw new RuntimeException("Erro recuperando valores dos atributos", e);
		}
		
		if (!valido) {
			context.disableDefaultConstraintViolation();
			String mensagem = context.getDefaultConstraintMessageTemplate();
			ConstraintViolationBuilder violationBuilder = context.buildConstraintViolationWithTemplate(mensagem);
			violationBuilder.addPropertyNode(atributo).addConstraintViolation();
		}
		
		return valido;
	}
	
	//private boolean validaSku(Object valorAtributo) throws IOException, JSchException {
	private boolean validaSku(Object valorAtributo) {
		
		//String retornoOpenbase="";

		//String linhaComando = "sismob/bin/pmob0233 "+valorAtributo; //Digitar 062378007

		//String retorno = new ConnectionSSH().executarComando(linhaComando);
		
		//String[] tuplas = retorno.split("\r\n");
		//for (String tupla: tuplas) {			
		//	String[] campos = tupla.split("\\|");
		//	for (String campo : campos) {					
		//	    //System.out.println(campo);
		//	    retornoOpenbase=campo;
		//	    break;
		//	}
		//}
		// Retorno = "00" indicará sucesso
		//return retornoOpenbase.equals("00");
		
		return valorAtributo.equals("AA1111"); 
	}
	

}
