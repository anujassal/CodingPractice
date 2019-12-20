package com.coding.practice;


public class SubArrayDivision {
	
	public static int subArrayDivByK(int[] arr,int k) {
		int len = arr.length;
		if(len<1)return 0;
		int[] sum = new int[len+1];
		for(int i=0;i<len;i++) {
			sum[i+1] = sum[i]+arr[i];
		}
		int[] c = new int[k];
		for(int a:sum) {
			System.out.println((a%k+k)%k);
			System.out.println(c[(a%k+k)%k]);
			c[(a%k+k)%k]++;
		}
		int ans = 0;
		for(int a:c) {
			if(a>1) {
				a=a*(a-1)/2;
				ans=ans+a;
			}
		}
		return ans;
	}
	
	/*public static void main(String[] args) {
		int[] A = {4,5,0,-2,-3,1};
		int k=5;
		int result = subArrayDivByK(A,k);
		System.out.println(result);
	}*/
	


	    public static void main(String[] args) 
	    {
	        int[] A = {4, 5, 0, -2, -3, 1};
	       // SubArrayDivisible obj = new SubArrayDivisible();
	        countSubArray(A,5);
	    }

	    private static void getSubArrays(int[] A,int K)
	    {
	        int count = 0,s=0;
	        for(int i=0;i<A.length;i++)
	        {
	            s = 0;
	            for(int j = i;j<A.length;j++)
	            {
	                s = s+A[j];
	                if((s%K) == 0)
	                {
	                    System.out.println("Value of S "+s);
	                    count++;
	                }

	            }
	        }
	        System.out.println("Num of Sub-Array "+count);
	    }
	    
	    public static int countSubArray(int [] nums, int k){
	        int [] storedArray = new int[k];
	        int sum=0, res=0;
	        for(int i=0; i<nums.length; i++){
	            sum = (((sum + nums[i]) % k) + k) % k;
	            res += storedArray[sum];
	            storedArray[sum]++;

	        }
	        res += storedArray[0];
	        return res; 
	    }
	}


