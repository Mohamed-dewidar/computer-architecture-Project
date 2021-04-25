public class Instruction_Set extends CPU {
	String Result = "";
	static int dec = 0;

	// //////////// Arithmetic Instructions://///////////
	public  String ADD(String data1, String data2) {
		int value1 = Integer.parseInt(data1, 2);
		int value2 = Integer.parseInt(data2, 2);
		dec =value1 + value2;
		if(dec==0)
			zero_flag="1";
		return (Integer.toBinaryString(dec));
	}

	public  String SUB(String data1, String data2) {
		int value1 = Integer.parseInt(data1, 2);
		int value2 = Integer.parseInt(data2, 2);
		dec =value1 - value2;
		if(dec==0)
			zero_flag="1";
		return (Integer.toBinaryString(dec));
	}

	public  String MULT(String data1, String data2) {
		int value1 = Integer.parseInt(data1, 2);
		int value2 = Integer.parseInt(data2, 2);
		dec =value1 * value2;
		if(dec==0)
			zero_flag="1";
		return (Integer.toBinaryString(dec));
	}

	public  String ADDI(String data1, int data2) {
		int value1 = Integer.parseInt(data1, 2);
		dec =value1 + data2;
		if(dec==0)
			zero_flag="1";
		return (Integer.toBinaryString(dec));
	}

	// ////////////Logical Instructions/////////////
	public String OR(String data1, String data2) {
		int value1 = Integer.parseInt(data1, 2);
		int value2 = Integer.parseInt(data2, 2);
		dec =value1 |  value2;
		if(dec==0)
			zero_flag="1";
		return (Integer.toBinaryString(dec));

	}

	public String ANDI(String data1, int data2) {
		int value1 = Integer.parseInt(data1, 2);
		dec =value1 & data2;
		if(dec==0)
			zero_flag="1";
		return (Integer.toBinaryString(dec));
	}

	public String SRL(String data1, String shamt) {
		int value1 = Integer.parseInt(shamt, 2);
		String zero = "";
		for (int i = 0; i < value1; i++)
			zero += "0";
		Result=zero + data1.substring(0, data1.length() - value1);
		dec=Integer.parseInt(Result,2);
		if(dec==0)
			zero_flag="1";
		return Result;
	
	}

	public String SLL(String data1, String shamt) {
		int value1 = Integer.parseInt(shamt, 2);
		String zero = "";
		for (int i = 0; i < value1; i++)
			zero += "0";
		Result=data1.substring(value1, data1.length()) + zero;
		dec=Integer.parseInt(Result,2);
		if(dec==0)
			zero_flag="1";
		return Result;
	}

	// ////////////////////////// Data Transfer
	// Instructions:////////////////////////////
	public String LW(String data1, String data2, String immd) {
		String res ="";

		dec = Integer.parseInt(data1, 2) + Integer.parseInt(immd, 2);
		if (dec == 0)
			zero_flag = "1";
		for (int i = 512; i < Memory.length; i++)
			if (i == dec)
				data2 = Memory[i];
		res = data2;
		System.out.println("First Reg>>> "+data1);
		System.out.println("Second Reg>>> "+data2);
		System.out.println("Immd>>> "+extend_zero(immd));
		System.out.println("Memory data >>> "+Memory[dec]);
		System.out.println("Reg Change >>> "+data2);

		return res;
	}

	public String[] SW(String data1, String data2, String immd) {
		String[] res = new String[2];

		dec = Integer.parseInt(data1, 2) + Integer.parseInt(immd, 2);
		if (dec == 0)
			res[1] = "1";
		Memory[dec] = data2;
		res[0] = data2;
		System.out.println("First Reg>>> "+data1);
		System.out.println("Second Reg>>> "+data2);
		System.out.println("Immd>>> "+extend_zero(immd));
		System.out.println("Reg data >>> "+data2);
		System.out.println("Memory Change >>> "+Memory[dec]);
		

		return res;
	}

	// /////////////////////////////////////////////////

	// /////////////////////// Conditional Branch Instructions: ////////////
	public  boolean BEQ(String data1, String data2) {
		int var1 = Integer.parseInt(data1,2);
		int var2 = Integer.parseInt(data2,2);
		if (var1 == var2)
			return true;
		return false;
	}

	public boolean BLT(String data1, String data2) {
		int var1 = Integer.parseInt(data1,2);
		int var2 = Integer.parseInt(data2,2);
		if (var1 < var2)
			return true;
		return false;
	}
	// ///////////////////////////////////////////////////

	
	public  String SLTI ( String data2 , int data3) {
	    int var2 = Integer.parseInt(data2,2);
	    return (var2<data3)?        "0000000000000001":"0000000000000000" ;
	}
	
	
	public void JUMB(String jumb){
		PC=PC.substring(0,4)+jumb;
		
	}
	
}
