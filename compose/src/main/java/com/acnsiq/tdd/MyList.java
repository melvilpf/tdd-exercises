package com.acnsiq.tdd;

/*
 * Based on example in "Refactoring to Patterns"
 * by Joshua Kerievsky
 *
 * See https://www.industriallogic.com/xp/refactoring/composeMethod.html
 */

public class MyList {
    private Object[] elements = new Object[10];
    private int size;
    private boolean readOnly;

    public void add(Object element) throws Exception {
        if (readOnly) throw new Exception("This list is read-only");
        int newSize = size + 1;
        if (elements.length < newSize) {
            Object[] newElements = new Object[elements.length + 10];
            if (size >= 0) System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
        elements[size] = element;
        size++;
    }

    public void addRange(Object... elements) throws Exception {
        if (readOnly) throw new Exception("This list is read-only");
        int newSize = size + elements.length;
        if (this.elements.length < newSize) {
            // We increase the size by 10 times the number of times we fill the list while adding those
            int tensIncreases = (newSize - size) / 10;
            Object[] newElements = new Object[this.elements.length + 10 * tensIncreases];
            if (size >= 0) System.arraycopy(this.elements, 0, newElements, 0, size);
            this.elements = newElements;
        }
        for (Object element : elements) {
            this.elements[size] = element;
            size++;
        }
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return elements.length;
    }

    public Object[] getElements() {
        return elements;
    }
}
