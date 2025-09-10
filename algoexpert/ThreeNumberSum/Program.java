import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Collections;

class Program {
  public static final int N = 3;

  public static Boolean isValidTriplet(int[] array, int targetSum) {
    List<Integer> triplet = Arrays.stream(array).boxed().collect(Collectors.toList());
    Integer sum = triplet.stream().reduce(0, Integer::sum);
    return sum == targetSum;
  }

  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    List<Integer[]> triplets = new ArrayList<>();
    Arrays.sort(array);

    for (int i=0; i < array.length; i++) {
      int leftIndex = i >= 1 ? i - 1 : i;
      int rightIndex = i < (array.length - 1) ? i + 1 : i;
      int right = array[rightIndex];
      int left = array[leftIndex];
      int current = array[i];

      if (left != right && right != current && left != current) {
        int[] triplet = {left, current, right};

        for (int l=leftIndex; l >= 0; l--) {
          left = array[l];
          for (int r=rightIndex; r < array.length; r++) {
            right = array[r];

            triplet = new int[]{left, current, right};
            Arrays.sort(triplet);

            if (isValidTriplet(triplet, targetSum)) {
              Integer[] newTriplet = Arrays.stream(triplet)
                .boxed()
                .toArray(Integer[]::new);

              triplets.add(newTriplet);
            }
          }
        }
      }
    }

    Collections.sort(triplets, (a, b) -> Integer.compare(a[0], b[0]));

    return triplets;
  }
}
