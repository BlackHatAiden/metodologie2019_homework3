package it.uniroma1.metodologie2019.hw3;
import java.util.List;
import java.util.Optional;

public class WordNetMapping 
{
	private WordNet sorgente ;
	private WordNet destinazione ;
	
	
	public WordNetMapping(WordNet a , WordNet b)
	{
		this.sorgente = a ;
		this.destinazione = b ;
		
		
	}
	
	/**
	 * il metodo prende in input un Synset e controlla prima se le versioni dei WordNet sono identiche in quel caso ritorna per qualsiasi
	 * Synset l'otional con valore di confidenza 1.0 poi lo matcha con se stesso, in caso di versioni diverse attraverso uno stream sulla 
	 * versione di destinazione si controlla con il filter se sono identiche glosse e sinonimi e poi restituisce l'optional se contiene un valore
	 * altrimenti null
	 * 
	 * Naturalmente richiamando questo metodo nel costruttore  passando in input ogni volta un synset diverso si puo mappare un intera versione di WordNet
	 * l'unico incoveniente e il tempo di esecuzione che credo vadi nell'ordine di O(n^2) facendo una cosa del tipo
	 * 
	 * 
	 * for(Synset s : a.getListaSynset() )
	 * 		getMapping(s)
	 * 
	 * @param src  Synset
	 * @return Optional
	 */
	public Optional<SynsetPairing> getMapping(Synset src)
	{
		
		if(sorgente.getVersion().equals(destinazione.getVersion()) )
			return Optional.ofNullable(new SynsetPairing(src, src) ) ;
		
		
		String glossa = src.getGloss() ;
		List<String> sinonimi = src.getSynonyms() ;
		
        Optional<Synset> s = destinazione.getListaSynset().stream()
        							.filter( x -> x.getGloss().equals(glossa) && x.getSynonyms().equals(sinonimi) )
        							.findFirst() ;    
        		
		
		return s.isPresent() ? Optional.ofNullable(new SynsetPairing(src,s.get()) ) : Optional.ofNullable(null) ; 
	}
	
	
}
