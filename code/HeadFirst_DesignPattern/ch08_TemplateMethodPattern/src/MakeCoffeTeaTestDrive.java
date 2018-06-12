//author xin
//date 2018-6-12

public class MakeCoffeTeaTestDrive {
	public static void main(String[] args){
		Coffee cof = new Coffee();
		Tea tea = new Tea();
		
		System.out.println(&quot;make coffee:&quot;);
		cof.prepareRecipe();
		
		System.out.println(&quot;\n&quot; + &quot;make tea:&quot;);
		tea.prepareRecipe();
	}
}
