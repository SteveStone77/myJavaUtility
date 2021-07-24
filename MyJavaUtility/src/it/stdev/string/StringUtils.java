package it.stdev.string;

public class StringUtils {

	
	
	
	
	/**
	 * verifica che ci sia del conteuto nella stringa
	 * @param value
	 * @return
	 */
	public static boolean isStringOK (String value) {
		if (value == null || value.isEmpty() || value.trim().isEmpty()) 
		    return false;
		else
		    return true;
	}
}
