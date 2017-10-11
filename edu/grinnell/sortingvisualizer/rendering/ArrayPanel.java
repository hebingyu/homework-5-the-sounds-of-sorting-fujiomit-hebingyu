package edu.grinnell.sortingvisualizer.rendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import edu.grinnell.sortingvisualizer.audio.NoteIndices;

@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {

    private NoteIndices notes;
    private int width;
    private int height;

    /**
     * Constructs a new ArrayPanel that renders the given note indices to
     * the screen.
     * @param notes the indices to render
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);

        for (int i = 0; i < notes.getNotes().length; i++) {
            if (notes.isHighlighted(i)) {
                g.setColor(new Color(164,226,244));
            } else {
                int green = 250 - (150 / notes.getNotes().length) * (notes.getNotes()[i] + 1);
                int blue = (255 / notes.getNotes().length) * (notes.getNotes()[i] + 1);

                g.setColor(new Color(240, green, blue));
            }
            int w = width / notes.getNotes().length;
            int h = (height / notes.getNotes().length) * (notes.getNotes()[i] + 1);
            int x = (width / notes.getNotes().length) * i;
            int y = height - h;
            g.fillRect(x, y, w, h);
        }
    }
}