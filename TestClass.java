package hacker_earth_practice;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// Frustrated coder solution


class TestClass {
	public static void main(String args[] ) throws Exception {


		//BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String size=br.readLine();
		int len=Integer.parseInt(size);

		String line=br.readLine();
		String token[]=line.split(" ");
		ArrayList<Integer> al=new ArrayList<>();
		for (String temp:token){
			al.add(Integer.parseInt(temp));
		}
		// Reading input from STDIN done
		Collections.sort(al);
		//System.out.println(al);
		//KillCoders(al);
		Stack<Integer>last_candidate=KillCoders2(al);
		//	System.out.println(al);
		//formattedPrint(al);
		formattedPrint2(last_candidate);
	}


	private static void formattedPrint2(Stack<Integer> last_candidate) {

		long  output=0;
		while(last_candidate.size()>0){
			output+=last_candidate.pop();
		}
		System.out.println(output);
	}


	private static Stack<Integer> KillCoders2(ArrayList<Integer> al) {

		Stack<Integer> afterKill=new Stack<>();
		for(int itr=0;itr<al.size();itr++){
			//System.out.println(afterKill);
			if(afterKill.size()>0 &&afterKill.peek()<=al.get(itr)){
				if(afterKill.peek()<al.get(itr)){
					afterKill.pop();
					afterKill.push(al.get(itr));
				}
				else{
					afterKill=reShuffle(afterKill,al.get(itr));
					if(afterKill.size()>0){
						if(afterKill.peek()<al.get(itr)){
							afterKill.pop();
							afterKill.push(al.get(itr));
						}
					}
				}
			}
			else{
				afterKill.push(al.get(itr));
			}
		}
		return afterKill;
	}



	private static Stack<Integer> reShuffle(Stack<Integer> afterKill, Integer repetetion) {
		ArrayList<Integer> header=new ArrayList<>();
		while(afterKill.size()>0 && afterKill.peek()==repetetion){
			header.add(afterKill.pop());		
		}
		if(afterKill.size()>0){
			header.add(afterKill.pop());
		}
		//System.out.println("header "+header);

		Stack<Integer> footer=new Stack<>();
		while(afterKill.size()>0){
			footer.push(afterKill.pop());
		}

		for(int del:header){
			footer.push(del);
		}
		if(footer.size()>0 && footer.peek()<repetetion){
			footer.pop();
			footer.push(repetetion);
		}
		else{
			footer.push(repetetion);
		}
		//System.out.println("footer "+footer);
		return footer;
	}




	private static void formattedPrint(ArrayList<Integer> al) {
		long  output=0;
		for( int temp:al){
			if(temp != -1){output+=temp;}
		}
		System.out.println(output);
	}


	private static void KillCoders(ArrayList<Integer> al) {
		int nextExpired=0;
		if(al.size()<2){return;}
		for(int itr=1;itr<al.size();itr++){

			for(nextExpired=itr-1;nextExpired>=0;nextExpired--){
				if(al.get(nextExpired)<al.get(itr)&&al.get(nextExpired)!=-1 ){
					al.set(nextExpired, -1);
					System.out.println(al);
					break;
				}
			}
		}

	}





}
