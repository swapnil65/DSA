/*
 * Edge Detection: 
 * Two-dimensional array representation of an image can also be represented by a one-dimensional array of W*H size, 
 * where W represent row and H represent column size and each cell represent pixel value of that image. you are also
 * given a threshold X. For edge detection, you have to compute difference of a pixel value with each of it's adjacent
 * pixel and find maximum of all differences. And finally compare if that maximum difference is greater than threshold X.
 * if so, then that pixel is a edge pixel and have to display it.
 */
public class EdgeDetection {

	public static int[] processEdges(int image[], int height, int width, int threshold)
	{
		if(image == null) {
			return null;
		}
		if(width == 1) {
			return null;
		}

		if(image.length < width || image.length % width > 0) {
			return null;
		}

		int n = image.length;

		int left, right, top, bottom, value, diff1 = 0,diff2=0,diff3=0,diff4=0;
		int output[] = new int[n];

		for(int row = 0; row < n; row += width) 
		{
			for(int col = row; col < row + width; col++) 
			{
				boolean exceed = false;
				value = image[col];

				if(col - 1 >= 0) 
				{
					left = image[col - 1];
					diff1 = Math.abs(left - value);
				}
				if(col + 1 < width) 
				{
					right =image[col + 1];
					diff2 = Math.abs(right - value);
				}
				if(col + width < n) 
				{
					bottom = image[ width + col];
					diff3 = Math.abs(bottom - value);
				}
				if(col - width  >= 0) 
				{
					top = image[col - width];
					diff4 = Math.abs(top - value);	 
				}
				
				int max1=Math.max(diff1,diff2);
				int max2=Math.max(diff3,diff4);
				
				if(max1<max2)
				{
					max1=max2;
				}

				if(max1>threshold)
				{
					exceed=true;
				}
				if(exceed) 
					output[col] = value;
			}
		}

		return output;	
	}		


	public static void main(String args[]) {

		int image[] = {1,3,4,5,
					   2,4,6,3,
				5,6,7,3,
				8,2,12,52};

		int threshold = 3;

		int [] output = processEdges(image, 4, 4, threshold);
		int i;
		for(i = 0; i < output.length-1; ++i) 
		{
			if(output[i]!=0)
			{
				System.out.print(output[i]+"-->");
			}
		}
		if(output[i]!=0)
			System.out.println(output[i]);
	}
}
