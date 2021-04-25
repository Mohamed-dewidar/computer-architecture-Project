public class Execute extends CPU {

	public void ALU() { // String rs,String rt,String IM_SH,String op
		int rs_dec = Integer.parseInt(rs, 2);
		int rt_dec = Integer.parseInt(rt, 2);
		 data1 = Registers[rs_dec];
	     data2 = Registers[rt_dec];
		Instruction_Set INS = new Instruction_Set();
		Writeback W = new Writeback();
		Memory M = new Memory();
		int data3 = 0;

		if (op.equals("0001")) { // ADD
			Registers[15] = extend_zero(INS.ADD(data1, data2));
			System.out.println("First Reg>>> "+data1);
			System.out.println("Second Reg>>> "+data2);
			System.out.println("Alu Res >>> "+Registers[15]);
		}

		if (op.equals("0010")) { // SUB
			Registers[15] = extend_zero(INS.SUB(data1, data2));
			System.out.println("First Reg>>> "+data1);
			System.out.println("Second Reg>>> "+data2);
			System.out.println("Alu Res >>> "+Registers[15]);
		}

		if (op.equals("0011")) { // MULT
			Registers[15] = extend_zero(INS.MULT(data1, data2));
			System.out.println("First Reg>>> "+data1);
			System.out.println("Second Reg>>> "+data2);
			System.out.println("Alu Res >>> "+Registers[15]);
		}

		if (op.equals("0100")) { // ADDI
			data3 = Integer.parseInt(immd, 2);
			Registers[rt_dec] = extend_zero(INS.ADDI(data1, data3));
			System.out.println("First Reg>>> "+data1);
			System.out.println("Second Reg>>> "+data2);
			System.out.println("Immd>>> "+extend_zero(immd));
			System.out.println("Alu Res >>> "+Registers[rt_dec]);
		}

		if (op.equals("0101")) { // SLL
			Registers[15] = SignExtend(INS.SLL(data1, shamt));
			System.out.println("First Reg>>> "+data1);
			System.out.println("Second Reg>>> "+data2);
			System.out.println("Alu Res >>> "+Registers[15]);
		}

		if (op.equals("0110")) { // SRL
			Registers[15] = SignExtend(INS.SRL(data1, shamt));
			System.out.println("First Reg>>> "+data1);
			System.out.println("Second Reg>>> "+data2);
			System.out.println("Alu Res >>> "+Registers[15]);
		}

		if (op.equals("0111")) { // ANDI
			data3 = Integer.parseInt(immd, 2);
			Registers[rt_dec] = extend_zero(INS.ANDI(data1, data3));
			System.out.println("First Reg>>> "+data1);
			System.out.println("Second Reg>>> "+data2);
			System.out.println("Immd>>> "+extend_zero(immd));
			System.out.println("Alu Res >>> "+Registers[rt_dec]);
		}

		if (op.equals("1000")) { // OR
			Registers[15] = extend_zero(INS.OR(data1, data2));
			System.out.println("First Reg>>> "+data1);
			System.out.println("Second Reg>>> "+data2);
			System.out.println("Alu Res >>> "+Registers[15]);

		}

		if (op.equals("1001")) { // LW
			W.WRITE();
		
		}

		if (op.equals("1010")) { // SW
			M.MEMORY();
		}

		if (op.equals("1011")) { // BEQ
			if (INS.BEQ(data1, data2)){
				int value1=Integer.parseInt(SignExtend(immd));
				int value2=Integer.parseInt(PC);
				int res=value1+value2;
				temp_pc =extend_zero(Integer.toBinaryString(res));
						
			}
			System.out.println("First Reg>>> "+data1);
			System.out.println("Second Reg>>> "+data2);
			System.out.println("Branch Address>>> "+temp_pc);

		}

		if (op.equals("1100")) { // BLT
			if (INS.BLT(data1, data2))
				temp_pc= PC + SignExtend(immd);
			System.out.println("First Reg>>> "+data1);
			System.out.println("Second Reg>>> "+data2);
			System.out.println("Branch Address>>> "+temp_pc);

		}
		
		if (op.equals("1101")) { // SLTI
		data3=Integer.parseInt(immd,2);
		Registers[rs_dec]= INS.SLTI(data2, data3);
		System.out.println("First Reg>>> "+data1);
		System.out.println("Second Reg>>> "+data2);
		System.out.println("Immd>>> "+extend_zero(immd));
		System.out.println("Reg Change >>> "+Registers[rs_dec]);
		
		}
		
		if (op.equals("1110")) { // JUMB
			INS.JUMB(jumb);
			System.out.println("Branch Address>>> "+PC);
			}
		
		System.out.println("REG DST >> "+control_sig[0]);
		System.out.println("BRANCH >> "+control_sig[1]);
		System.out.println("MEM READ>> "+control_sig[2]);
		System.out.println("MEM TO REG >> "+control_sig[3]);
		System.out.println("REG WRTIE>> "+control_sig[4]);
		System.out.println("MEM WRITE >> "+control_sig[5]);
		System.out.println("ALU SRC >> "+control_sig[6]);
		for(int i=0;i<control_sig.length;i++)
			control_sig[i]="0";

	}

}
