package it.uniroma1.metodologie2019.hw3;

public enum RelationAdjective implements WordNetRelation
{
	
	
	ANTONIMO,
	SIMILE_A, 
	PARTICIPIO_VERBO, 
	PERTAINYM, ATTRIBUTO, 
	VEDI_ANCHE, 
	DOMINIO_SYNSET_ARGOMENTO, 
	DOMINIO_SYNSET_REGIONE, 
	DOMINIO_SYNSET_UTILIZZO;
	
	/**
	 * il metodo restituisce la rappresentazione stringa delle costanti
	 * @param r RelationAdjective
	 * @return RelationAdjective
	 */
	public static String toString(RelationAdjective r)
	{
		switch(r)
		{
		
		case ANTONIMO : return "!" ;
		
		case SIMILE_A : return "&" ;
		
		case PARTICIPIO_VERBO : return "<" ;
		
		case PERTAINYM  : return "\\" ;
		
		case ATTRIBUTO : return "=" ;
		
		case VEDI_ANCHE : return "^" ;
		
		case DOMINIO_SYNSET_ARGOMENTO : return ";c" ;
		
		case DOMINIO_SYNSET_REGIONE : return "r" ;
		
		case DOMINIO_SYNSET_UTILIZZO : return "u" ;
		
		default : return null ;
		}
	}
}
