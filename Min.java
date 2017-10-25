
public class Min extends Maj{

	public Min(String root){
		super(root); 
		noteArray[1]=noteArray[1]-1;
	}
	
	public Min(String root, String sus){
		super(root);
		NUMNOTES=findNumOfSus(sus);
		//System.out.println(NUMNOTES+"NUM");
		noteArray=new int [NUMNOTES];
		noteArray[0]=rootNum;
		noteArray[1]=findThird(rootNum);
		noteArray[1]=noteArray[1]-1;
		noteArray[2]=findFifth(rootNum);
		findSusNum(sus);
	}
}
