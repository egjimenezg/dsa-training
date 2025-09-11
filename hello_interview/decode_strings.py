class Solution:

  def decodeString(self, s: str):
    stack = []
    mappings = {"]": "[", "}": "{"}
    answer = ""
    characters_in_str = ""

    for c in s:
      if len(stack) and c in mappings:
        while not stack[-1].isnumeric():
          top = stack.pop()
          if top.isalnum():
            characters_in_str = "".join([top, characters_in_str])

        reps = ""
        while len(stack) and stack[-1].isnumeric():
          reps = "".join([stack.pop(), reps])

        characters_in_str = characters_in_str * int(reps)

        while len(stack) and stack[-1].isalnum():
          alnum = stack.pop()
          characters_in_str = "".join([alnum, characters_in_str])
      else:
        if len(stack) == 0:
          answer = "".join([answer, characters_in_str])
          characters_in_str = ""
          stack.append(c)
        elif characters_in_str and c.isalnum():
          characters_in_str = "".join([characters_in_str, c])
        else:
          stack.append(c)

    if characters_in_str:
      answer = "".join([answer, characters_in_str])

    for number in stack:
      answer = "".join([answer, number])

    return answer

solution = Solution()
assert "aaabcbc" == solution.decodeString("3[a]2[bc]")
assert "abcabccdcdcdef" == solution.decodeString("2[abc]3[cd]ef")
