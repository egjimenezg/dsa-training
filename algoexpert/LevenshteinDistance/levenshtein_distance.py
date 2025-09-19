def levenshteinDistance(str1, str2):
  n = len(str1)
  m = len(str2)

  matrix = [[0] * (m+1) for i in range(n+1)]

  for row in range(1, n+1):
    matrix[row][0] = row

  for col in range(1, m+1):
    matrix[0][col] = col

  for row in range(1, n+1):
    for col in range(1, m+1):
      if str1[row-1] == str2[col-1]:
        matrix[row][col] = matrix[row-1][col-1]
      else:
        matrix[row][col] = 1 + min(matrix[row][col-1], min(matrix[row-1][col], matrix[row-1][col-1]))

  return matrix[n][m]
print(levenshteinDistance("abc", "yabd"))
