class Solution {
    int findKRotation(int arr[], int n) {
        int lo=0;
        int hi=n-1;
        while(lo<hi){ 
            int mid=lo+(hi-lo)/2;
            if(arr[mid]>arr[hi]){ 
               lo=mid+1;
            }
               else { 
                hi=mid;
               }   
        }
        //  the smallest element will always be at the index tha means how many rotations were there
        // so we  will just return the index of the smallest element 
        return lo;

    }
}
