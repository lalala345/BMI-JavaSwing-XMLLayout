package Layout.Component;

import Layout.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Frame extends JFrame implements View {
    private Map<Integer, View> childList;
    private int id;

    public Frame() {
        this.childList = new HashMap<>();
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean isContainer() {
        return true;
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
    }

    @Override
    public void addChild(View child) {
        this.add(child.getComponent());
        this.childList.put(child.getId(), child);
    }

    @Override
    public Component getComponent() {
        return this;
    }
}
