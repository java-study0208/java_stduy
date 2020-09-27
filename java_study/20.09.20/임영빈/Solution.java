package java_tutorials.test;


class Solution {
	
	public static void main(String[] args) {
		String answer = solution(16,16,2,2);
		System.out.println(answer);
	}
	
    public static String solution(int n, int t, int m, int p) {
    	String str= "";
    	String answer="";
    	int i=0, j=0;
    	//str에 순서대로 숫자 다 넣어두고
    	for(i=0;i<t*m;i++) {
	    	str += returnNum(n,i);
    	}
    	
    	//str에 있는거 중 사람 수로 나눴을 때 순서값(p) 나온것만 answer에 넣기
    	
    	for(j=0; j<t*m; j++) {
    		if(j%m == p-1)
    			answer +=str.charAt(j);
    	}
    	return answer;
    }
    
    public static String returnNum(int n, int number){
    	String str1="";
    	String str2="";
    	while(true) {
    		switch (number%n) {
    		case 10:
    			str2+="A";
    			break;
    		case 11:
    			str2+="B";
    			break;
    		case 12:
    			str2+="C";
    			break;
    		case 13:
    			str2+="D";
    			break;
    		case 14:
    			str2+="E";
    			break;
    		case 15:
    			str2+="F";
    			break;
    		default:
    			str2+=number%n;
    			break;
    		}
    		if(number/n != 0)
    			number = number/n;
    		else
    			break;
    	}
    	
    	for(int i = str2.length()-1 ; i > -1 ;i--) {
    		str1 += str2.charAt(i);
    	}
    	return str1;
    }
}
