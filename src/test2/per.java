package test2;

public class per {

	public static void main(String[] args) {
		per i = new per();
//		int[] a = {1,2,3,4,5};
//		i.Combination(a, 0, 0, 3, "");
		i.Hanoi(10, 'A', 'B', 'C');
	}
	
	public void permute(String str) {
		char[] temp = str.toCharArray();
		permute(temp, 0, str.length() - 1);
	}
	
	private void permute(char[] str, int low, int high) {
		if(low == high) {
			for(int i = 0; i <= high; i++)
				System.out.print(str[i]);
			System.out.println();
		}
		else {
			for(int j = low; j <= high; j++){
				char temp = str[low];
				str[low] = str[j];
				str[j] = temp;
				permute(str, low + 1, high);
				temp = str[low];
				str[low] = str[j];
				str[j] = temp;
			}
		}
	}
	
	public int Max(int[] a, int low, int high) {
		if(low == high - 1) {
			if(a[low] >= a[high])
				return a[low];
			else
				return a[high];
		}
		else {
			if(a[low] >= Max(a, low + 1, high))
				return a[low];
			else
				return Max(a, low + 1, high);
		}
	}
	
	public double Average(int[] a, int low, int high) {
		if(low == high)
			return a[low];
		else
			return(a[low] + Average(a, low + 1, high) * (high - low)) / (high - low + 1);
	}
	
	 public void Combination(int[] chs, int index, int count, int r, String result) {
	        if (count == r) {
	            System.out.println(result);
	            return;
	        }
	 
	        for (int i = index; i < chs.length; ++i) {
	            Combination(chs, i + 1, count + 1, r, result + chs[i] + " ");
	        }
	}
	 
	 public void Hanoi(int n, char fromTower, char toTower, char midTower) {
		 if(n == 1)
			 System.out.println("Move disk 1 from " + fromTower + " to " + toTower);
		 else {
			 Hanoi(n - 1, fromTower, midTower, toTower);
			 System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
			 Hanoi(n - 1, midTower, toTower, fromTower);
		 }
	 }

}
