
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
		int stan = 0;  // Stan nawiasów w ci¹gu, powinien wynosiæ 0. 
		boolean flaga = true;
		
		//Sprawdzenie ka¿dego znaku z ci¹gu. Jeœli znakiem jest '(' to zwiêksz stan o 1, jeœli ')' to zmniejsz stan o 1; 
		//Jeœli stan bêdzie ujemny nastêpuje przerwanie dalszego sprawdzania i zwrócenie fa³szu
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
		if(stan>0)  //  stan wiêkszy o zera oznacza niedomniêcie nawiasu - fa³sz 
			flaga = false;

		return flaga;
	}
	
}
