class commandchar{
	public static void main(String x[]){
		char a[]=new char[20];
		a[1]=' ';
		a[2]='t';
		//a=s.toCharArray();
		
		if (a.length<1 ){
			System.out.println("char is empty");
		}
		else{
			boolean isEmpty=false;
			for (int i=0;i<a.length;i++){
				if(a[i]==' '){
					isEmpty=true;
				}
				else{
					isEmpty=false;
				}
			}
			System.out.println("is A Empty- "+isEmpty);
		}
	
	}
	
}