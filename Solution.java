package challange;


import java.io.*;
import java.util.*;


// change array into number has exactly three divisor
public class Solution {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line=br.readLine();
		String takens[]=line.split(" ");
		int numberOfEliment=Integer.parseInt(takens[0]);
		int numberOfElimentFinally=Integer.parseInt(takens[1]);
		line=br.readLine();
		takens=line.split(" ");
		int a[]=new int[numberOfEliment];
		for(int zz=0;zz<numberOfEliment;zz++){
			a[zz]=Integer.parseInt(takens[zz]);
		}
		//input over
		

ArrayList<Integer> al =getNumbersOfIntrest();

		//System.out.println(al);
		//System.out.println(isPrime(Math.sqrt(15)));
		ArrayList<Integer>operationNeeded=new ArrayList<>();
	
		for(int k=0;k<a.length;k++){
			//operationNeeded.put(a[k],getMinDifference(al,a[k]));
		operationNeeded.add(getMinDifference(al,a[k]));
			//System.out.println(a[k]+"--"+operationNeeded.get(a[k]));			
		}
		//ArrayList<Integer> sortedval=new ArrayList<Integer>(operationNeeded.values());
	
		//Collections.sort(sortedval);
		System.out.println(operationNeeded);
		Collections.sort(operationNeeded);
		System.out.println(operationNeeded);
		printResult(operationNeeded,numberOfElimentFinally);
		

	}

	/**
	 * @return
	 */
	private static ArrayList<Integer> getNumbersOfIntrest() {
		ArrayList<Integer> res=new ArrayList<>();
		int i;
		double tempPow;
		for(i=2;i<1000;i++){
			if(isPrime(i)){
				res.add((int)Math.pow(i, 2));
			}
		}
		return res;
	}

	/**
	 * @param al
	 * @param i
	 * @return
	 */

	private static boolean isPrime(double n) {
        if (n <= 1) 
            return false; 
        if (n <= 3) 
            return true; 
        if (n % 2 == 0 || n % 3 == 0) 
            return false; 
  
        for (int i = 5; i * i <= n; i = i + 6) 
            if (n % i == 0 || n % (i + 2) == 0) 
                return false; 
  
        return true;
	}

	
	private static void printResult(ArrayList<Integer> sortedval, int i) {
		int outp=0;
		for(int itr=0;itr<i;itr++){
			outp+=sortedval.get(itr);
		}
		System.out.println(outp+(sortedval.size()-i));
	}

	/**
	 * @param al
	 * @param i
	 * @return
	 */
	private static Integer getMinDifference(ArrayList<Integer> al, int i) {
		int diff=-1;
		double tempsqrt=Math.sqrt(i);
		if(isPrime(tempsqrt) && Math.floor(tempsqrt)==tempsqrt){
			return 0;
		}
		for(int comp=0;comp<al.size();comp++){
			if(al.get(comp)>=i){
				if(comp<1){
					diff=al.get(comp)-i;
					break;
				}
				else{
					diff=(i-al.get(comp-1))>(al.get(comp)-i) ?(al.get(comp)-i):(i-al.get(comp-1));
					break;
				}
			}
		}

		return diff;
	}


}
	


