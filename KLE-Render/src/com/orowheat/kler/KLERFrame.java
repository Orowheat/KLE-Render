package com.orowheat.kler;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class KLERFrame extends JFrame implements ActionListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel statMessage;
	JTextArea editArea;
	public KLERFrame(String title){
		super(title);
        //create textarea pane
        JPanel textPane = new JPanel();
        textPane.setBorder(new EmptyBorder(0,3,0,3));
        editArea = new JTextArea(5,40);
        editArea.addMouseListener(this);
        // adjust the font to a monospaced font.
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, editArea.getFont().getSize());
        editArea.setFont(font);
        textPane.add(new JScrollPane(editArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
        //create status message pane
        JPanel statusPane=new JPanel();
        statusPane.setLayout(new BoxLayout(statusPane,BoxLayout.PAGE_AXIS));
        statusPane.setBorder(new EmptyBorder(4,10,0,3));
        statMessage=new JLabel("Paste KLE Raw data below");
        statMessage.setAlignmentX(0);
        statusPane.add(statMessage);
        //create button pane and buttons
        JButton createButton=new JButton("Create");
        createButton.addActionListener(this);
        createButton.setAlignmentX(RIGHT_ALIGNMENT);
        getRootPane().setDefaultButton(createButton);
        JPanel buttonPane=new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,BoxLayout.PAGE_AXIS));
        buttonPane.setBorder(new EmptyBorder(0,3,2,7));
        buttonPane.add(createButton);
        this.add(statusPane,BorderLayout.PAGE_START);
        this.add(textPane,BorderLayout.CENTER);
        this.add(buttonPane,BorderLayout.PAGE_END);
        this.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!editArea.getText().equals("")&&"Create".equals(e.getActionCommand())){
			try {
				KLERCore.main(editArea, statMessage);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		else{
			statMessage.setText("Paste KLE Raw data below");
		}
	}
	public void mousePressed(MouseEvent e) {
		statMessage.setText("Paste KLE Raw data below");
    }

	@Override
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
