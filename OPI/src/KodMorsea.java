import java.util.*;

public class KodMorsea {
    public static void main(String args[]){
    	
        String[] txt = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "x", "y", "z" };
        String[] kod = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--.." };	
        
        Map<String, String> txtNaKod = new HashMap<String, String>();
        Map<String, String> kodNaTxt = new HashMap<String, String>();
        //Utowrzy�em dwie mapy, jako s�owniki do kodowania i odkodowywania
        // pozwoli to unikn�� tworzenia zagnie�dzonych p�tli podczas przeszukiwania tablic 
        
        for(int i = 0; i<txt.length; i++){
        	txtNaKod.put(txt[i].toUpperCase(),kod[i]);   //dla uproszczenia wszystkie znaki b�d� wielkie
        	kodNaTxt.put(kod[i],txt[i].toUpperCase());        	
        }
    
         zakoduj(txtNaKod, "ALAMAKOTA");  //.- .-.. .- -- .- -.- --- - .- 
         odkoduj(kodNaTxt, ".-.. ..- -... .. . .--. .-. --- --. .-. .- -- --- .-- .- -.-. ");
    }
            
    static public void zakoduj(Map<String, String> txtNaKod, String napis){
    	String zakodowany ="";
    	StringBuilder sB = new StringBuilder(zakodowany);
    	napis = napis.toUpperCase();  // dla bezpiecze�stwa zmieniam napis wej�ciowy na wielkie litery
    	
    	for(int i = 0; i< napis.length(); i++){ // rozbijam napis na pojedy�cze znaki i od razu znachodz� ich odpowiednik w alfabecie Morsa
    	//	System.out.println(napis.substring(i, i+1)+ "   "+ txtNaKod.get(napis.substring(i, i+1)));
    		sB.append(txtNaKod.get(napis.substring(i, i+1))+" ");
    	}
    	
    	zakodowany = sB.toString();
    	System.out.println(napis+"\n"+zakodowany);
    	
    }
    
    static public void odkoduj(Map<String, String> kodNaTxt, String szyfr){
    	String zakodowany ="";
    	StringBuilder sB = new StringBuilder(zakodowany);
    	
    	int tmpIdx =0; 
    	
    	for(int i = 0; i< szyfr.length(); i++){ 
    		//odkodowanie wygl�da podobnie jak kodowanie, z t� r�nic� �e trzeba wyszuka� ci�g kropek i kresek odpowiadaj�cy jednej literze
    		//wykorzysta�em fakt, �e ka�dy zakodowany znak jest oddzielony spacj�.
    		//Gdyby zakodowany tekst nie posiada� odst�p�w nale�a�oby "skleja�" pojedy�cze kropki oraz kreski i sprawdza� z ka�d� iteracj� p�tli czy wyst�puj� w Mapie(s�owniku)
    		
    		if(szyfr.charAt(i)==' '){
        		sB.append(kodNaTxt.get(szyfr.substring(tmpIdx, i)));
        		tmpIdx = i+1;
    		}
    	}
    	
    	zakodowany = sB.toString();
    	System.out.println(szyfr+"\n"+zakodowany);

    }
}








