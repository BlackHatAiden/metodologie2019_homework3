package it.uniroma1.metodologie2019.hw3;

public enum RelationAdverb 
{
	ANTONIMO,
	DERIVATO_AGGETTIVO,
	DOMINIO_SYNSET_ARGOMENTO,
	DOMINIO_SYNSET_REGIONE,
	DOMINIO_SYNSET_UTILIZZO ;
	
	/**
	 * il metodo restituisce la rappresentazione stringa delle costanti
	 * @param r RelationAdverb
	 * @return RelationAdverb
	 */
	public static String toString(RelationAdverb r)
	{
		switch(r)
		{
		
		case ANTONIMO : return "!" ;
		
		case DERIVATO_AGGETTIVO  : return "\\" ;
		
		case DOMINIO_SYNSET_ARGOMENTO : return "c" ;
		
		case DOMINIO_SYNSET_REGIONE : return "r" ;
		
		case DOMINIO_SYNSET_UTILIZZO : return "u" ;
		
		default : return null ;
		}
	}
}
