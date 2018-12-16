package com.suvorov.task5;

public class Starter {
    public static void main(String[] args) {
        String[] resources = new String[]{"Slash", "Duff", "Axl", "Izzy", "Ozzy"};
        ResourcePool<String> pool = new ResourcePool(resources, resources.length);
        for (int i = 0; i < 10; i++) {
            new MyThread(pool, 3).start();
        }
    }
}
