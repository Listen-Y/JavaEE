import unittest, csv
import os, sys
import time
import test1
import test2


# 手工添加案例到套件，
def createSuite():
    suite = unittest.TestSuite()
    # 将测试用例加入到测试容器（套件）中
    suite.addTest(unittest.makeSuite(test1.TestBaiDu1))
    suite.addTest(unittest.makeSuite(test2.TestBaiDu2))
    return suite


if __name__ == "__main__":
    suite = createSuite()
    runner = unittest.TextTestRunner(verbosity=2)
    runner.run(suite)