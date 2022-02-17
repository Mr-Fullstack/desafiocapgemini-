package exercicios;


public class PrimeiroExercicio
{
	
	public static void main( String args[ ])
	{
		int n = 16;
        makeStair( n );
	}
	    
    /**
    * m�todo que recebe qualquer um n�mero inteiro e retorna
    * quantidade de caractere(s) para criar o degrau da escada.
    * @param char_quantites quantidade de caracteres.
    * @param step_total quantidade de degrau(s).
    * @return String degrau com total de caractere(s) em tipo String.
    */
    public static String makeStepChar( int char_quantites, int step_total )
    {
        String step= "";
        
        for( int col= 0 ; col < char_quantites; col++ )
        {
        	step += "*";
        }
        
        step = String.format( "%" + String.valueOf( step_total ) + "s", step ); //alinhando texto a direita
        
        if( char_quantites < step_total ) {
        	step += "\n"; //pulando linha at� a base da escada;
        }
        
        return step;
    }
    
    /**
    * M�todo que recebe um n�mero inteiro e 
    * faz um prinln da fun��o makeStepChar()
    * dentro de um for loop com total de degraus
    * @param step_total total de degraus.
    */
    public static void makeStair( int step_total )
    {
		for( int i= 1; i <= step_total; i++ )
        {
           System.out.print( makeStepChar( i, step_total ) );
        }
    }
}
