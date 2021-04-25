
public class Decode extends CPU{
	
	Execute E=new Execute();
	
	
	public void ContUnit(String  instruction){
		//RS 0-3 ,     RT 4-7 ,    SHAMT \ IMMD 8-11,      OP 12-15
		op=instruction.substring(12,16);
		rs=instruction.substring(0,4);
		rt=instruction.substring(4,8);
		shamt=instruction.substring(8,12);
		immd=shamt;
		
		if(op.equals("0001")){   //ADD
			control_sig[0] = "1";
			control_sig[4] = "1";
		
		}
		
		if(op.equals("0010")){   //SUB
			control_sig[0] = "1";
			control_sig[4] = "1";
		}
		
		if(op.equals("0011")){   //MULT
			control_sig[0] = "1";
			control_sig[4] = "1";
		}
		
		
		if(op.equals("0100")){   //ADDI
			control_sig[0] = "1";
			control_sig[4] = "1";
		}
		
		
		if(op.equals("0101")){   //SLL
			control_sig[0] = "1";
			control_sig[4] = "1";
		}
		
		
		if(op.equals("0110")){   //SRL
			control_sig[0] = "1";
			control_sig[4] = "1";
		}
		

		if(op.equals("0101")){   //ANDI
			control_sig[0] = "1";
			control_sig[4] = "1";
		}
		
		
		if(op.equals("0110")){   //OR
			control_sig[0] = "1";
			control_sig[4] = "1";
		}
		
		
		if(op.equals("1001")){   //LW
			control_sig[2] = "1";
			control_sig[3] = "1";
			control_sig[4] = "1";
			control_sig[6] = "1";
		}
		
		if(op.equals("1010")){   //SW
			control_sig[5] = "1";
			control_sig[6] = "1";
		}
		
		if(op.equals("1011")){   //BEQ
			control_sig[0] = "1";
			control_sig[1] = "1";
		}
		
		if(op.equals("1100")){   //BLT
			control_sig[0] = "1";
			control_sig[1] = "1";
		}
		
		if(op.equals("1101")){   //SLTI
			control_sig[0] = "1";
			control_sig[4] = "1";
		}
		
		
		if(op.equals("1110")){   //JUMB
			control_sig[1] = "1";
			jumb=instruction.substring(0,12);
			
		}
		
		
		E.ALU();
	
	
	}
}
