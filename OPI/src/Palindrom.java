import java.util.*;


public class Palindrom {
	
	public static void main(String[] args)
	{
		// zmienna pomocnica
		int x =0;
		
		//Wynik przechowuje w kolekcji Set aby unikn¹æ powielonych elementów np z:
		//13 * 77 = 1001
		//11 * 91 = 1001
		Set<Integer> palindromy = new HashSet<Integer>();
		
		for(int i =10; i<100; i++){  
			for(int j=10+x; j<100; j++){  // dodanie zmiennej x aby zredukowaæ liczbê powtarzaj¹cych siê mno¿eñ
				palindromy.add(CzyPalindrom(i*j));
			}
			x++;	
		}		
		//usuniêcie zera z kolekcji (niechciany efekt metody)
		palindromy.remove(0);
		System.out.println(palindromy);
	}
	
	public static int CzyPalindrom(int num){
		// zmiene reprezentuj¹ce kolejne cyfry sprawdzanej liczby: pierwsza, druga...
		int p, d, t, c; 
		
		//jeœli sprawdzana liczna jest 3 cyfrowa to porównaj pierwsza i trzeci¹ cyfrê
		if(num<1000){  
			p = Math.round(num/100);
			t = Math.round(num- Math.round(num/10)*10);
			
			if(p == t)
				return num;
			
		}else{
			//za pomoc¹ zaokr¹glenia i prostych operacji matematycznych uzyskuje kolejne cyfry danej liczby
		    p = Math.round(num/1000); 
			d = Math.round((num - p*1000)/100);
			t = Math.round((num - p*1000- d*100)/10);
			c = Math.round((num - p*1000- d*100- t*10));
		
			if(p == c && d == t)
				return num;
			
		}
		return 0;
		
	}
}






















