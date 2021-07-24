package it.stdev.files;

public class NameAndPath {
	
	public final static int STRING_PART_FRONT = 1;
	public final static int STRING_PART_BACK = 2;

	public static void main(String[] args) {
		
		System.out.println("FULL NAME FROM FULL PATH");
		System.out.println("PATH: " + NameAndPath.getFullNameFromFullPath("c:/pippo/peppe/pappo/ziopino.ant"));
		System.out.println("PATH: " + NameAndPath.getFullNameFromFullPath("c:/"));
		System.out.println("PATH: " + NameAndPath.getFullNameFromFullPath(null));
		System.out.println("PATH: " + NameAndPath.getFullNameFromFullPath("    "));
		System.out.println("PATH: " + NameAndPath.getFullNameFromFullPath(""));
		
		System.out.println("\nPATH FROM FULL PATH");
		System.out.println("PATH: " + NameAndPath.getPathFromFullPath("c:/pippo/peppe/pappo/ziopino.ant"));
		System.out.println("PATH: " + NameAndPath.getPathFromFullPath("c:/"));
		System.out.println("PATH: " + NameAndPath.getPathFromFullPath(null));
		System.out.println("PATH: " + NameAndPath.getPathFromFullPath("    "));
		System.out.println("PATH: " + NameAndPath.getPathFromFullPath(""));
		
		System.out.println("\nNAME FROM FULL PATH AND OTHER");
		System.out.println("NAME: " + NameAndPath.getfileName("c:/pippo/peppe/pappo/ziopino.ant"));
		System.out.println("NAME: " + NameAndPath.getfileName("c:/"));
		System.out.println("NAME: " + NameAndPath.getfileName(null));
		System.out.println("NAME: " + NameAndPath.getfileName("    "));
		System.out.println("NAME: " + NameAndPath.getfileName(""));
		System.out.println("NAME: " + NameAndPath.getfileName("macchia.lessa"));
		System.out.println("NAME: " + NameAndPath.getfileName(".lessa"));
		System.out.println("NAME: " + NameAndPath.getfileName("lessa"));
		
		System.out.println("\nNAME FROM FULL PATH AND OTHER");
		System.out.println("NAME: " + NameAndPath.getFileExtension("c:/pippo/peppe/pappo/ziopino.ant"));
		System.out.println("NAME: " + NameAndPath.getFileExtension("c:/"));
		System.out.println("NAME: " + NameAndPath.getFileExtension(null));
		System.out.println("NAME: " + NameAndPath.getFileExtension("    "));
		System.out.println("NAME: " + NameAndPath.getFileExtension(""));
		System.out.println("NAME: " + NameAndPath.getFileExtension("macchia.lessa"));
		System.out.println("NAME: " + NameAndPath.getFileExtension(".lessa"));
		System.out.println("NAME: " + NameAndPath.getFileExtension("lessa"));
		
	}
	
	
	/**
	 * Restituisce l'estensione del file senza punto
	 * @param fullFileName {@link String} percorso completo o nome completo di estensione
	 * @return {@link String}
	 */
	public static String getFileExtension(String fullFileName) {
		String  ext = splitString(fullFileName, '.', STRING_PART_FRONT,1);
		
		return (isStringValid(fullFileName) && ext.length() != fullFileName.length()) ? ext : "";
	}
	
	
	/**
	 * restituisce il nome del file senza estensione
	 * @param fileName {@link String} percorso completo o nome completo di estensione
	 * @return {@link String}
	 */
	public static String getfileName(String fileName) {
		if (isPath(fileName)) fileName = splitString(fileName, '/', STRING_PART_FRONT); 
		return splitString(fileName, '.', STRING_PART_BACK,0);
	}
	
	
	/**
	 * Restituisce il nome del file completo di estensione, qualora ve ne sia una.
	 * @param fullPath {@link String} path completa con il nome del file ed estensione
	 * @return {@link String}
	 */
	public static String getFullNameFromFullPath(String fullPath) {
		
		return splitString(fullPath, '/', STRING_PART_FRONT);
		
	}
	
	
	
	/**
	 * Restituisce la path da una path con il nome file ed estensione, qualora sia presente.
	 * @param fullPath {@link String} percorso completo con anche il nome del file
	 * @return {@link String}
	 */
	public static String getPathFromFullPath(String fullPath) {
		
		return splitString(fullPath, '/', STRING_PART_BACK);
		
	}
	
	
	/**
	 * Esegue lo split di una stringa e ne restituisce la parte scelta.
	 * Lo split viene eseguito in funzione del primo carattere {@code c} 
	 * passato alla funzione che si incontra dalla fine della stringa percorrendola
	 * verso l'inizio.
	 * Il paramentro {@code stringPart} identifica quale parte della stringa restituire.
	 * per mezzo delle costanti STRING_PART_BACK e STRING_PART_FRONT si ottiene
	 * rispettivamente la parte iniziale per il primo e la parte finale per il secondo.
	 * Il parametro di offset determina l'eventuale spostamente dal carattere trovato per
	 * quanto riguarda la restituzione del parte dei stringa selezionata e in questo caso
	 * non deve essere inserito perche di default è impostato ad 1.
	 * Per avere la possibilità di cambiarlo utilizzare la funzione con lo stesso
	 * nome aggiungendo come ultimo paramentro il valore desidertao.
	 * 
	 * @param string {@link String}
	 * @param c {@link Character}
	 * @param stringPart {@code int} STRING_PART_BACK e STRING_PART_FRONT
	 * @return
	 */
	public static String splitString(String string, Character c, int stringPart) {
		return splitString(string, c, stringPart, 1);
	}
	
	
	
	
	/**
	 * Esegue lo split di una stringa e ne restituisce la parte scelta.
	 * Lo split viene eseguito in funzione del primo carattere {@code c} 
	 * passato alla funzione che si incontra dalla fine della stringa percorrendola
	 * verso l'inizio.
	 * Il paramentro {@code stringPart} identifica quale parte della stringa restituire.
	 * per mezzo delle costanti STRING_PART_BACK e STRING_PART_FRONT si ottiene
	 * rispettivamente la parte iniziale per il primo e la parte finale per il secondo.
	 * Il parametro di offset determina l'eventuale spostamente dal carattere trovato per
	 * quanto riguarda la restituzione del parte dei stringa selezionata.
	 * 
	 * @param string
	 * @param c
	 * @param stringPart {@code int} costante STRING_PART_BACK e STRING_PART_FRONT
	 * @return
	 */
	public static String splitString(String string, Character c, int stringPart, int offset) {
		
		if(!isStringValid(string)) return "";
		
		int charPos = string.lastIndexOf(c);
		
		if (charPos == -1) return ""; 
		
		if (stringPart == STRING_PART_BACK){
			return string.substring(0,charPos + offset) ;
			
		}else if (stringPart == STRING_PART_FRONT) {
			return string.substring(charPos + offset) ;
			
		}else {
			return "";
		}
		
		
	}
	
	/**
	 * Verifica che la stringa non sia NULLA, vuota o contenga solo spazi
	 * @param string
	 * @return <code>true</code> la stringa è valida <code>false</code> la stringa non è valida
	 */
	public static boolean isStringValid(String string) {
		if(string == null || string.length()==0 || string.trim().isEmpty()) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * Verifica se la stringa è una path. La funzione cerca il carattere / per identificare
	 * se è una path o meno
	 * @param path
	 * @return
	 */
	public static boolean isPath(String path) {
		if (!isStringValid(path)) return false;
		
		return path.lastIndexOf('/')>-1 ? true : false;
		
	}
}
