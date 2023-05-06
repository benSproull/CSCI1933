def most_common(word):
    c = 0
    i = 0
    mc = -100
    keys = ''
    list = {}

    for c in word:
        if c in list:
            list[c] += 1
        else:
            list[c] = 1

    list.keys()
    for key in list.keys():
        value = list[key]
        if value > mc:
            mc = value
            keys = key

    return keys, mc

def palidrome(word):
    if word == '' or len(word) == 1:
        return True
    if word[0] == word[-1]:
        return palidrome(word[1:-1])
    else:
        return False


class Circle:
    def __init__(self,radius):
        self.radius = radius
    def __eq__(self,other):
        if self.radius == other.radius:
            return True
        else:
            return False
    def getRadius(self):
        return self.radius
    def setRadius(self):
        r = input("enter the radius")
        self.radius = r
    def getArea(self):
        A = self.radius * self.radius * 3.1415
        return A
    def getDiameter(self):
        return self.radius * 2
    def getCircumfrence(self):
        return 2 * 3.1415 * self.radius


c1 = Circle(10)
print(c1.getRadius())
print(c1.getArea())
print(c1.getDiameter())
print(c1.getCircumfrence())

c2 = Circle(56)
print(c2.getRadius())
print(c2.getArea())
print(c2.getDiameter())
print(c2.getCircumfrence())
print(c1.__eq__(c2))




















    #
