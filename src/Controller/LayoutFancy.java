package Controller;

import Layout.Component.Button;
import Layout.Component.Frame;
import Layout.Component.TextField;
import Layout.LayoutInflater;
import Layout.View;
import org.omg.CORBA.Environment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LayoutFancy implements ActionListener {
    Frame mainFrame;
    private TextField txtName;
    private TextField txtWidth;
    private TextField txtHeight;
    private Button btnCheck;

    public static void main(String[] args) {
        new LayoutFancy();
    }

    public LayoutFancy() {
        mainFrame = (Frame) LayoutInflater.inflate("Form1", null);
        mainFrame.setVisible(true);

        txtName = (TextField) LayoutInflater.findViewById(3);
        txtWidth = (TextField) LayoutInflater.findViewById(5);
        txtHeight = (TextField) LayoutInflater.findViewById(7);
        btnCheck = (Button) LayoutInflater.findViewById(8);

        btnCheck.setOnClickListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int BMIType = caculateBMI(txtWidth.getText(), txtHeight.getText());
        if (BMIType == 0) {
            JOptionPane.showMessageDialog(mainFrame, "Check data again");
        } else {
            reportBMI(BMIType);
        }
    }
    
    public int caculateBMI(String Width, String Height) {
        System.err.println(Width+ "&"+Height);
        int BMIType = 0;
        try {
            Double width = Double.parseDouble(Width);
            Double height = Double.parseDouble(Height);
            Double heightByMiles = height*0.01;
            Double BMI = width/(heightByMiles*heightByMiles);
            System.out.println("BMI: "+ BMI);
            if (BMI<18.5) {
                BMIType = 1;
            } else if (BMI>=18.5&&BMI<25) {
                BMIType = 2;
            } else if (BMI>=25&&BMI<30) {
                BMIType = 3;
            } else if (BMI>=30&&BMI<35) {
                BMIType = 4;
            } else if (BMI>=35&&BMI<40) {
                BMIType = 5;
            } else {
                BMIType = 6;
            }
        } catch (Exception e) {
            System.err.println("err: " + e);
        }
        return BMIType;
    }
    
    public void reportBMI(int type) {
        StringBuffer info = new StringBuffer("BMI Report:").append("\r\n")
                .append("Name: ").append(txtName.getText()).append("\r\n")
                .append("Width: ").append(txtWidth.getText()).append("\r\n")
                .append("Height: ").append(txtHeight.getText()).append("\r\n")
                .append("================").append("\r\n");
        switch (type) {
            case 1:
                info.append("Underweight");
                break;
            case 2:
                info.append("Normal");
                break;
            case 3:
                info.append("Overweight");
                break;
            case 4:
                info.append("Obesity Class 1");
                break;
            case 5:
                info.append("Obesity Class 2");
                break;
            case 6:
                info.append("Obesity Class 3");
                break;
        }
        JOptionPane.showMessageDialog(mainFrame, info.toString());
    }
}
