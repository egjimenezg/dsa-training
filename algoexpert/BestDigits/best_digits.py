def bestDigits(numbers, num_digits):
  stack = [numbers[0]]
  numbers_to_delete = 0

  for idx in range(1, len(numbers)):
    number = numbers[idx]
    while len(stack) and number >= stack[0] and numbers_to_delete < num_digits:
      stack.pop(0)
      numbers_to_delete += 1
    stack.insert(0, number)

  while numbers_to_delete < num_digits:
    stack.pop(0)
    numbers_to_delete += 1
  stack.reverse()

  return ''.join(stack)

if __name__ == "__main__":
  assert "6839" == bestDigits("462839", 2)
