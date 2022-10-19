package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static AList<Integer> Ns;
    private static AList<Double> times;
    private static AList<Integer> opCounts;

    public TimeSLList(){
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
        TimeSLList tl = new TimeSLList();
        timeGetLast();
        printTimingTable(Ns, times, opCounts);
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        for (int N = 1000; N <= 128000; N *= 2) timeGetLastWithN(N);
    }

    public static void timeGetLastWithN(int N) {
        SLList<Integer> sl = new SLList<>();
        for (int i = 0; i < N; i++) sl.addLast(i);

        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < 10000; i++) sl.getLast();
        double timeInSeconds = sw.elapsedTime();

        Ns.addLast(N);
        times.addLast(timeInSeconds);
        opCounts.addLast(10000);
    }

}
