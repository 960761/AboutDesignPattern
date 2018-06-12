import java.io.*;

public class Coffee extends CoffeeAndTea {
	public void brew(){
		System.out.println(&quot;Dripping Coffee through filter&quot;);
	}
	
	public void addCondiments(){
		System.out.println(&quot;Adding milk and suger&quot;);
	}
	
	//hook function
	public boolean customerWantCondiments(){
		String answer = getUserInput();
		
		if(answer.toLowerCase().startsWith(&quot;y&quot;) ){ 
			return true;
		}else { return false; }
	}
	
	private String getUserInput(){
		String answer = null;
		System.out.println(&quot;Would you like milk and suger with your coffee?(y/n)? &quot;);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			answer = in.readLine();
		}catch(IOException ex){
			System.err.println(&quot;IO error trying to read your answer&quot;);
		}
		
		if(answer == null){ return &quot;no&quot;;}
		
		return answer;
	}
}
