import javax.swing.*;
import java.awt.*;

class ScrollablePanel extends JPanel implements Scrollable {
    private int cardQuantity;
    private int cardWidth;
    private int cardHeight;
    private int verticalGap;
    private int horizontalGap;

    ScrollablePanel(int cardQuantity, int cardWidth, int cardHeight, int verticalGap, int horizontalGap) {
        this.cardQuantity = cardQuantity;
        this.cardWidth = cardWidth;
        this.cardHeight = cardHeight;
        this.verticalGap = verticalGap;
        this.horizontalGap = horizontalGap;
    }

    public Dimension getPreferredSize() {
        return getPreferredScrollableViewportSize();
    }

    public Dimension getPreferredScrollableViewportSize() {
        if (getParent() == null)
            return getSize();
        Dimension d = getParent().getSize();
        int width = d.width;
        if (width == 0){
            width = 800;
        }
        int columns = (int) Math.floor((width-horizontalGap)/(horizontalGap+cardWidth));
        int rows = (int) Math.ceil(cardQuantity/columns);
        return new Dimension(d.width, verticalGap+rows*(verticalGap+cardHeight));
    }

    public int getScrollableBlockIncrement(Rectangle visibleRect,
                                           int orientation, int direction) {
        return 50;
    }

    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation,
                                          int direction) {
        return 10;
    }

    public boolean getScrollableTracksViewportHeight() {
        return false;
    }

    public boolean getScrollableTracksViewportWidth() {
        return getParent() == null || getParent().getSize().width > getPreferredSize().width;
    }
}