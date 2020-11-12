from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("http://www.baidu.com")
# 通过全名链接定位
# driver.find_element_by_link_text("学术").click()
# 通过模糊链接名定位 如果有多个匹配 则都打开
driver.find_element_by_partial_link_text("图").click()
time.sleep(3)
driver.close()