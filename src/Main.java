public class Main {

    public static void main(String[] CHAND) {
        Calculator calculator = new Calculator(450, 600);
        calculator.setTitle("计算器");
        calculator.getContentPane().setBackground(Constant.darkGrey);
        calculator.setLocationRelativeTo(null);
        calculator.setVisible(true);
    }

}
