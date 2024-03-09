import mpi.*;
import Utils.*;

public class App {
    public static void main(String[] args) throws Exception 
    {
        int n=100000; //change this for testing different values of n
        int a=0; int b=1;
        long starttime = System.nanoTime();
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int workload = (rank+1)*(n/4);
        int start = (rank)*(n/4);

        double Result = Functions.Calculate(a, b, workload, start);

        double[] Sbuf = new double[1]; double[] Rbuf = new double[1];
        Sbuf[0] = Result;
        MPI.COMM_WORLD.Reduce(Sbuf, 0, Rbuf, 0, 1, MPI.DOUBLE, MPI.SUM, 0);


        if (rank==0)
        {
            System.out.println("Final Result: " + Rbuf[0] + "\ntime taken: " + (System.nanoTime()-starttime)/1000000 + " ms at n =" + n);
        }

        MPI.Finalize();
    }
}
