package it.uniroma1.metodologie2019.hw3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public class WordNet implements Iterable<Synset>
{
		//constanti per controllo correttezza versione
		public static final String V_1_6 = "1.6" ;
		
		public static final String V_1_7_1 = "1.7.1" ;
		
		public static final String V_2_0 = "2.0" ;
		
		public static final String V_2_1 = "2.1" ;
		
		public static final String V_3_0 = "3.0" ;
		
		public static final String V_3_1 = "3.1" ;
		
		
		private static WordNet variabile = null ;    //variabile statica per controllo istanza
		
		private static Map<String,WordNet> mappa = new HashMap<String,WordNet>();   //mappa WordNet formata da chiave versione e valore WordNet
		
		private String versione = "" ;
		
		private List<Synset> listaSynset = new ArrayList<>(150000) ;
		
		/**
		 * Costruttore : carico intera versione di WordNet quindi caricano i 4 file data, leggendo riga per riga i file cosi da poter operare sempre e solo su
		 * singole righe e potendo cosi creare ogetti Synset inseriti nella listaSynset
		 * @param versione String
		 */
		private WordNet(String versione)
		{
			this.versione = versione ;
			
			lettura(POS.NOUN) ;
			
			lettura(POS.ADJ) ;
			
			lettura(POS.VERB) ;
			
			lettura(POS.ADVERB) ;
			
			
		}
		
		
		
		/*
		 * metodo ausiliario privato per la creazione dei Synset
		 */
		private void lettura(POS p)
		{
			try(BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + File.separator+ "wordnet-releases"+File.separator+"releases"+File.separator+"WordNet-"+getVersion()+File.separator+"dict"+File.separator+"data."+POS.toString(p) )))
			{
			    while(br.ready())
			    {
			    	String stringa = br.readLine() ;
			    	
			    	if( ! stringa.startsWith("  ")  )    //inizio dalle righe con le informazioni da prelevare
			    	
			    		listaSynset.add(new Synset(stringa) ) ;
			    		
			    }
			    
			}
			catch(IOException e)
			{
				System.out.println("File non trovato") ;
				e.printStackTrace() ;	
			}
		}
		
		/**
		 * il metdo preso in input una versione verifica prima se esiste , poi verifica se e gia stata creata un instanza di quella versione
		 * e se fosse cosi ritorna la stessa istanza altrimenti ne crea una nuova
		 * @param versione String
		 * @return mappa WordNet
		 */
		public static WordNet getInstance(String versione)
		{
			if(versione != V_1_6 && versione != V_1_7_1 && versione != V_2_0 && versione != V_2_1 && versione != V_3_0 && versione != V_3_1)
				return null ;
				
			if(variabile == null || mappa.get(versione) == null)
			{
		       	variabile = new WordNet(versione) ;
			
		       	mappa.put(versione,variabile) ;
		       	
			}
			
			
		    return mappa.get(versione) ;
		}
		
		/**
		 * il metodo presa in input una parola(lemma) restituisce una lista di Synset conteneti quella parola tra tutte le parti del discorso 
		 * @param parola String
		 * @return trovata Synset
		 */
		public List<Synset> getSynsets(String parola)
		{
			List<Synset> trovata = new ArrayList<Synset>(100) ;
			
			for(Synset s : listaSynset)
				if(s.getSynonyms().contains(parola))
				
					trovata.add(s) ;
					
			
			return trovata ;
		}
		
		/**
		 * il metodo presa in input una parola(lemma) restituisce una lista di synset conteneti quella parola filtrando rispetto ad una sola parte del discorso
		 * @param parola String
		 * @param p POS
		 * @return trovata Synset
		 */
		public List<Synset> getSynsets(String parola,POS p)
		{
			List<Synset> trovata = new ArrayList<Synset>(100) ;
			
			for(Synset s : listaSynset)
			
				if(p.equals(s.getPOS()) && s.getSynonyms().contains(parola))
				
						trovata.add(s) ; 
					
			
			
			
			return trovata ;
			
			
			
		}
		
		/**
		 * il metodo preso in input l'offset e la parte del discorso tutto sotto forma di stringa controlla se esiste quel Synset lo restituisce altrimenti restituisce null
		 * @param offsetPos String
		 * @return s Synset
		 */
		public Synset getSynsetFromID(String offsetPos)
		{
			String offsetVero = "" ;
			
			// creazione offset pulito
			for(int i = 0 ; i < offsetPos.length() -1 ; i++)
				offsetVero += offsetPos.charAt(i) ;
			
			
			
			for(Synset s : listaSynset)
				if(s.getOffset().equals(offsetVero))
					return s ;
			
			return null ;     
		}
		
		/**
		 * il metodo restituisce uno stream di Synset
		 * @return listaSynset.stream()
		 */
		public Stream<Synset> stream()
		{
			return listaSynset.stream() ;
		}
		
		/**
		 * il metodo ritorna la versione del WordNet scelta 
		 * @return versione
		 */
		public String getVersion()
		{
			return versione ;
		}
		
		/**
		 * il metodo preso in input un Synset e un simbolo(String) restituisce una lista di Synset con le relazioni corrispondenti null altrimenti
		 * @param s Synset
		 * @param simbolo String
		 * @return relazioniSynset
		 */
		public Collection<Synset> getRelatedSynsets(Synset s,String simbolo)
		{
			Collection<String> listaRelazioni = new ArrayList<String>(100);
			
			Collection<Synset> relazioniSynset = new ArrayList<>(100) ;
			
			
			for(String relazioni : s.getRelations() )
				if(relazioni.startsWith(simbolo) )
					listaRelazioni.add(relazioni.substring(1) ) ;   //offset pulito
			
			
			//scorrendomi i Synset e le relazioni richieste restituisco la lista di quei Synset che le contengono
			for(Synset ls : listaSynset)
				for(String i : listaRelazioni)
					if(ls.getOffset().equals(i)) 
						relazioniSynset.add(ls) ;
			
			return relazioniSynset ;
					
		}
		
		/**
		 * il metodo preso in input un Synset e un simbolo(String) restituisce le relazioni corrispondenti null altrimenti
		 * @param s Synset
		 * @param r WordNetRelation
		 * @return relazioniSynset
		 */
		public Collection<Synset> getRelatedSynsetsV2(Synset s,WordNetRelation r)
		{
			Collection<String> listaRelazioni = new ArrayList<>(100) ;
			
			Collection<Synset> relazioniSynset = new ArrayList<>(100) ;
			
			
			
			for(String relazioni : s.getRelations() )
				if(relazioni.startsWith(WordNetRelation.toString(r)) )
					listaRelazioni.add(relazioni) ;
			
			for(Synset ls : listaSynset)
				for(String i : listaRelazioni)
					if(ls.getOffset().equals(i)) 
						relazioniSynset.add(ls) ;
					
			return relazioniSynset ;
		}
		
		
		/**
		 * il metodo restituisce la lista completa dei Synset del Wordnet
		 * @return listaSynset
		 */
		public List<Synset> getListaSynset()
		{
			return listaSynset ;
		}
		
		/**
		 * inizio procedura per rendere iterabile WordNet : creo classe annidata che restituirò attraverso la ridefinizione di Iterator
		 * all'interno della classe anonima ridefinsco hasNext facendo il controllo sulle posizioni della List mentre next restituisce
		 * gli ogetti Synset finche esistono
		 * @return WordNetIterator
		 */
		
		@Override
		public Iterator<Synset> iterator()
		{
			return new WordNetIterator();
		}
		
		private class WordNetIterator implements Iterator<Synset>
		{
			private int val = 0;
			
			@Override
			public boolean hasNext() 
			{ 
				return val < listaSynset.size() ; 
				
			}
			
			@Override
			public Synset next() 
			{
				return hasNext() ? listaSynset.get(val++) : null; 
				
			}
		}
		
		

}
