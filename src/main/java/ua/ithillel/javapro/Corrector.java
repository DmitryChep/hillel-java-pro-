package ua.ithillel.javapro;

public class Corrector {
    public String handleData(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (String str : strings) {
            if (str.contains("b")) {
                str = str.replace("b", "o");
            }
            count++;
            stringBuilder.append(count).append(")").append(str).append("\n");
        }
        return stringBuilder.toString();
    }
}
