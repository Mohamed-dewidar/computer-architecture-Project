import java.util.ArrayList;

public class CPU {
	static String[] Registers = new String[16];
	// Registers[0] ZERO Register
  //Reg 1 to 14 contaions data , and work as temp 
	// Reg 15 to save data comes from ALU, in case if we used RS , RT
	 static String[] control_sig = { "0", "0", "0", "0", "0", "0", "0", "0", };
	// control_sig[0]>>>REG DST
	// control_sig[1]>>>BRANCH
	// control_sig[2]>>>MEM READ
	// control_sig[3]>>>MEM TO REG
	// control_sig[4]>>>REG WRITE
	// control_sig[5]>>>MEM WRITE
	// control_sig[6]>>>ALU SRC
	// control_sig[7]>>>ALU OP

	static String extend_data = "";
    static ArrayList<String> instructions=new ArrayList<String>();
	static String op = "";
	static String rs = "";
	static String rt = "";
	static String shamt = "";
	static String immd = "";
	static String jumb = "";
	static String[] Memory = new String[1024];
	static String[] Cache = new String[16];
	static String zero_flag = "0";
	static String[] fetch_out = new String[2];
	static String PC = "0000000000000000";
	static String inst = "";
	static String temp_pc="";
	static String data1="";
	static String data2="";

	public String extend_zero(String bits) {
		int dif = 16 - bits.length();
		String zero = "";
		for (int i = 0; i < dif; i++)
			zero += "0";
		return bits = zero + bits;
	}

	public String SignExtend(String sig) {
		int num = 16 - sig.length();
		String zeros = "";

		for (int i = 0; i < num; i++)

			zeros += sig.charAt(0);

		extend_data = zeros + sig;
		return extend_data;
	}

	public CPU() {

	}

	public static void main(String[] args) {
		Fetch F = new Fetch();
		
		

		Registers[0] = "0000000000000000";
		Registers[1] = "0000000000000100";
		Registers[2] = "0000000000001001";
		Registers[3] = "0000000000000101";
		Registers[4] = "0000000000001101";
		Registers[5] = "0000000000000111";
		Registers[6] = "0000000000001111";
		Registers[7] = "0000000000001000";
		Registers[8] = "0000000000001000";
		Registers[9] = "0000000000001000";
		Registers[10] = "0000000000011000";
		Registers[11] = "0000000000001000";
		Registers[12] = "0000001001010110";
		Registers[13] = "0000000000010000";
		Registers[14] = "0000000000001001";
		Registers[15] = "0000000000001010";

		Memory[0] = "0010000100100001"; // ADD
		Memory[1] = "0010000100100010"; // SUB
		Memory[2] = "0010000100100110"; // SRL
		Memory[3] = "0010111000101011"; // BEQ
		Memory[4] = "1100001100101001"; //LW
		Memory[5] = "1100000100100100";
		Memory[6] = "0001001011111101";
		Memory[6] = "0001001011111110";//JUMB
			
		Memory[600] = "0100100000001111";
		Memory[601] = "0100100000001111";
		
		for(int i=1;i<=512 & Memory[i]!=null;i++){
			  System.out.println("Cycle >>"+i);
		F.InsFetch();
		
              System.out.println("\n\n");
		
		}
	}

}
