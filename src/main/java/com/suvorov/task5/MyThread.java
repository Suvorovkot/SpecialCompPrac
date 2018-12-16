package com.suvorov.task5;

import java.util.List;

public class MyThread extends Thread {
    ResourcePool<String> resource;
    private int numberOfRes;

    public MyThread(ResourcePool<String> resource, int numberOfRes) {
        this.resource = resource;
        this.numberOfRes = numberOfRes;
    }

    public void run() {
        if (numberOfRes > resource.getSize()) {
            System.out.printf("%s not started... \n There are not enough resources\n", Thread.currentThread().getName());
            return;
        }
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        List<String> freeResource = this.resource.getResource(this.numberOfRes);
        try {
            Thread.sleep((long) (Math.random() * 500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.resource.freeResources(freeResource);
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}