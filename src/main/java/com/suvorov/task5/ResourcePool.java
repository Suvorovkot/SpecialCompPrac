package com.suvorov.task5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ResourcePool<T> {
    private Stack<T> resource;
    private int size;


    public ResourcePool(T[] resource, int size) {
        this.size = size;
        this.resource = new Stack<>();
        Arrays.stream(resource).forEach(res -> this.resource.push(res));
    }

    public synchronized List<T> getResource(int count) {
        List<T> resource = new LinkedList<>();
        while (this.resource.size() < count) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < count; i++) resource.add(this.resource.pop());

        return resource;
    }

    public synchronized void freeResources(List<T> freeResource) {
        for (T comm : freeResource) resource.push(comm);
        notifyAll();
    }

    public int getSize() {
        return size;
    }

}