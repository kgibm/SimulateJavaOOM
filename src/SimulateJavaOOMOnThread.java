import java.util.ArrayList;
import java.util.List;

public class SimulateJavaOOMOnThread
{
    public static void main(String[] args)
    {
        System.out.println("Started");

        new SimulateJavaOOMOnThread().play(args[0], args[1]);

        System.out.println("Finished");
    }

    public void play(String bytesRequestedStr, String iterationsStr)
    {
        int bytesRequested = Integer.parseInt(bytesRequestedStr);
        int iterations = Integer.parseInt(iterationsStr);
        List<byte[]> list = new ArrayList<byte[]>();
        for (int i = 0; i < iterations; i++)
        {
            byte[] data = new byte[bytesRequested];
            list.add(data);
            System.out.println("Iteration " + (i + 1) + ": Allocated byte[] @ " + data + " of size " + bytesRequested);
        }
    }
}
