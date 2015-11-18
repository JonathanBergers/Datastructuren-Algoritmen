package excercises.excercise1;


public class Opdracht1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime;
		long endTime;
		
		
		
		
		//settings
		int N = 100;
		int opdracht = -1; //-1 for all
		int times = 100;
		
		
		boolean showArrayResult = false;
	
		
		if(opdracht == 1 ||opdracht == -1){
			//opdrachten.opdracht1 -- werkt alleen als 0 niet in de array staat, of een optie voor het getal is
			System.out.println("\n########## OPDRACHT 1 ##########\n");
			for(int i = 0;i<times;i++){
				startTime = System.nanoTime();
				int[] a = opdracht1(N, 1, N+1);
				endTime = System.nanoTime();
				String out = "Opdracht 1."+(i+1)+" \ttook \t"+(endTime - startTime)/1000 + " \tms.";
				if(showArrayResult){
					out+="\tArray ="+arrayToString(a);
				}
				System.out.println(out);
			}
			System.out.println("\n############# DONE #############\n");
		} 
		if(opdracht == 2 ||opdracht == -1) {
			//opdrachten.opdracht2
			System.out.println("\n########## OPDRACHT 2 ##########\n");
			for(int i = 0;i<times;i++){
				startTime = System.nanoTime();
				int[] a = opdracht2(N, 0, N);
				endTime = System.nanoTime();
				String out = "Opdracht 2."+(i+1)+" \ttook \t"+(endTime - startTime)/1000 + " \tms.";
				if(showArrayResult){
					out+="\tArray ="+arrayToString(a);
				}
				System.out.println(out);
			}
			System.out.println("\n############# DONE #############\n");
		} 
		if(opdracht == 3 ||opdracht == -1) {
			//opdracht 3
			System.out.println("\n########## OPDRACHT 3 ##########\n");
			for(int i = 0;i<times;i++){
				startTime = System.nanoTime();
				int[] a = opdracht3(N, 0, N);
				endTime = System.nanoTime();
				String out = "Opdracht 3."+(i+1)+" \ttook \t"+(endTime - startTime)/1000 + " \tms.";
				if(showArrayResult){
					out+="\tArray ="+arrayToString(a);
				}
				System.out.println(out);
			}
			System.out.println("\n############# DONE #############\n");
		}
	}
	
	//opdracht 1 shit
	public static int[] opdracht1(int N, int i, int j){
		int[] a = new int[N];
		for(int k=0; k<N; k++){
			int number = randInt(i, j);
			while(isInArray(number, a)){
				number = randInt(i, j);
			}
			a[k]=number;
		}
		return a;
	}
	private static boolean isInArray(int i, int[] array){
		for(int j : array){
			if(j==i){
				return true;
			}
		}
		return false;
	}
	
	//opdrachten.opdracht2 shit
	public static int[] opdracht2(int N, int i, int j){
		int[] a = new int[N];
		boolean[] used = new boolean[j];
		for(int k=0; k<N; k++){
			int number = randInt(i, j);
			while(used[number]){
				number = randInt(i, j);
			}
			used[number]=true;
			a[k]=number;
		}
		return a;
	}
	
	//opdracht 3 shit
	public static int[] opdracht3(int N, int i, int j){
		int[] a = new int[N];
		for(int k=0; k<N; k++){
			a[k]=k;
			swap(a, k, randInt(0, k));
		}
		return a;
	}
	
	private static int[] swap(int[] a, int index1, int index2){
		int i = a[index1];
		a[index1] = a[index2];
		a[index2] = i;
		return a;
	}
	
	
	
	
	
	
	private static int randInt(int i, int j){
		return (int) (Math.random() * (j-i)) +i;
	}
	private static String arrayToString(int[] a){
		String s = "|";
		for(int i : a){
			s+=i;
			s+="|";
		}
		return s;
	}
}
