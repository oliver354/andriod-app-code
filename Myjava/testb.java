import java.util.Scanner;

public class  testb{

	public static void main(String[] args) {
		// 摆放皇后的方案数量
		int result = 0;
		// 8个皇后，queen[i]=j表示第（i+1）行的皇后在第（j+1）列
		int queen[] = new int[8];
		// 初始化状态，－1表示该皇后没有指定在第几列
		for (int i = 0; i < queen.length; i++) {
			queen[i] = -1;
		}
		// 表示当前处理皇后在第几行
		int line = 0;
		while (true) {
			// 当前皇后右移一位
			queen[line]++;
			// 如果超出范围，无法再右移了
			if (queen[line] >= queen.length) {
				// 结束，已经遍历完所有情况了
				if (line == 0)
					break;
				else {
					// 重置该行皇后的位置
					queen[line] = -1;
					// 回溯到上一行，以便让上一行的皇后继续右移
					line--;
					// 跳出循环
					continue;
				}

			} else if (judge_position(line, queen)) {
				// 如果当前行的皇后这样摆放没问题,那么开始处理下一行皇后的位置
				line++;
				// 如果行数超出范围了，表示成功找到了一种方案使得皇后之间不冲突
				if (line >= queen.length) {
					for (int i = 0; i < queen.length; i++) {
						System.out.print(queen[i] + " ");
						// 记录方案总数量
					}
					System.out.println();
					result++;
				}
			}
		}
		System.out.println(result+"");
	}

	public static boolean judge_position(int k, int[] queen) {
		for (int i = k - 1; i > -1; i--) {// i的起点为k-1，即k个皇后的上一行
			if (queen[k] == queen[i] || Math.abs(queen[k] - queen[i]) == Math.abs(k - i)) {
				return false;
			}
		}
		return true;
	}

}




	public static boolean judge_position(int l,int []arr)//arr[l]=n;
	{
		int temp1=temp2=l;
		int temp3=temp4=arr[l];
		int dif=l-arr[l],sum=l+arr[l];
		for(i=0;i<arr.length;i++)
		{
			if((i!=l)&&arr[l]==arr[i])//colum
				return false;
            /*if((i!=z)&&arr[l][i]==x)//row
				return false;	*/	
			temp1--;
			if(temp1>=0)
			{
				if((temp1-dif)==arr[i])
				{
					return false;
				}
			}
			
		}
		
	}
}