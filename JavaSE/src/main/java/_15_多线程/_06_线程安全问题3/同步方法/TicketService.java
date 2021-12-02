package _15_多线程._06_线程安全问题3.同步方法;

import java.util.ArrayList;

public class TicketService {
    private ArrayList<String> list;
    public TicketService(){
        list = new ArrayList<String>();
        list.add("01车01A");
        list.add("01车01B");
        list.add("01车01C");
        list.add("01车01D");
        list.add("01车01E");
        list.add("01车02A");
        list.add("01车02B");
        list.add("01车02C");
        list.add("01车02D");
        list.add("01车02E");
    }
    public synchronized boolean hasTicket(){
        return list.size()>0;
    }

    public synchronized String buy(){
        try {
            return list.remove(0);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("票卖超了");
        }
    }
}