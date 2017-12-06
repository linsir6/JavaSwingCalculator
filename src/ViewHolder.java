import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ViewHolder extends JButton {
    String type;//按键类型
    String pureName;//方法名字
    String screenText;//在屏幕上显示的文字

    private ViewHolder(String type, String pureName, String buttonText, String screenText) {
        super(buttonText);
        this.type = type;
        this.pureName = pureName;
        this.screenText = screenText;
    }

    public String toString() {
        return "{type: " + this.type + ", pureName: " + this.pureName + ", button:" + this.getText() + ", screenText: " + this.screenText + "}";
    }

    public boolean isOperator() {
        return this.type.equalsIgnoreCase("operator");
    }

    static Map<String, ViewHolder> getAll() {
        Map<String, ViewHolder> map = new HashMap<String, ViewHolder>();
        for (int i = 0; i <= 9; i++) {
            map.put("" + i, new ViewHolder("numeric", "" + i, "" + i, "" + i));
        }
        //operators keys
        map.put("add", new ViewHolder("operator", "add", "+", "+"));
        map.put("sub", new ViewHolder("operator", "subtract", "\u02D7", "\u02D7"));
        map.put("mul", new ViewHolder("operator", "multiply", "\u00D7", "\u00D7"));
        map.put("div", new ViewHolder("operator", "divide", "\u00F7", "\u00F7"));
        map.put("mod", new ViewHolder("operator", "mod", "MOD", "MOD"));
        //Answer keys
        map.put("equal", new ViewHolder("answer", "equal", "=", "="));
        //number modifier keys
        map.put("point", new ViewHolder("number_modifier", "point", ".", "."));
        //Command keys
        map.put("delete", new ViewHolder("command", "delete", "DE", ""));
        map.put("clear", new ViewHolder("command", "clear", "C", ""));
        map.put("exit", new ViewHolder("command", "exit", "EXIT", ""));

        //Percent keys
        map.put("percent", new ViewHolder("percent", "percent", "%", "%"));

        //signed keys
        //map.put("plus_minus", new ViewHolder("signed", "plus_minus", "\u00B1", "\u00B1"));

        //----------Single operator keys---------------
        map.put("one_by_n", new ViewHolder("single_operator", "one_by_n", "1/n", "1/n"));
        map.put("square", new ViewHolder("single_operator", "square", "x\u00B2", "x\u00B2"));
        map.put("cube", new ViewHolder("single_operator", "cube", "x\u00B3", "x\u00B3"));
        map.put("sqrt", new ViewHolder("single_operator", "square_root", "\u221A", "\u221A"));
        String[] strings = {"sin", "cos", "tan", "asin", "acos", "atan", "sinh", "cosh", "tanh", "ln", "log"};
        map.put("ten_power", new ViewHolder("single_operator", "ten_power", "10^n", "10^n"));
        map.put("abs", new ViewHolder("single_operator", "absolute", "abs", "abs"));
        for (String text : strings) {
            map.put(text, new ViewHolder("single_operator", text, text, text));
        }
        return map;
    }

    static ArrayList<String> getMapKeysByType(Map<String, ViewHolder> buttonHolderMap, String type) {
        ArrayList<String> keyList = new ArrayList<>();
        for (String mapKey : buttonHolderMap.keySet()) {
            ViewHolder viewHolder = buttonHolderMap.get(mapKey);
            if (viewHolder.type.equalsIgnoreCase(type)) {
                keyList.add(mapKey);
            }
        }
        return keyList;
    }

    static ArrayList<String> getScreenTextListByType(Map<String, ViewHolder> buttonHolderMap, String type) {
        ArrayList<String> textList = new ArrayList<>();
        for (String mapKey : buttonHolderMap.keySet()) {
            ViewHolder viewHolder = buttonHolderMap.get(mapKey);
            if (viewHolder.type.equalsIgnoreCase(type)) {
                textList.add(viewHolder.screenText);
            }
        }
        return textList;
    }
}