package it.uniroma1.metodologie2019.hw3;

public enum RelationNoun implements WordNetRelation
{
	IPERNOMIO ,
	IPONIMO  ,
	ANTONIMO ,
	ISTANZA_IPONIMO ,
	MEMBRO_OLONIMIA ,
	SOSTANZA_OLONIMIA ,
	MEMBRO_MERONIMO ,
	PARTE_MERONIMO ,
	ATTRIBUTO ,
	RELATIVE_DERIVATIONALLY_FORMA ,
	DOMINIO_SYNSET_ARGOMENTO, 
	MEMBRO_DOMINIO_ARGOMENTO, 
	DOMINIO_SYNSET_REGIONE, 
	MEMBRO_DOMINIO_REGIONE, 
	DOMINIO_SYNSET_UTILIZZO, 
	MEMBRO_DOMINIO_UTILIZZO ;
	
	/**
	 * il metodo restituisce la rappresentazione stringa delle costanti
	 * @param r RelationNoun 
	 * @return RelationNoun
	 */
	public static String toString(RelationNoun r)
	{
		switch(r)
		{
		case IPERNOMIO : return "@" ;
		
		case IPONIMO : return "~" ;
		
		case ANTONIMO : return "!" ;
		
		case ISTANZA_IPONIMO  : return "~ io" ;
		
		case MEMBRO_OLONIMIA : return "#m" ;
		
		case SOSTANZA_OLONIMIA : return "#s" ;
		
		case MEMBRO_MERONIMO : return "%m" ;
		
		case PARTE_MERONIMO : return "%p" ;
		
		case ATTRIBUTO : return "=" ;
		
		case RELATIVE_DERIVATIONALLY_FORMA : return "+" ;
		
		case DOMINIO_SYNSET_ARGOMENTO : return "c" ;
		
		case MEMBRO_DOMINIO_ARGOMENTO : return "-c" ;
		
		case DOMINIO_SYNSET_REGIONE : return "r" ;
		
		case MEMBRO_DOMINIO_REGIONE : return "-r" ;
		
		case DOMINIO_SYNSET_UTILIZZO : return "u" ;
		
		case MEMBRO_DOMINIO_UTILIZZO : return "-u" ;
		
		
		default : return null ;
		}
	}
	
	
}
