package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

public class CopyEvent<T> implements SortEvent<T> {
    private int i;
    private T temp;

    public CopyEvent(int i, T temp) {
        this.i = i;
        this.temp = temp;
    }

    @Override
    public void apply(T[] arr) {
        arr[i] = (T) temp;
    }

    @Override
    public List<Integer> getAffectedIndices() {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(i);
        return ret;
    }

    @Override
    public boolean isEmphasized() {
        return true;
    }

}
