class Program {

  public static int levenshteinDistance(String a, String b) {
    int[][] matrix = new int[a.length() + 1][b.length() + 1];
    matrix[0][0] = 0;

    for (int row=1; row <= a.length(); row++) {
      matrix[row][0] = row;
    }

    for (int col=1; col <= b.length(); col++) {
      matrix[0][col] = col;
    }

    for (int row=1; row <= a.length(); row++) {
      for (int col=1; col <= b.length(); col++) {
        if (a.charAt(row-1) == b.charAt(col-1)) {
          matrix[row][col] = matrix[row-1][col-1];
        } else {
          matrix[row][col] =  1 + Math.min(matrix[row-1][col], Math.min(matrix[row][col-1], matrix[row-1][col-1]));
        }
      }
    }

    return matrix[a.length()][b.length()];
  }

  public static void main(String[] args) {
    System.out.println(levenshteinDistance("abc", "yabd"));
  }
}
