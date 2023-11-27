package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signupTwo extends JFrame implements ActionListener{
        JTextField pan, aadhar;
        JButton next;
        JRadioButton syes, sno, eyes, eno;
        JComboBox religion, category, income, occupation, education;
        String formno;
        signupTwo(String formno) {
            this.formno = formno;
            setLayout(null);

            setTitle("NEW ACCOUNT FORM - PAGE 2");

            JLabel additionalDetails = new JLabel("Page 2: Additional Details");
            additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
            additionalDetails.setBounds(290, 80, 400, 30);
            add(additionalDetails);

            JLabel religions = new JLabel("Religion: ");
            religions.setFont(new Font("Raleway", Font.BOLD, 20));
            religions.setBounds(100, 140, 100, 30);
            add(religions);

            String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
            religion = new JComboBox(valReligion);
            religion.setBounds(300, 140, 400, 30);
            religion.setBackground(Color.WHITE);
            add(religion);

            JLabel categories = new JLabel("Category: ");
            categories.setFont(new Font("Raleway", Font.BOLD, 20));
            categories.setBounds(100, 190, 200, 30);
            add(categories);

            String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
            category = new JComboBox(valCategory);
            category.setBounds(300, 190, 400, 30);
            category.setBackground(Color.WHITE);
            add(category);

            JLabel earning = new JLabel("Income: ");
            earning.setFont(new Font("Raleway", Font.BOLD, 20));
            earning.setBounds(100, 240, 200, 30);
            add(earning);

            String Incomecategory []= {"NULL","Less then 1.5 Lakhs", "Less then 2.5 Lakhs",
            "Less then 5.00 Lakhs", "Upto 10 Lakhs"};
            income = new JComboBox(Incomecategory);
            income.setBounds(300,240,400,30);
            income.setBackground(Color.WHITE);
            add(income);

            JLabel edu = new JLabel("Educational ");
            edu.setFont(new Font("Raleway", Font.BOLD, 20));
            edu.setBounds(100, 290, 200, 30);
            add(edu);

            JLabel quali = new JLabel("Qualification: ");
            quali.setFont(new Font("Raleway", Font.BOLD, 20));
            quali.setBounds(100, 315, 200, 30);
            add(quali);

            String educationValues []= {"Non Graduate","Graduate", "Post Graduation",
                    "Doctorate", "Other"};
            education = new JComboBox(educationValues);
            education.setBounds(300,315,400,30);
            education.setBackground(Color.WHITE);
            add(education);

            JLabel work = new JLabel("Occupation: ");
            work.setFont(new Font("Raleway", Font.BOLD, 20));
            work.setBounds(100, 390, 200, 30);
            add(work);

            String occupationVal []= {"Salaried","Self-Employed", "Business",
                    "Student", "Retired", "Other"};
            occupation = new JComboBox(occupationVal);
            occupation.setBounds(300,390,400,30);
            occupation.setBackground(Color.WHITE);
            add(occupation);

            JLabel pan_account = new JLabel("PAN Detail: ");
            pan_account.setFont(new Font("Raleway", Font.BOLD, 20));
            pan_account.setBounds(100, 440, 200, 30);
            add(pan_account);

            pan = new JTextField();
            pan.setFont(new Font("Raleway", Font.BOLD, 14));
            pan.setBounds(300, 440, 400, 30);
            add(pan);

            JLabel adhar = new JLabel("Aadhar Number: ");
            adhar.setFont(new Font("Raleway", Font.BOLD, 20));
            adhar.setBounds(100, 490, 200, 30);
            add(adhar);

            aadhar = new JTextField();
            aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
            aadhar.setBounds(300, 490, 400, 30);
            add(aadhar);

            JLabel citizen = new JLabel("Senior Citizen: ");
            citizen.setFont(new Font("Raleway", Font.BOLD, 20));
            citizen.setBounds(100, 540, 200, 30);
            add(citizen);

            syes = new JRadioButton("YES");
            syes.setBounds(300, 540, 100, 30);
            syes.setBackground(Color.WHITE);
            add(syes);

            sno = new JRadioButton("NO");
            sno.setBounds(450, 540, 100, 30);
            sno.setBackground(Color.WHITE);
            add(sno);

            ButtonGroup maritalgroup = new ButtonGroup();
            maritalgroup.add(syes);
            maritalgroup.add(syes);

            JLabel exist_acc = new JLabel("Existing Account: ");
            exist_acc.setFont(new Font("Raleway", Font.BOLD, 20));
            exist_acc.setBounds(100, 590, 200, 30);
            add(exist_acc);

            eyes = new JRadioButton("YES");
            eyes.setBounds(300, 590, 100, 30);
            eyes.setBackground(Color.WHITE);
            add(eyes);

            eno = new JRadioButton("NO");
            eno.setBounds(450, 590, 100, 30);
            eno.setBackground(Color.WHITE);
            add(eno);

            ButtonGroup emaritalgroup = new ButtonGroup();
            emaritalgroup.add(eyes);
            emaritalgroup.add(eno);

            next = new JButton("Next");
            next.setBackground(Color.BLACK);
            next.setForeground(Color.WHITE);
            next.setBounds(620, 660, 80, 30);
            next.addActionListener(this);
            add(next);


            getContentPane().setBackground(Color.WHITE);
            setSize(850, 800);
            setLocation(350, 10);
            setVisible(true);

        }

        public void actionPerformed(ActionEvent ae) {
            String sreligion = (String) religion.getSelectedItem();
            String scategory = (String) category.getSelectedItem();
            String sincome = (String) income.getSelectedItem();
            String seducation = (String) education.getSelectedItem();
            String soccupation = (String) occupation.getSelectedItem();

            String seniorcitizen = null;
            if (syes.isSelected()) {
                seniorcitizen = "YES";
            } else if (sno.isSelected()) {
                seniorcitizen = "NO";
            }
            String existingaccount = null;
            if (eyes.isSelected()) {
                existingaccount = "YES";
            } else if (eno.isSelected()) {
                existingaccount = "NO";
            }

            String span = pan.getText();
            String saadhar = aadhar.getText();

            try {
                Conn c = new Conn();
                String query = "insert into signuptwo values('" + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "'," +
                        "'" + seducation + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + seniorcitizen + "', '" + existingaccount + "')";
                c.s.executeUpdate(query);

                // signup three object
                setVisible(false);
                new signupThree(formno).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void main(String[] args) {

            new signupTwo("");
        }
    }