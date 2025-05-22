package com.patrickriibeiro.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Cartao {

	@WebMethod
	public String validarCartao(String numero) {
		if (numero.length() == 16) {
			return "Cartão valido : " + numero;
		} else {
			return "Cartão inválido";
		}
	}

}
