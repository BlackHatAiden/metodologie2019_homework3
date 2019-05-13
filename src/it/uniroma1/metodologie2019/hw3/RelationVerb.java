package it.uniroma1.metodologie2019.hw3;

public enum RelationVerb implements WordNetRelation
{ 
	IPERNOMIO, 
	ANTONIMO,
	IPONIMO, 
	IMPLICAZIONE,
	CAUSA, 
	VEDI_ANCHE, 
	VERBO_GRUPPO, 
	RELATIVE_DERIVATIONALLY_FORMA, 
	DOMINIO_SYNSET_ARGOMENTO, 
	DOMINIO_SYNSET_REGIONE, 
	DOMINIO_SYNSET_UTILIZZO ;
	
	/**
	 * il metodo restituisce la rappresentazione stringa delle costanti
	 * @param r RelationVerb
	 * @return RelationVerb
	 */
	public static String toString(RelationVerb r)
	{
		switch(r)
		{
		
		case ANTONIMO : return "!" ;
		
		case IPERNOMIO : return "@" ;
		
		case IPONIMO : return "~" ;
		
		case IMPLICAZIONE  : return "*" ;
		
		case CAUSA : return ">" ;
		
		case VEDI_ANCHE : return "^" ;
		
		case VERBO_GRUPPO : return "$" ;
		
		case RELATIVE_DERIVATIONALLY_FORMA : return "+" ;
		
		case DOMINIO_SYNSET_ARGOMENTO : return "c" ;
		
		case DOMINIO_SYNSET_REGIONE : return "r" ;
		
		case DOMINIO_SYNSET_UTILIZZO : return "u" ;
		
		default : return null ;
		}
	}
}
