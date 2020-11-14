from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select
from selenium.common.exceptions import NoSuchElementException
from selenium.common.exceptions import NoAlertPresentException
import unittest
import time
import re


class TestBaiDu1(unittest.TestCase):

    # setUp用来初始化环境 每执行一个测试方法都会先执行这个方法
    # self表示这个类的实例
    def setUp(self) -> None:
        self.driver = webdriver.Chrome()
        self.driver.implicitly_wait(30)
        self.base_url = "http://www.baidu.com"

    # 测试用例必须用test开头
    def test_baiDuSearch(self):
        driver = self.driver
        driver.get(self.base_url + "/")
        driver.find_element_by_id("kw").click()
        driver.find_element_by_id("kw").clear()
        # u表示字符编码
        driver.find_element_by_id("kw").send_keys(u"测试")
        driver.find_element_by_id("su").click()
        driver.find_element_by_id("su").click()

    def test_hao(self):
        driver = self.driver
        driver.get(self.base_url + "/")
        driver.find_element_by_link_text("hao123").click()

    # 清除环境工作 每执行完一个测试用例都会执行这个
    def tearDown(self) -> None:
        time.sleep(3)
        self.driver.close()


if __name__ == "__main__":
    # 执行测试用例
    unittest.main()
