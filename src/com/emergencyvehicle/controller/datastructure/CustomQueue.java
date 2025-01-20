package com.emergencyvehicle.controller.datastructure;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Prayash Rawal 
 * LMU ID: 23056551
 * 
 * CustomQueue class for implementing a queue data structure using LinkedList.
 */
public class CustomQueue<T> implements Iterable<T> {

    private LinkedList<T> queue = new LinkedList<>(); // Internal storage for the queue.

    /**
     * Adds an item to the end of the queue.
     *
     * @param item the item to be added to the queue.
     */
    public void enqueue(T item) {
        queue.addLast(item);
    }

    /**
     * Removes and returns the first item from the queue.
     *
     * @return the first item in the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    public T dequeue() {
        if (!queue.isEmpty()) {
            return queue.removeFirst();
        } else {
            throw new IllegalStateException("Queue is empty");
        }
    }

    /**
     * Retrieves, but does not remove, the first item of the queue.
     *
     * @return the first item in the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    public T peek() {
        if (!queue.isEmpty()) {
            return queue.getFirst();
        } else {
            throw new IllegalStateException("Queue is empty");
        }
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Returns the size of the queue.
     *
     * @return the number of items in the queue.
     */
    public int size() {
        return queue.size();
    }

    /**
     * Retrieves and removes the head of the queue, or returns null if the queue is empty.
     *
     * @return the head of the queue, or null if the queue is empty.
     */
    public T poll() {
        return queue.poll();
    }

    /**
     * Returns an iterator over elements of type T.
     *
     * @return an iterator over the queue.
     */
    @Override
    public Iterator<T> iterator() {
        return queue.iterator();
    }
}