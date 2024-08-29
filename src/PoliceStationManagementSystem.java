import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;


public class PoliceStationManagementSystem extends JFrame implements ActionListener {
    // Declare UI components here
    JLabel labelName, labelAddress, labelPhoneNumber, labelComplain, labelLocation, labelDateTime;
    JTextField textName, textAddress, textPhoneNumber, textComplain, textLocation, textDateTime;
    JButton buttonAdd, buttonSearch, buttonDelete, buttonDisplay;

    // Declare linklist and queue here
    static LinkList list = new LinkList();
    static Stack queue = new Stack();

    public PoliceStationManagementSystem() {
        // Initialize UI components here
        labelName = new JLabel("Name:");
        labelAddress = new JLabel("Address:");
        labelPhoneNumber = new JLabel("Phone Number:");
        labelComplain = new JLabel("Complain:");
        labelLocation = new JLabel("Location:");
        labelDateTime = new JLabel("Date and Time:");

        textName = new JTextField();
        textAddress = new JTextField();
        textPhoneNumber = new JTextField();
        textComplain = new JTextField();
        textLocation = new JTextField();
        textDateTime = new JTextField();

        buttonAdd = new JButton("Add Complaint");
        buttonSearch = new JButton("Search Complaint");
        buttonDelete = new JButton("Delete Complaint");
        buttonDisplay = new JButton("Display Complaints");

        // Add action listeners for buttons
        buttonAdd.addActionListener(this);
        buttonSearch.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonDisplay.addActionListener(this);

        // Set layout and add components to the frame
        setLayout(new GridLayout(10, 2));
        add(labelName);
        add(textName);
        add(labelAddress);
        add(textAddress);
        add(labelPhoneNumber);
        add(textPhoneNumber);
        add(labelComplain);
        add(textComplain);
        add(labelLocation);
        add(textLocation);
        add(labelDateTime);
        add(textDateTime);
        add(buttonAdd);
        add(buttonSearch);
        add(buttonDelete);
        add(buttonDisplay);
        
        // Set background and foreground colors
        getContentPane().setBackground(new Color(135, 206, 235));
         
        setTitle("Police Station Management System");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAdd) {
            // Add complaint to linklist and queue
            try {
                String name = textName.getText();
                String address = textAddress.getText();
                String phoneNumber = textPhoneNumber.getText();
                String complain = textComplain.getText();
                String location = textLocation.getText();
                String dateTime = textDateTime.getText();

                Complaint c = new Complaint(name, address, phoneNumber, complain, location, dateTime);
                list.add(c);
                queue.push(c);
                JOptionPane.showMessageDialog(this, "Successfully Added.");
                // Clear input fields
                textName.setText("");
                textAddress.setText("");
                textPhoneNumber.setText("");
                textComplain.setText("");
                textLocation.setText("");
                textDateTime.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error adding complaint: " + ex.getMessage());
                }
                } else if (e.getSource() == buttonSearch) {
                // Search for complaint by name in linklist
                try {
                String name = textName.getText();
                Complaint c = list.search(name);
                if (c != null) {
                    JOptionPane.showMessageDialog(this, "Complaint found: " + c.toString());
                } else {
                    JOptionPane.showMessageDialog(this, "Complaint not found.");
                }
                } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error searching for complaint: " + ex.getMessage());
                }
                } else if (e.getSource() == buttonDelete) {
                // Delete complaint by name from linklist and queue
                try {
                String name = textName.getText();
                list.delete(name);
                queue.pop(name);
                JOptionPane.showMessageDialog(this, "Successfully deleted.");
                } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error deleting complaint: " + ex.getMessage());
                }
                } else if (e.getSource() == buttonDisplay) {
                // Display all complaints in separate screen arranged in columns
                try {
                String data = "";
                data += String.format("%-15s %-15s %-15s %-15s %-15s %-15s\n", "Name", "Address", "Phone Number", "Complain", "Location", "Date and Time");
                for (int i = 0; i < list.size(); i++) {
                Complaint c = list.get(i);
                data += String.format("%-15s %-15s %-15s %-15s %-15s %-15s\n", c.getName(), c.getAddress(), c.getPhoneNumber(), c.getComplain(), c.getLocation(), c.getDateTime());
                }
                JOptionPane.showMessageDialog(this, data);
                } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error displaying complaints: " + ex.getMessage());
                }
        }
    }

    public static void main(String[] args) {
    
    new PoliceStationManagementSystem();
    new LoginScreen();
    }
}
