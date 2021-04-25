

public class Fetch extends CPU{

	
	
Decode D=new Decode();
	public Fetch(){

	}

	public String[] InsFetch() {
		int dec = Integer.parseInt(PC, 2) / 4;


		inst =  Memory[dec];
		  System.out.println("Current executing instruction >>"+inst);
		ProgCount();
		fetch_out[0]=inst;
		fetch_out[1]=PC;
		
		D.ContUnit(fetch_out[0]);
		return fetch_out;

	}

	public void ProgCount() {

		String zero = "";

		int dec = Integer.parseInt(PC, 2) + 4;
		String bin = Integer.toBinaryString(dec);
		PC = bin;
		int dif = 16 - PC.length();
		for (int i = 0; i < dif; i++) {
			zero += 0;
		}
		PC = zero + PC;

	}
	
	
}
