package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

public class CompareEvent<T> implements SortEvent<T> {
    private int fst;
    private int snd;

    public CompareEvent(int fst, int snd) {
        this.fst = fst;
        this.snd = snd;
    }

    @SuppressWarnings("hiding")
    @Override
    public void apply (T[] arr) {
        return;
    }

    @Override
    public List<Integer> getAffectedIndices() {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(fst);
        ret.add(snd);
        return ret;
    }

    @Override
    public boolean isEmphasized() {
        return false;
    }

}
