
public  class Sort {
	
	public static void  mergesort(int[] a) {
		int arraylen = a.length;
		
		if(arraylen<2) {
			return;
		}
		
		int midIndex = arraylen/2;
		int[] leftHalf = new int[midIndex];
		int[] rightHalf = new int[arraylen-midIndex];
		
		for(int i=0;i<midIndex;i++) {
			leftHalf[i] = a[i];
		}
		for(int i=midIndex;i<arraylen;i++) {
			rightHalf[i-midIndex] = a[i];
		}
		mergesort(leftHalf);
		mergesort(rightHalf);
		merge(a,leftHalf,rightHalf);
		
	}
		
	public static void merge(int[] a , int[] leftHalf, int[] rightHalf) {
		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;
		
		int i = 0, j = 0, k = 0;
		
		while (i<leftSize && j < rightSize) {
			if (leftHalf[i]>rightHalf[j]) {
				a[k] = leftHalf[i];
				i++;
			}
			else{
				a[k] = rightHalf[j];
				j++;
			}
			k++;
				
		}
		while (i < leftSize) {
			a[k] = leftHalf[i];
			i++;
			k++;
			
		}
		while (j < rightSize) {
			a[k] = rightHalf[j];
			j++;
			k++;
			
		}
		
		
	}

}
