from geom import *

def test_creation():
	p = point(22,7)
	assert 22 == getx(p)
	assert 7 == gety(p)
