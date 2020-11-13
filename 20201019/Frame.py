from selenium import webdriver
import time
import os

driver = webdriver.Chrome()
# 打开本地html文件
path = "file:///" + os.path.abspath("D:/Tool/%E6%B5%8B%E8%AF%95%E7%AE%A1%E7%90%86%E5%B7%A5%E5%85%B71/selenium2html/frame.html")
driver.get(path)
driver.implicitly_wait(30)
# 进入下一级框架
driver.switch_to.frame("f1")
driver.switch_to.frame("f2")
driver.find_element_by_id("kw").send_keys("詹姆斯")
driver.find_element_by_id("su").click()
# 回到初始框架
driver.switch_to_default_content()
# 再重新进去
driver.switch_to.frame("f1")
driver.implicitly_wait(30)
driver.close()