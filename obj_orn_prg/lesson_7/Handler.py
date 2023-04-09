class Handler():

    def __init__(self, str):
        self.str = str
        self.listSymbol = "()*/+-"
        self.phrase = []
        pass

    def parseString(self):
        i = 1

        while self.str > i:
            if self.str[i] == '(':
                if ~(self.str[i-1] in self.listSymbol):
                    self.str = self.str[0:i] + '*' + self.str[i:]
            else:
                if self.str[i-1] == ')':
                    if ~(self.str[i] in self.listSymbol):
                        self.str = self.str[0:i] + '*' + self.str[i:]
                        

