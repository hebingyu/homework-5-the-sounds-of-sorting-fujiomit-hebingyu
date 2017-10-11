package edu.grinnell.sortingvisualizer.audio;

import java.util.Arrays;
import java.util.Collections;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
    private Integer[] note;
    private Boolean[] highlight;

    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        this.note = new Integer[n];
        this.highlight = new Boolean[n];
        for (int i = 0; i < n; i++) {
            note[i]=i;
            highlight[i]=false;
        }
    }

    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size.  The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        this.note = new Integer[n];
        this.highlight = new Boolean[n];
        for (int i = 0; i < n; i++) {
            this.note[i]=i;
            highlight[i]=false;
        }

        Collections.shuffle(Arrays.asList(this.note));
    }

    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() {   		
        return note;
    }

    /**
     * Highlights the given index of the note array
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        this.highlight[index]=true;
    }

    /** @return true if the given index is highlighted */
    public boolean isHighlighted(int index) {
        if(this.highlight[index]) {
            return true;
        }
        return false;
    }

    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
        for (int i = 0; i < highlight.length; i++) {
            highlight[i]=false;
        }
    }
}
