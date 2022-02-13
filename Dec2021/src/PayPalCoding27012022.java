import java.util.Arrays;

public class PayPalCoding27012022 {
	
	public int[] findRepeatedIndexes(int[] arr, int k){
        int low =0;
        int high = arr.length-1;
        
        int startingIndex = binarySearch(arr ,low, high,k);
        int output[] = new int[2];
        System.out.println(startingIndex);
        
        if (startingIndex!=-1){
            output[0] = startingIndex;
            int i;
            for(i =startingIndex-1;i>0;i--){
                if(arr[i]!=k){
                    break;
                }
            }
             output[1] = i+1;
            
        }
        
        return output;
        
        
    }
    
    public int binarySearch(int arr[] ,int low, int high,int k){
        if(low<=high){
            
        int mid = low + (high-low)/2;
        
        if(arr[mid]==k){
            return mid;
        }else if(arr[mid] >k){
            high =mid-1;
        }else{
            low =mid+1;
        }
          return binarySearch(arr,low,high,k);
        }else{
            return -1;
        }
        
        
    }

	public static void main(String[] args) {
		int arr[] = { 1 ,2 ,3 ,3,4 ,4 ,4 ,4 ,4 ,5 ,6 ,7 ,8 ,9 ,10};
	     int k =3;

	     int[] op =new PayPalCoding27012022().findRepeatedIndexes(arr,k);
	     System.out.println(Arrays.toString(op));

	}

}
