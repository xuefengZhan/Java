public class HeapSpaceInitial {
    public static void main(String[] args) {
        // 返回 Java 虚拟机中的堆内存总量
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        // 返回 Java 虚拟机试图使用的最大内存总量
        long maxMemory  = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("-Xms: " + initialMemory + "M");        //-Xms: 243M
        System.out.println("-Xmx: " + maxMemory + "M");           //-Xmx: 3604M

        System.out.println("系统内存大小为：" + initialMemory * 64.0 / 1024 + "G");   //系统内存大小为：15.1875G
        System.out.println("系统内存大小为：" + maxMemory * 4.0 / 1024 + "G");        //系统内存大小为：14.078125G

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}