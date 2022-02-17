package exercicios;

import javax.swing.JOptionPane;
import java.util.regex.*;  

public class SegundoExercicio
{
	private static String safe_password_pattern = "(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*()-+]).{6,}$";
	private static boolean close_dialog = false;
	
	public static void main( String[] args )
	{
		showDialogPassword( "A senha precisa ter no mínimo 6 caracteres" );	
	}
	
	public static void showDialogPassword(String title_dialog)
	{
		if(!close_dialog) {
			
			String password_input = JOptionPane.showInputDialog(null,"Digite uma senha",title_dialog, JOptionPane.INFORMATION_MESSAGE);
			
		    if( password_input  == null )
		    {
		    	close_dialog = true; //System.out.print("saiu do programa");
		    }
		    else
		    { 
		       	
				if ( IsSafePassword( password_input ) )
				{
					JOptionPane.showMessageDialog( null, "Senha é forte" );
					JOptionPane.showMessageDialog( null, "sua senha foi criado com sucesso!" );
					close_dialog = true;
				}
				else
				{
					if( password_input.length() == 0 )
					{
						JOptionPane.showMessageDialog( null, "Opps! a senha precisa ter no mínimo 6 caracteres." );
						showDialogPassword( "A senha precisar ter 6 ou mais caracteres " );
					}
					else if( password_input.length() < 6 )
					{
						String chars = " caractere";
						
						if( password_input.length() < 5 )
						{
							chars += "s";
						}
						
						JOptionPane.showMessageDialog( null, "Sua senha é fraca! adicione mais "+( 6 - password_input.length() )+( chars ) );
						showDialogPassword( "A senha precisar ter 6 ou mais caracteres " );
					}
					else
					{
						if( IsSafePassword( password_input ) )
						{
							JOptionPane.showMessageDialog( null, "Senha é forte" );
							JOptionPane.showMessageDialog( null, "sua senha foi criado com sucesso!" );
						}else
						{
							JOptionPane.showMessageDialog( null,"A senha tem mais de 6 caracteres porém ainda é fraca, a senha deve possuir:\n"
									+ "no mínimo 1 digito.\n"
									+ "no mínimo 1 letra em minúsculo.\n"
									+ "no mínimo 1 letra em maiúsculo.\n"
									+ "no mínimo 1 caractere especial dentre estes : !@#$%^&*()-+ ");
						}
					}
				}
		    	
		    	if( password_input.length() >= 1  )
		    	{
		    		if( !IsSafePassword( password_input ) )
		    		{
		    			showDialogPassword("A senha precisa ter no mínimo 6 caracteres");
		    		}
			}
		    }
		}
	}
	
   /**
    * método que checa se a senha é segura
    * fazendo um match verificando atráves de um regex pré setado.
    * @param password com a string da senha digitada pelo usuário.
    * @return boolean safe_password.find();
    */
	public static boolean IsSafePassword( String password )
	{
		Pattern pattern = Pattern.compile( safe_password_pattern );
		Matcher safe_password = pattern.matcher( password );
		
		return safe_password.find();
	}
}
