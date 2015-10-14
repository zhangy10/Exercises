package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSubString {
    private String originalStr;
    private List<String> inputs;

    public FindSubString(String string) {
        this.originalStr = string;
        inputs = new ArrayList<>(Arrays.asList(this.originalStr.split("")));
        inputs.remove(0);
    }

    public static void main(String[] args) {
        FindSubString fString = new FindSubString("GATTAGACCTTA");
        List<String> tempList = fString.subBruteForce("A", "T");
        System.out.println(
                Arrays.toString(tempList.toArray(new String[tempList.size()])));
        System.out.println(fString.occurrenceScan("A", "T"));
    }

    public List<String> subBruteForce(String start, String end) {
        List<String> subStrList = new ArrayList<>();
        for (int i = 0; i < inputs.size(); i++)
            if (inputs.get(i).equals(start))
                for (int j = i + 1; j < inputs.size() - 1; j++)
                    if (inputs.get(j).equals(end))
                        subStrList.add(originalStr.substring(i, j + 1));
        return subStrList;
    }

    public int occurrenceScan(String start, String end) {
        List<Integer> startOcc = new ArrayList<>();
        List<Integer> endOcc = new ArrayList<>();
        for (int i = 0; i < inputs.size(); i++) {
            if (inputs.get(i).equals(start)) {
                startOcc.add(i);
            }
            else if (inputs.get(i).equals(end)) {
                endOcc.add(i);
            }
        }
        int occurrence = 0;
        for (int i = 0; i < startOcc.size(); i++) {
            for (int j = 0; j < endOcc.size(); j++) {
                if (startOcc.get(i) < endOcc.get(j)) {
                    occurrence += endOcc.size() - j;
                    break;
                }
            }
        }
        return occurrence;
    }

}
