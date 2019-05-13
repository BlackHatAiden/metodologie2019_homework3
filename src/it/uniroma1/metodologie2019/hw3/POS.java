package it.uniroma1.metodologie2019.hw3;

public enum POS 
{
	VERB,
	NOUN,
	ADJ,
	ADVERB ;
	
	/**
	 * il metodo restituisce la rappresentazione stringa delle costanti
	 * @param p POS
	 * @return POS
	 */
	public static String toString(POS p)
	{
		switch(p)
		{
		case VERB : return "verb" ;
		
		case NOUN : return "noun" ;
		
		case ADJ : return "adj" ;
		
		case ADVERB : return "adv" ;
		
		default : return null ;
		}
	}
}
