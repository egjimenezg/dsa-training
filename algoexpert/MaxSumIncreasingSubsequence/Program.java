import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Program {
  public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
    List<Integer> increasingSubsequence = new ArrayList<Integer>();
    int[] sums = new int[array.length];
    sums[0] = array[0];
    int maxValueIndex = 0;
    int maxSum = sums[0];

    // O(n^2)
    for (int current=1; current < array.length; current++) {
      int sum = array[current];
      for(int prev=0; prev < current; prev++) {
        if (array[prev] < array[current]) {
          if ((sums[prev] + array[current]) > sum) {
            sum = sums[prev] + array[current];
          }
        }
      }
      sums[current] = sum;
      if (sum > maxSum) {
        maxSum = sum;
        maxValueIndex = current;
      }
    }

    int lastMaxSum = maxSum;
    int idxMaxValue = maxValueIndex;

    increasingSubsequence.add(array[maxValueIndex]);
    maxValueIndex = Math.max(maxValueIndex-1, 0);

    // O(n)
    for(int index=maxValueIndex; index >= 0; index--) {
      if ((sums[idxMaxValue] - sums[index]) == array[idxMaxValue]) {
        idxMaxValue = index;
        increasingSubsequence.add(array[index]);
      }
    }

    Collections.reverse(increasingSubsequence);
    List<Integer> maxSumList = List.of(maxSum);

    return new ArrayList<List<Integer>>() {
      {
        add(maxSumList); // Example max sum
        add(increasingSubsequence); // Example max sequence
      }
    };
  }
}
