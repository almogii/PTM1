package test;
public class StatLib {



	public static float avg(float[] x) {
		float sum = 0;
		for (float number:x)
		{
			sum += number;
		}
		return (sum / x.length);
	}

	// returns the variance of X and Y
	public static float var(float[] x) {
		float sum = avg(x);
		float variance = 0;
		for (int i = 0; i < x.length; i++) { //takes a varuble and multiplay by itself using pow and divie in 2
			variance += Math.pow(x[i] - sum, 2);
		}
		variance = variance / x.length;
		return variance;
	}

	// returns the covariance of X and Y
	public static float cov(float[] x, float[] y)//find the AVG of x and y
	{
		float avgX = avg(x);
		float avgY = avg(y);
		float count = 0;
		for( int i = 0 ; i < x.length ; i++)//for each x and y arr value subtract the ave and multiply x and y
			count += ((x[i]-avgX)*(y[i]-avgY));

		return (count/x.length);
	}

	// returns the Pearson correlation coefficient of X and Y
	public static float pearson(float[] x, float[] y) {
		float var1 = (float) Math.sqrt(var(x));
		float var2 = (float) Math.sqrt(var(y));
		float sum = var1 * var2;
		return cov(x, y) / sum;
	}

	// performs a linear regression and returns the line equation
	public static Line linear_reg(Point[] points) {

		float arr_x[] = new float[points.length];
		float arr_y[] = new float[points.length];

		for (int i = 0; i < points.length; i++) {
			arr_x[i] = points[i].x;
			arr_y[i] = points[i].y;
		}
		float a = cov(arr_x,arr_y)/var(arr_x);
		float b = avg(arr_y) -( a * avg(arr_x));
		Line B = new Line(a, b);
		int aaaa = 5;
		return B;
	}

	// returns the deviation between point p and the line equation of the points
	public static float dev(Point p, Point[] points) {
		Line line =  linear_reg(points);
		float y = line.f(p.x);
		return Math.abs(p.y - y);
	}

	// returns the deviation between point p and the line
	public static float dev(Point p, Line l) {
		float y= l.f(p.x);
		return Math.abs(p.y - y);
	}
	}
