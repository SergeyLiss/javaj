class Calc():

    def __init__(self):
        self.a = 0
        self.b = 0
        pass

    def operation(self, operat):
        if operat == '*':
            return self.a * self.b
        elif operat == '/':
            return self.a / self.b
        elif operat == '+':
            return self.a + self.b
        elif operat == '-':
            return self.a - self.b
        else:
            return None