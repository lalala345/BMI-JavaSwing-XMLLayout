package Layout.Component;

import Layout.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TextField extends JTextField implements View {
    private int id;

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

    }

    @Override
    public Component getComponent() {
        return this;
    }

    public void setOnClickListener(ActionListener listener) {
        this.addActionListener(listener);
    }
}
