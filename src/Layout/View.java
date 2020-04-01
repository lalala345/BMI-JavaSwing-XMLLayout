package Layout;

import java.awt.*;
import java.awt.event.ActionListener;

public interface View {
    public int getId();
    public void setId(int id);
    public boolean isContainer();
    public void setLocation(int x, int y);
    public void setSize(int width, int height);
    public void addChild(View child);
    public Component getComponent();
}
