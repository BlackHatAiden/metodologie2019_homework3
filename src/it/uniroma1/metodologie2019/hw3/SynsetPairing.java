package it.uniroma1.metodologie2019.hw3;
public class SynsetPairing 
{
	private Synset sorgente ;
	
	private Synset destinazione ;
	
	private double valore ;
	
	public SynsetPairing(Synset sorgente,Synset destinazione)
	{
		this.sorgente = sorgente ;
		this.destinazione = destinazione ;
		
	}
	
	/**
	 * il metodo restituisce il Synset della versione sorgente del WordNet
	 * @return sorgente
	 */
	public Synset getSource()
	{
		return sorgente;
	}
	
	/**
	 * il metodo restituisce il Synset della versione destinazione del WordNet
	 * @return destinazione
	 */
	public Synset getTarget()
	{
		return destinazione ;
	}
	
	/**
	 * il metodo restituisce un valore (double) di confidenza della coppia compreso tra 0.0 e 1.0 ammettendo quindi anche similitudini
	 * come per esempio stessi sinonimi ma diversa glossa quindi il valore sara 0.5 o partendo dal presupposto di avere stessa glossa
	 * si va a vedere quanti sinonimi in comune si anno cosi da poter asssegnare 0.9 ,0.8 e 0.7 
	 * 
	 * 
	 * 
	 * else if(sorgente.getGloss().equals(destinazione.getGloss()))
		{
			
			for(String s : sorgente.getSynonyms())
				
				for(String ss : destinazione.getSynonyms())
					if(s.equals(ss))
						uguali++ ;
			
			if(sorgente.getSynonyms().size() == uguali+1)
				valore = 0.9 ;
			else if(sorgente.getSynonyms().size() == uguali+2)
				valore = 0.8 ;
			else if(sorgente.getSynonyms().size() == uguali+2)
				valore = 0.7 ;
		}
						
					
		else if(sorgente.getSynonyms().equals(destinazione.getSynonyms()) || sorgente.getGloss().equals(destinazione.getGloss()))
			valore = 0.5 ;
	 * @return valore
	 */
	public double getScore()
	{
		
		if(sorgente.getGloss().equals(destinazione.getGloss()) && sorgente.getSynonyms().equals(destinazione.getSynonyms()))
			valore = 1.0 ;
		
		return valore;
	}

	
}
