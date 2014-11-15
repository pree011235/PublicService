package Set_TDD;

public class StaticNonStatic {
	static int staticint;
	int nonstatic;
	
	public void accessStatic(){
		staticint = 5;
	}
	
	public static void accessstatic(){
//		nonstatic =5;
		staticint =5;
	}
	
	public static void main(String[] args){
//		accessStatic();
		
	}
}
