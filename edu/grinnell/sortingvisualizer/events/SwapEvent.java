package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

public class SwapEvent<T> implements SortEvent<T> {
    private int fst;
    private int snd;


    public SwapEvent(int i, int j) {
        fst = i;
        snd = j;
    }

    @Override
    public void apply(T[] arr) {
        T temp = arr[fst];
        arr[fst] = arr[snd];
        arr[snd] = temp;
    }

    @Override
    public List<Integer> getAffectedIndices() {
        // TODO Auto-generated method stub
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(fst);
        ret.add(snd);
        return ret;
    }

    @Override
    public boolean isEmphasized() {
        return true;
    }

}
