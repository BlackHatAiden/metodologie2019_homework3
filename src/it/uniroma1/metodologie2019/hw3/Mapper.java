package it.uniroma1.metodologie2019.hw3;

public class Mapper 
{
	/**
	 * il metodo presi in input 2 WordNet sorgente e destinazione restituisce un ogetto WordNetMapping() che fornira le mappature
	 * @param a WordNet
	 * @param b WordNet
	 * @return WordNetMapping(a,b)
	 */
	public static WordNetMapping map(WordNet a,WordNet b)
	{
		return new WordNetMapping(a,b) ;
	}

	
}
