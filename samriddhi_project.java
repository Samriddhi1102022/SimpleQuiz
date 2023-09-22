import java.awt.*;
import java.awt.event.*;

public class samriddhi_project extends Frame implements ActionListener {
    private Label questionLabel;
    private CheckboxGroup optionsGroup;
    private Checkbox optionA, optionB, optionC, optionD;
    private Button nextButton;
    private Button exitButton;
    private int currentQuestion;
    private int score;

    private String[] questions = {
        "1. What is the capital city of India?",
        "2. Which river is considered the holiest river in India?",
        "3. Who was the first Prime Minister of India?",
        "4. Which city is known as the 'Pink City'?",
        "5. What is the national animal of India?",
        "6. Which famous monument is located in Agra, India?",
        "7. Which Indian state is known as the 'Land of the Gods'?",
        "8. Which is the highest mountain peak in India?",
        "9. Who wrote the national anthem of India?",
        "10. Which festival is known as the 'Festival of Lights' in India?"
    };

    private String[][] options = {
        {"Delhi", "Lucknow", "Noida", "Chandigarh"},
        {"Brahmaputra", "Indus", "Ganga", "Yamuna"},
        {"Gulzarilal Nanda", "Morarji Desai", "Narendra Modi", "Jawaharlal Nehru"},
        {"Udaipur", "Jaipur", "Jodhpur", "Alwar"},
        {"Tiger", "Elephant", "Leopard", "Deer"},
        {"Charminar", "Ajanta Caves", "Vijay Stambh", "Taj Mahal"},
        {"Uttar Pradesh", "Jammu & Kashmir", "Uttarakhand", "Maharashtra"},
        {"Mount Everest", "Kangchenjunga", "Anamudi", "Nanda Devi"},
        {"Rabindranath Tagore", "Sarojini Naidu", "Sri Aurobindo", "Bankim Chandra Chatterji"},
        {"Holi", "Diwali", "Raksha Bandhan", "Makar Sankranti"}
    };

    private int[] correctAnswers = {0, 2, 3, 1, 0, 3, 2, 1, 0, 1}; 

    public samriddhi_project() {
        setLayout(new GridBagLayout());
        setSize(1000, 800);
        setTitle("Quiz Game");

        // Set background color
        setBackground(new Color(0, 0, 90));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Question Label
        questionLabel = new Label(questions[0]);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        questionLabel.setForeground(Color.WHITE); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(questionLabel, gbc);

        // Options
        optionsGroup = new CheckboxGroup();
        optionA = new Checkbox(options[0][0], optionsGroup, false);
        optionA.setFont(new Font("Arial", Font.PLAIN, 16));
        optionA.setForeground(Color.WHITE); 
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(optionA, gbc);

        optionB = new Checkbox(options[0][1], optionsGroup, false);
        optionB.setFont(new Font("Arial", Font.PLAIN, 16));
        optionB.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(optionB, gbc);

        optionC = new Checkbox(options[0][2], optionsGroup, false);
        optionC.setFont(new Font("Arial", Font.PLAIN, 16));
        optionC.setForeground(Color.WHITE); 
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        add(optionC, gbc);

        optionD = new Checkbox(options[0][3], optionsGroup, false);
        optionD.setFont(new Font("Arial", Font.PLAIN, 16));
        optionD.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        add(optionD, gbc);

        // Next Button
        nextButton = new Button("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        nextButton.addActionListener(this);
        add(nextButton, gbc);

        currentQuestion = 0;
        score = 0;

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        samriddhi_project quizGame = new samriddhi_project();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (optionsGroup.getSelectedCheckbox() != null) {
            int selectedOptionIndex = optionsGroup.getSelectedCheckbox().getLabel().equals(options[currentQuestion][correctAnswers[currentQuestion]]) ? 1 : 0;
            score += selectedOptionIndex;

            optionsGroup.setSelectedCheckbox(null);
            currentQuestion++;

            if (currentQuestion < questions.length) {
                questionLabel.setText(questions[currentQuestion]);
                optionA.setLabel(options[currentQuestion][0]);
                optionB.setLabel(options[currentQuestion][1]);
                optionC.setLabel(options[currentQuestion][2]);
                optionD.setLabel(options[currentQuestion][3]);
            } else {
                remove(questionLabel);
                remove(optionA);
                remove(optionB);
                remove(optionC);
                remove(optionD);
                remove(nextButton);

                Label scoreLabel = new Label("Your Score: " + score + "/" + questions.length);
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);
                gbc.gridx = 0;
                gbc.gridy = 0;
                scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
                scoreLabel.setForeground(Color.WHITE); 
                add(scoreLabel, gbc);

                exitButton = new Button("Exit");
                exitButton.setFont(new Font("Arial", Font.BOLD, 20));
                gbc.gridx = 0;
                gbc.gridy = 3;
                gbc.gridwidth = 2;
                exitButton.addActionListener(this);
                add(exitButton, gbc);
            }

            validate();
            repaint();
        } else if (e.getSource() == exitButton) {
            dispose();
        }
    }
}