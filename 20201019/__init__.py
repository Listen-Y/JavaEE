from selenium import webdriver
import time
import os

driver = webdriver.Chrome()
# 打开本地html文件
path = "file:///" + os.path.abspath("D:/Tool/%E6%B5%8B%E8%AF%95%E7%AE%A1%E7%90%86%E5%B7%A5%E5%85%B71/selenium2html/checkbox.html")
driver.get(path)
# 获取页面上一组的input元素 然后逐一进行判断
inputs = driver.find_elements_by_tag_name("input")

for input in inputs:
    if input.get_attribute("type") == 'checkbox':
        input.click()

time.sleep(2)