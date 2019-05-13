package it.uniroma1.metodologie2019.hw3;
import java.util.ArrayList;
import java.util.List;


public class Synset 
{
	

	private static final int LENGTH_OFFSET = 8 ;
	
	public static final int INIZIO_PAROLE = 14 ;

	private static final int POS_CARATTERE = 12;
	
	
	private String offsetPos = ""  ;
	
	private String pos = "" ;
	
	private String glossa = "" ;
	
	private String offset  = "" ;
	
	private ArrayList<String> esempi = new ArrayList<>() ;
	
	private ArrayList<String> sinonimi  = new ArrayList<>(300) ;
	
	private ArrayList<String> relazioni  = new ArrayList<>(300) ;
	
	
	
	/**
	 * Costruttore esso crea attraverso singole righe del file tutte le informazioni che servono per il Synset
	 * @param rigaFile String
	 */
	public Synset(String rigaFile)
	{
		
			List<String> file = new ArrayList<String>() ;  
			
			
			file.add(rigaFile) ;                 //metto la riga di file in una collezione per poter usare il foreach
					
			
			pos = ""+file.get(0).charAt(POS_CARATTERE) ;          //prelevo pos

			
			for(String s : file)
			{
				offset = s.substring(0, LENGTH_OFFSET) ;     //carico offset
				
				offsetPos = offset + pos ;              //carico offset + pos 
				
				
				/*
				 *carico i sinonimi e le relazioni scorrendomi lo split fatto della sottostringa ed in base a quanti sinonimi ci sone e relazioni
				 *carico i rispettivi insimei
				 */
				String[] temp = s.substring(INIZIO_PAROLE,s.indexOf("|")).split(" ") ;
				
				int max = Integer.parseInt(temp[0],16) ;    //numero elementi sinonimi
				
				int max2 = 0 ; //numero elementi relezioni
				
				int conteggio = 0 ;     //conteggio sinonimi
				
				
				
				
				//i sinonimi si trovano sempre nelle posizioni dispari per come ho impostato la sottostringa e l'array
				//mentre le relazioni vengono prelevate solo una volta finiti i sinonimi 
				
				for(int i = 0 ; i < temp.length ; i++)
				{
					if (max > conteggio && i % 2 == 1)
					{
						sinonimi.add(temp[i]) ;
						conteggio++ ;
						
					}
					
					else if (max == conteggio && temp[i].length() == 3)     //prendo max2 per le relazioni
					
						  max2 = Integer.parseInt(temp[i]) ;
						 
					
					
					if( temp[i].length() == 8)
					
						relazioni.add(temp[i-1]+temp[i]) ;
						
					
				}
				
				
				
						
				//carico la glossa attraverso le sottostringhe e operatore elvis visto che non tutte le righe sono formattate bene cosa simile esempi
				glossa = s.substring(s.indexOf("|") ).contains(";") ? s.substring(s.indexOf("|")+2,s.indexOf(";",s.indexOf("|")) ) : s.substring(s.indexOf("|")+2,s.lastIndexOf(" ")-1)  ;
				
				//possono esiste da 0 a piu esmpi percio me li splitto e se esistono li pulisco e li carico in esempi
				String[] temp3 = s.contains("\"") ? s.substring(s.indexOf("\""),s.lastIndexOf(" ")-1).split(";") : null;
				
				
				if(temp3 != null)
					for(int k = 0 ; k < temp3.length ; k++)
					
						esempi.add( temp3[k].replaceAll(" \"", "").replaceAll("\"", "").replaceAll(";", "") ) ;
				
				
			}
			
	}
	
	
	
	
	
	/**
	 * il metodo restituisce l'insieme di sinonimi del Synset 
	 * @return sinonimi
	 */
	public List<String> getSynonyms()
	{
		
		return sinonimi ;
	}
	
	/**
	 * il metodo presa in input una parola restituisce true se essa si trova nell'insieme dei sinonimi false altrimenti
	 * @param parola String
	 * @return true / false
	 */
	public boolean contains(String parola)
	{
		for(String s : sinonimi)
			if(s.equals(parola)) 
					return true ;
		
		return false ;
		
		
	}
	
	/**
	 * il metodo restituisce l'insieme delle glosse del Synset
	 * @return glossa
	 */
	public String getGloss()
	{
		return glossa ;
	}
	
	/**
	 * il metodo restituisce l'insieme degli esempi dei Synset
	 * @return esempi
	 */
	public ArrayList<String> getExamples()
	{
		return esempi ;
	}
	
	
	
	/**
	 * il metodo basandosi sulla pos(parte del discorso) e restituisce un enum relativo se esiste altrimenti null
	 * @return POS
	 */
	public POS getPOS()
	{
		
		switch(pos)
		{
		case "n" : return POS.NOUN ;
		
		case "v" : return POS.VERB ;
		
		case "a" : return POS.ADJ ;
		
		case "s" : return POS.ADJ ;
		
		case "r" : return POS.ADVERB ;
		
		default : return null ;
		}
	}
	
	/**
	 * il metodo restituisce l'insieme di Offset dei Synset
	 * @return offset
	 */
	public String getOffset()
	{
		
		return offset ;
	}
	
	
	/**
	 * il metodo restituisce l'insieme delle relazioni dei Synset
	 * @return relazioni
	 */
	public List<String> getRelations()
	{
		
		return relazioni ;
	}
	
	
	/**
	 * il metodo ritorna l'offset + la pos sotto froma di una stringa
	 * @return offsetPos
	 */
	public String getID()
	{
		return offsetPos ;
	}

	

}
