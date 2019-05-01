public class SimulateJavaOOM
{
    public static java.util.List<byte[]> holder = new java.util.ArrayList<byte[]>();

    public static void main(String... args) throws Throwable
    {
        int size = Integer.getInteger("size", 1048576);
        int iterations = Integer.getInteger("iterations", 10000);
        int waitTime = Integer.getInteger("waitTime", 1000);
        int oomlimit = Integer.getInteger("oomlimit", 1);

        int oomcount = 0;

        System.out.println("[" + new java.util.Date() + "] " + "Starting " + iterations + " iterations of " + size
                        + " byte allocations with " + waitTime + "ms delay...");

        for (int i = 1; i <= iterations; i++)
        {
            try
            {
                System.out.print("[" + new java.util.Date() + "] " + "Iteration " + i + ": Allocating byte array of "
                                + size + " bytes [" + holder.size() + "] ... ");
                byte[] data = new byte[size];
                holder.add(data);
                System.out.println("[" + new java.util.Date() + "] " + "allocation complete of " + data.length
                                + " bytes.");

                if (waitTime > 0)
                {
                    try
                    {
                        Thread.sleep(waitTime);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                        System.out.println("[" + new java.util.Date() + "] " + "Interrupted in Thread.sleep");
                        break;
                    }
                }
            }
            catch (OutOfMemoryError oom)
            {
                oom.printStackTrace();
                System.out.println("[" + new java.util.Date() + "] " + "Caught OOM");
                oomcount++;
                if (oomlimit > 0 && oomcount >= oomlimit)
                {
                    break;
                }
            }
        }
        System.out.println("[" + new java.util.Date() + "] " + "Program finished");
    }
}
