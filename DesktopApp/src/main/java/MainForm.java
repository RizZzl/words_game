import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {

    private JPanel mainPanel;

    private JPanel Jbutton;
    private JButton collapse;
    private JButton expand;

    private JPanel snp;
    private JTextField patronymic;
    private JTextField name;
    private JTextField surname;
    private JLabel LabelPatronymic;
    private JLabel LabelName;
    private JLabel LabelSurname;
    private JLabel response;

    public MainForm() {
        expand.setVisible(false);
        collapse.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.getText().trim().equals("") || surname.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(
                            mainPanel,
                            "Имя или Фамилия не заполнены.\n" + "Попробуйте еще раз.",
                            "Ошибка!",
                            JOptionPane.PLAIN_MESSAGE
                    );
                } else {
                    surname.setVisible(false);
                    name.setVisible(false);
                    patronymic.setVisible(false);
                    LabelPatronymic.setVisible(false);
                    LabelSurname.setVisible(false);
                    LabelName.setVisible(false);

                    response.setVisible(true);
                    response.setText(surname.getText() + " " + name.getText() + " " + patronymic.getText());

                    collapse.setVisible(false);
                    expand.setVisible(true);

                    expand.addActionListener(new Action() {
                        @Override
                        public Object getValue(String key) {
                            return null;
                        }

                        @Override
                        public void putValue(String key, Object value) {

                        }

                        @Override
                        public void setEnabled(boolean b) {

                        }

                        @Override
                        public boolean isEnabled() {
                            return false;
                        }

                        @Override
                        public void addPropertyChangeListener(PropertyChangeListener listener) {

                        }

                        @Override
                        public void removePropertyChangeListener(PropertyChangeListener listener) {

                        }

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String[] SNP = response.getText().split(" ");
                            if (SNP.length < 2) {
                                JOptionPane.showMessageDialog(
                                        mainPanel,
                                        "Имя или Фамилия не заданы.",
                                        "Ошибка!",
                                        JOptionPane.PLAIN_MESSAGE
                                );
                            } else {
                                response.setVisible(false);

                                surname.setVisible(true);
                                name.setVisible(true);
                                patronymic.setVisible(true);
                                LabelPatronymic.setVisible(true);
                                LabelSurname.setVisible(true);
                                LabelName.setVisible(true);

                                surname.setText(SNP[0]);
                                name.setText(SNP[1]);
                                if (!patronymic.getText().trim().equals("")) {
                                    patronymic.setText(SNP[2]);
                                }

                                expand.setVisible(false);
                                collapse.setVisible(true);
                            }
                        }
                    });
                }
            }
        });
    }


    public JPanel getMainPanel() {
        return mainPanel;
    }
}
