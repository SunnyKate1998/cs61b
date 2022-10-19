package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

import java.sql.Time;

/**
 * Created by hug.
 */
public class TimeAList {
    private static AList<Integer> Ns;
    private static AList<Double> times;
    private static AList<Integer> opCounts;

    public TimeAList(){
        this.Ns = new AList<>();
        this.times = new AList<>();
        this.opCounts = new AList<>();
    }

    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        TimeAList ta = new TimeAList();
        timeAListConstruction();
        printTimingTable(Ns, times, opCounts);
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        int N = 1000;
        while (N <= 128000)
        {
            timeAListConstructionWithN(N);
            N *= 2;
        }
    }

    public static void timeAListConstructionWithN(int N) {
        Stopwatch sw = new Stopwatch();
        AList<Integer> al = new AList<>();

        for (int i = 0; i < N; i++) al.addLast(i);
        double timeInSeconds = sw.elapsedTime();

        Ns.addLast(N);
        times.addLast(timeInSeconds);
        opCounts.addLast(N);
    }
}
