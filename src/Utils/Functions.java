package Utils;

public class Functions 
{
    public static double F(double x)
    {
        return x*x;
    }

    public static double Calculate(int a, int b, int n ,int start)
    {
        double H = (double) (b-a)/((n-start)*4);
        double x_i;
        double approx= (F(a)+F(b))/2;
        for(int i=start;i<n;i++)
        {
            x_i = a + i*H;
            approx += F(x_i);
        }
        return approx *= H;
    }
}
