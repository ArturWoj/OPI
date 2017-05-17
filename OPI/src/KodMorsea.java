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
        //Utowrzy³em dwie mapy, jako s³owniki do kodowania i odkodowywania
        // pozwoli to unikn¹æ tworzenia zagnie¿dzonych pêtli podczas przeszukiwania tablic 
        
        for(int i = 0; i<txt.length; i++){
        	txtNaKod.put(txt[i].toUpperCase(),kod[i]);   //dla uproszczenia wszystkie znaki bêd¹ wielkie
        	kodNaTxt.put(kod[i],txt[i].toUpperCase());        	
        }
    
         zakoduj(txtNaKod, "ALAMAKOTA");  //.- .-.. .- -- .- -.- --- - .- 
         odkoduj(kodNaTxt, ".-.. ..- -... .. . .--. .-. --- --. .-. .- -- --- .-- .- -.-. ");
    }
            
    static public void zakoduj(Map<String, String> txtNaKod, String napis){
    	String zakodowany ="";
    	StringBuilder sB = new StringBuilder(zakodowany);
    	napis = napis.toUpperCase();  // dla bezpieczeñstwa zmieniam napis wejœciowy na wielkie litery
    	
    	for(int i = 0; i< napis.length(); i++){ // rozbijam napis na pojedyñcze znaki i od razu znachodzê ich odpowiednik w alfabecie Morsa
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
    		//odkodowanie wygl¹da podobnie jak kodowanie, z t¹ ró¿nic¹ ¿e trzeba wyszukaæ ci¹g kropek i kresek odpowiadaj¹cy jednej literze
    		//wykorzysta³em fakt, ¿e ka¿dy zakodowany znak jest oddzielony spacj¹.
    		//Gdyby zakodowany tekst nie posiada³ odstêpów nale¿a³oby "sklejaæ" pojedyñcze kropki oraz kreski i sprawdzaæ z ka¿d¹ iteracj¹ pêtli czy wystêpuj¹ w Mapie(s³owniku)
    		
    		if(szyfr.charAt(i)==' '){
        		sB.append(kodNaTxt.get(szyfr.substring(tmpIdx, i)));
        		tmpIdx = i+1;
    		}
    	}
    	
    	zakodowany = sB.toString();
    	System.out.println(szyfr+"\n"+zakodowany);

    }
}








