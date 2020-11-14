import unittest, csv
import test1, test2
import os, sys
import time


# 手工添加测试用例到套件
def createSuite():
    # 初始化一个测试套件
    suite = unittest.TestSuite()
    # 将测试用例添加到测试套件中
    suite.addTest(test1.TestBaiDu1("test_baiDuSearch"))
    suite.addTest(test1.TestBaiDu1("test_hao"))
    suite.addTest(test2.TestBaiDu2("test_baiDuSearch"))
    return suite


if __name__ == "__main__":
    suite = createSuite()
    # 2表示显示详细信息
    runner = unittest.TextTestRunner(verbosity=2)
    # 执行测试套件
    runner.run(suite)
