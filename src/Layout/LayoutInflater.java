package Layout;

import Helper.Resource;
import Helper.XMLParser;
import Layout.Component.Button;
import Layout.Component.CheckBox;
import Layout.Component.Frame;
import Layout.Component.Label;
import Layout.Component.TextField;
import org.w3c.dom.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class LayoutInflater {
    private static Map<Integer, View> viewList;

    public static View findViewById(int id) {
        if (null == viewList) {
            viewList = new HashMap<>();
        }
        return viewList.get(id);
    }

    public static void addView(View view) {
        if (null == viewList) {
            viewList = new HashMap<>();
        }
        viewList.put(view.getId(), view);
    }

    public static View inflate(String viewName, View parent) {
        File viewFile = Resource.getResourceFileStream(viewName);
        Element root = XMLParser.getRootElement(viewFile);
        View view = inflate(root);
        return view;
    }

    private static View inflate(Element node) {
        View view = null;
        NamedNodeMap attributes = node.getAttributes();
        switch (node.getTagName()) {
            case "Frame":
                view = inflateFrame(attributes);
                break;
            case "Button":
                view = inflateButton(attributes);
                break;
            case "TextField":
                view = inflateTextField(attributes);
                break;
            case "CheckBox":
                view = inflateCheckBox(attributes);
                break;
            case "Label":
                view = inflateLabel(attributes);
                break;
            default:
                break;
        }
        if (null != view && view.isContainer()) {
            NodeList children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node childNode = children.item(i);
                if (childNode instanceof Element) {
                    View child = inflate((Element) childNode);
                    if (null != child) {
                        view.addChild(child);
                    }
                }
            }
        }
        if (null != view) {
            addView(view);
        }
        return view;
    }

    private static Frame inflateFrame(NamedNodeMap attributes) {
        Frame frame = new Frame();
        int x = 0;
        int y = 0;
        int width = 500;
        int height = 500;
        for (int i = 0; i < attributes.getLength(); i++) {
            Attr attr = (Attr) attributes.item(i);
            switch (attr.getName()) {
                case "id":
                    frame.setId(Integer.parseInt(attr.getValue()));
                    break;
                case "title":
                    frame.setTitle(attr.getValue());
                    break;
                case "positionX":
                    x = Integer.parseInt(attr.getValue());
                    break;
                case "positionY":
                    y = Integer.parseInt(attr.getValue());
                    break;
                case "width":
                    width = Integer.parseInt(attr.getValue());
                    break;
                case "height":
                    height = Integer.parseInt(attr.getValue());
                    break;
                case "backColor":
                    frame.setBackground(Color.decode(attr.getValue()));
                    break;
            }
        }
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocation(x, y);
        frame.setSize(width, height);
        return frame;
    }

    public static Button inflateButton(NamedNodeMap attributes) {
        Button button = new Button();
        int x = 0;
        int y = 0;
        int width = 500;
        int height = 500;
        for (int i = 0; i < attributes.getLength(); i++) {
            Attr attr = (Attr) attributes.item(i);
            switch (attr.getName()) {
                case "id":
                    button.setId(Integer.parseInt(attr.getValue()));
                    break;
                case "text":
                    button.setText(attr.getValue());
                    break;
                case "positionX":
                    x = Integer.parseInt(attr.getValue());
                    break;
                case "positionY":
                    y = Integer.parseInt(attr.getValue());
                    break;
                case "width":
                    width = Integer.parseInt(attr.getValue());
                    break;
                case "height":
                    height = Integer.parseInt(attr.getValue());
                    break;
                case "backColor":
                    button.setBackground(Color.decode(attr.getValue()));
                    break;
                case "fontColor":
                    button.setForeground(Color.decode(attr.getValue()));
                    break;
            }
        }
        button.setLocation(x, y);
        button.setSize(width, height);
        return button;
    }

    public static TextField inflateTextField(NamedNodeMap attributes) {
        TextField textField = new TextField();
        int x = 0;
        int y = 0;
        int width = 500;
        int height = 500;
        for (int i = 0; i < attributes.getLength(); i++) {
            Attr attr = (Attr) attributes.item(i);
            switch (attr.getName()) {
                case "id":
                    textField.setId(Integer.parseInt(attr.getValue()));
                    break;
                case "text":
                    textField.setText(attr.getValue());
                    break;
                case "positionX":
                    x = Integer.parseInt(attr.getValue());
                    break;
                case "positionY":
                    y = Integer.parseInt(attr.getValue());
                    break;
                case "width":
                    width = Integer.parseInt(attr.getValue());
                    break;
                case "height":
                    height = Integer.parseInt(attr.getValue());
                    break;
                case "backColor":
                    textField.setBackground(Color.decode(attr.getValue()));
                    break;
                case "fontColor":
                    textField.setForeground(Color.decode(attr.getValue()));
                    break;
            }
        }
        textField.setSize(width, height);
        textField.setLocation(x, y);
        return textField;
    }

    public static CheckBox inflateCheckBox(NamedNodeMap attributes) {
        CheckBox checkBox = new CheckBox();
        int x = 0;
        int y = 0;
        int width = 500;
        int height = 500;
        for (int i = 0; i < attributes.getLength(); i++) {
            Attr attr = (Attr) attributes.item(i);
            switch (attr.getName()) {
                case "id":
                    checkBox.setId(Integer.parseInt(attr.getValue()));
                    break;
                case "text":
                    checkBox.setText(attr.getValue());
                    break;
                case "positionX":
                    x = Integer.parseInt(attr.getValue());
                    break;
                case "positionY":
                    y = Integer.parseInt(attr.getValue());
                    break;
                case "width":
                    width = Integer.parseInt(attr.getValue());
                    break;
                case "height":
                    height = Integer.parseInt(attr.getValue());
                    break;
                case "checked":
                    boolean checked = Boolean.parseBoolean(attr.getValue());
                    checkBox.setSelected(checked);
                    break;
                case "backColor":
                    checkBox.setBackground(Color.decode(attr.getValue()));
                    break;
                case "fontColor":
                    checkBox.setForeground(Color.decode(attr.getValue()));
                    break;
            }
        }
        checkBox.setLocation(x, y);
        checkBox.setSize(width, height);
        return checkBox;
    }

    public static Layout.Component.Label inflateLabel(NamedNodeMap attributes) {
        Layout.Component.Label label = new Label();
        int x = 0;
        int y = 0;
        int width = 500;
        int height = 500;
        for (int i = 0; i < attributes.getLength(); i++) {
            Attr attr = (Attr) attributes.item(i);
            switch (attr.getName()) {
                case "id":
                    label.setId(Integer.parseInt(attr.getValue()));
                    break;
                case "text":
                    label.setText(attr.getValue());
                    break;
                case "positionX":
                    x = Integer.parseInt(attr.getValue());
                    break;
                case "positionY":
                    y = Integer.parseInt(attr.getValue());
                    break;
                case "width":
                    width = Integer.parseInt(attr.getValue());
                    break;
                case "height":
                    height = Integer.parseInt(attr.getValue());
                    break;
                case "backColor":
                    label.setBackground(Color.decode(attr.getValue()));
                    break;
                case "fontColor":
                    label.setForeground(Color.decode(attr.getValue()));
                    break;
            }
        }
        label.setFont(new Font("Serif", Font.PLAIN, 14));
        label.setForeground(Color.black);
        label.setLocation(x, y);
        label.setSize(width, height);
        label.setVerticalAlignment(SwingConstants.CENTER);
        return label;
    }
}
