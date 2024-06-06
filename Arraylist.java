import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Arraylist {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>(Arrays.asList(
                Arrays.asList(-9, -9, -9, 1, 1, 1),
                Arrays.asList(0, -9, 0, 4, 3, 2),
                Arrays.asList(-9, -9, -9, 1, 2, 3),
                Arrays.asList(0, 0, 8, 6, 6, 0),
                Arrays.asList(0, 0, 0, -2, 0, 0),
                Arrays.asList(0, 0, 1, 2, 4, 0)));
        List<List<Integer>> hourglasslist = calculatesumofhourglass(arr);
        int maxsum = calculatemax(hourglasslist);
        System.out.println("MAximum Sum:" + maxsum);
    }

    public static int calculatemax(List<List<Integer>> hourglasslist) {
        int maxvalue = Integer.MIN_VALUE;
        for (List<Integer> rows : hourglasslist)
            for (int i : rows) {
                if (i > maxvalue) {
                    maxvalue = i;
                }
            }
        return maxvalue;
    }

    public static List<List<Integer>> calculatesumofhourglass(List<List<Integer>> arr) {
        List<List<Integer>> sumlist = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            sumlist.add(new ArrayList<>());
            for (int j = 0; j < 4; j++) {
                int sum = calculatesum(arr, i, j);
                sumlist.get(i).add(sum);
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(sumlist.get(i).get(j) + " ");
            }
            System.out.println(" ");
        }
        return sumlist;
    }

    public static int calculatesum(List<List<Integer>> a, int i, int j) {
        int total = a.get(i).get(j) + a.get(i).get(j + 1) + a.get(i).get(j + 2) +
                a.get(i + 1).get(j + 1) +
                a.get(i + 2).get(j) + a.get(i + 2).get(j + 1) + a.get(i + 2).get(j + 2);
        return total;
    }

}