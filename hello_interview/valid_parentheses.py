class Solution:
    def isValid(self, s: str):
        stack = []
        for c in s:
          if c == ')' and stack[-1] == '(':
            stack.pop(-1)
          elif c == '}' and stack[-1] == '{':
            stack.pop(-1)
          else:
            stack.append(c)
        return len(stack) == 0

s = Solution()

assert s.isValid("(){({})}") == True
assert s.isValid("(){({}})") == False
