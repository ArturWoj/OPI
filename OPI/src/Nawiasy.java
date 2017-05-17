
public class Nawiasy {
	
	
	public static void main(String[] args)
	{
		Nawiasy n = new Nawiasy();
		
		System.out.println(n.weryfikujCiag("alaMa((()))kota()"));
		System.out.println(n.weryfikujCiag("(a(c)"));
		System.out.println(n.weryfikujCiag(")b"));
		System.out.println(n.weryfikujCiag("(b(s))"));
	}
	
	public boolean weryfikujCiag(String napis){
		int stan = 0;  // Stan nawias�w w ci�gu, powinien wynosi� 0. 
		boolean flaga = true;
		
		//Sprawdzenie ka�dego znaku z ci�gu. Je�li znakiem jest '(' to zwi�ksz stan o 1, je�li ')' to zmniejsz stan o 1; 
		//Je�li stan b�dzie ujemny nast�puje przerwanie dalszego sprawdzania i zwr�cenie fa�szu
		for(char c : napis.toCharArray()){  
			if(c == '('){
				stan++;
			}else if(c == ')'){
				stan--;
				if(stan<0){
					flaga = false;
					break;
				}
			}
		}
		if(stan>0)  //  stan wi�kszy o zera oznacza niedomni�cie nawiasu - fa�sz 
			flaga = false;

		return flaga;
	}
	
}
