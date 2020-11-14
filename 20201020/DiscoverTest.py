import unittest, csv
import os, sys
import time


# 手工添加案例到套件，
def createSuite():

    # 第一个参数是扫描的路径 ../表示回到父路径, 然后递归扫描20201020这个文件下的文件
    # 第二个参数进行匹配test开头的.py结尾的文件, 如果匹配就加载里面的内容
    # 第三个参数表示测试模块的顶层目录，如果没有顶层目录，默认为None；一般都是为None
    discover = unittest.defaultTestLoader.discover('../20201020', pattern='test*.py', top_level_dir=None)
    print(discover)
    return discover


if __name__ == "__main__":
    suite = createSuite()
    runner = unittest.TextTestRunner(verbosity=2)
    runner.run(suite)