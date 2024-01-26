from geom import *

def test_creation():
	p = point(22,7)
	assert 22 == getx(p)
	assert 7 == gety(p)

rectangle_test = rectangle(0,0,2,2)

def test_getxrectangle():
	assert getxrectangle(rectangle_test) == 0

def test_getyrectangle():
	assert getyrectangle(rectangle_test) == 0

def test_getwrectangle():
	assert getwrectangle(rectangle_test) == 2

def test_gethrectangle():
	assert gethrectangle(rectangle_test) == 2

def test_get_center():
	assert get_center(rectangle_test) == {'x': 1.0, 'y': 1.0}

def test_set_center():
	assert set_center(rectangle_test, (1.5,1.5)) == {'x': 1.0, 'y': 1.0, 'w': 2, 'h': 2}