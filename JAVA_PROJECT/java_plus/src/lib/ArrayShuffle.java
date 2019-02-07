package lib;

public class ArrayShuffle {
	public static void main(String[] args){
		// ############## 1. boolean 스위치 ###################
	    int arr1[] = new int[50];
	    boolean _switch[] = new boolean[arr1.length];

	    //배열에 0부터 49까지의 숫자를 순서대로 삽입한다.
	    for (int i=0; i<arr1.length; i++){
	    	arr1[i] = i;
	    }
	    System.out.println("\n섞기 전");
	    for (int i=0; i<arr1.length; i++){
	      System.out.print(arr1[i]+" ");
	    }

	    //boolean 스위치를 true로 전부 초기화 한다.
	    for (int i=0; i<_switch.length; i++){
	      _switch[i] = true;
	    }

	    int w=0;
	    int r1;
	    while (w<arr1.length){
	      //0~49의 랜덤수의 index를 갖는 _switch배열의 원소가
	      //true이면 if문을 실행한다.
	      //ex 랜덤수가 4이면 _switch[4]는 false가 되고,
	      //다음에 다시 4가 나와도 아무일도 일어나지 않고 while문을 돈다.
	      //그렇게 모든 switch배열이 false로 바뀌면 shuffle이 완료 된다.
	    	r1 = (int)(Math.random()*arr1.length);
	      if(_switch[r1]){
	        _switch[r1] = false;
	        arr1[w] = r1;
	        w++;
	      }
	    }
	    System.out.println("\n섞은 후");
	    for (int i=0; i<arr1.length; i++){
	      System.out.print(arr1[i]+" ");
	    }
	  
	
	
		// ############## 2. random swap ###################

		    int arr2[] = new int[50];
		    //배열 초기화
		    for (int i=0; i<arr2.length; i++){
		    	arr2[i] = i;
		    }
		    System.out.println("\n섞기 전");
		    for (int i=0; i<arr2.length; i++){
		      System.out.print(arr2[i]+" ");
		    }

		    int idx=0;
		    int r2;
		    int temp;
		    while(idx < arr2.length){
		      //0~49의 수를 랜덤하게 뽑아낸다.
		      r2 = (int)(Math.random()*arr2.length);
		      //만약 두 인덱스가 다르다면
		      if(w!=r2){
		        //swap으로 값을 바꾼다.
		        temp = arr2[idx];
		        arr2[idx] = arr2[r2];
		        arr2[r2] = temp;
		        w++;
		      }
		    }
		    System.out.println("\n섞기 후");
		    for (int i=0; i<arr2.length; i++){
		      System.out.print(arr2[i]+" ");
		    }
	}
}

