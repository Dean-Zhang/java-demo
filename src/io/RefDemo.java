package io;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class RefDemo {
    public static void main(String[] args) throws InterruptedException {
        List<String> l = new ArrayList<>();
        l.add("d");
        ReferenceQueue queue = new ReferenceQueue();
        WeakReference ref = new WeakReference(l, queue);
        System.out.println(ref.get());
        System.out.println(queue.poll());
        l = null;
        System.gc();
        while (true) {
            Thread.sleep(3000);
            System.out.println(ref.get());
            System.out.println(queue.poll());
        }
    }
}
