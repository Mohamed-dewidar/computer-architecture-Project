
public class Writeback extends CPU {

	
	Instruction_Set INS = new Instruction_Set();
	
	public void WRITE(){
		int rs_dec = Integer.parseInt(rs, 2);
		int rt_dec = Integer.parseInt(rt, 2);
		String data1 = Registers[rs_dec];
		String data2 = Registers[rt_dec];
		INS.LW(data1, data2, immd);
	}
}
