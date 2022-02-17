package exercicios;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

class TerceiroExercicio {
	 
	public static void main( String args[] )
	{
			
		ArrayList<String> sub_strs_list = new ArrayList<String>();
		ArrayList<String> pars_anagram_list = new ArrayList<String>();
		
		//String  teste= "ifailuhkqq";
		//String  teste= "ovo";
		
		String word = JOptionPane.showInputDialog(null,"Escreva uma palavra","Descubra os anagramas pares", JOptionPane.INFORMATION_MESSAGE);
	
		for( int sub_str_begin = 0 ; sub_str_begin < word.length(); sub_str_begin++ )
		{
			for( int sub_str_end = sub_str_begin; sub_str_end < word.length(); sub_str_end++ )
			{
				sub_strs_list.add( word.substring( sub_str_begin,sub_str_end +1) );
				//System.out.print(teste.substring(sub_str_begin_left_to_right,sub_str_end_left_to_right));
				//System.out.print("\n");
				//System.out.print("pares de substring:( "+sub_str_begin_left_to_right+","+sub_str_end_left_to_right+" )\n");
			}
		}
		
		//System.out.print(pars_sub_str);
	
		 for(int sub = 0; sub < sub_strs_list.size(); sub++ )
		 {
			 
			for( int sub_2 = sub; sub_2 < sub_strs_list.size(); sub_2++  )
			{ 
				if( sub_strs_list.get( sub ) != sub_strs_list.get( sub_2 ) )
				{
					if( sub_strs_list.get( sub ).length() == sub_strs_list.get( sub_2 ).length() )
					{
						if( isAnagram( sub_strs_list.get( sub ),sub_strs_list.get( sub_2 ) ) == true )
						{
							pars_anagram_list.add( "["+ sub_strs_list.get( sub ) + ","+ sub_strs_list.get( sub_2 )+ "]" );
						}
					}
				}
			}
		 }
		 
		String text_anagram = " anagrama";
		
		if( pars_anagram_list.size() > 1 ) {
			 text_anagram += "s";
		}
		 
		System.out.println( "Essa palavra tem o total de " + pars_anagram_list.size() + text_anagram );
		System.out.print( "A lista de todos os anagramas pares são: ");
		 
		for( int anagram = 0; anagram < pars_anagram_list.size(); anagram++ )
		{
			 System.out.print( pars_anagram_list.get( anagram ) ); 
		}
	}
		
	/**
    * método que checam se duas palavras são anagrama uma da outra
    * as palavras precisam ser do mesmo tamanho e não nulas
    * para continuar o algoritimo
    * setando caixa baixa as palavras para comparação perfeita
    * ordenação das palavras para garantir a igualdade se houver
    * @param sub_str_1 palavra a ser comparada
    * @param sub_str_2 outra palavra a ser comparada
    * @return boolean validação de para um anagrama 
    */
	public static boolean isAnagram( String sub_str_1, String sub_str_2 )
	{
		
		if( sub_str_1 == null ||sub_str_1 == null )
		{
			return false;
		}
			
		if( sub_str_1.length() != sub_str_2.length() )
		{
			return false;
		}
			
		sub_str_1 = sub_str_1.toLowerCase();
		sub_str_2 = sub_str_2.toLowerCase();
		
		char[] sub_str_1_temp = sub_str_1.toCharArray();
		char[] sub_str_2_temp = sub_str_2.toCharArray();
		
		Arrays.sort( sub_str_1_temp );
		Arrays.sort( sub_str_2_temp );

		return Arrays.equals( sub_str_1_temp, sub_str_2_temp );
		
	}
}