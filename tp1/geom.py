def point(x,y):
	res = dict()
	res["x"]=x
	res["y"]=y
	return res

def getx(p):
	return p["x"]

def gety(p):
	return p["y"]


def rectangle(x,y,w,h):
	res=dict()
	res["x"]=x
	res["y"]=y
	res["w"]=w
	res["h"]=h
	return res

def getxrectangle(rectangle):
	return rectangle["x"]

def getyrectangle(rectangle):
        return rectangle["y"]

def getwrectangle(rectangle):
        return rectangle["w"]

def gethrectangle(rectangle):
        return rectangle["h"]

def get_center(rectangle):
	return point(getxrectangle(rectangle)+getwrectangle(rectangle)/2,getyrectangle(rectangle)+gethrectangle(rectangle)/2)

def get_surface(rectangle):
	return gethrectangle(rectangle)*getwrectangle(rectangle)

def set_center(rectangle, p):
	rectangle["x"]=2*p[0]-rectangle["w"]
	rectangle["y"]=2*p[1]-rectangle["h"]
	return rectangle

print(set_center(rectangle(0,0,2,2),(1.5,1.5)))
