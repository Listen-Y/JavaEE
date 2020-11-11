#coding=utf-8
from selenium import webdriver
import time
browser = webdriver.Chrome()
browser.get("http://www.baidu.com")
#########百度输入框的定位方式##########
#通过id 方式定位
#browser.find_element_by_id("kw").send_keys("selenium")
#通过name 方式定位
#browser.find_element_by_name("wd").send_keys("selenium")
#通过tag name 方式定位
#browser.find_element_by_tag_name("input").send_keys("selenium")  不能成功，因为input太多了不唯一。
#通过class name 方式定位
#browser.find_element_by_class_name("s_ipt").send_keys("selenium")
#通过CSS 方式定位
#browser.find_element_by_css_selector("#kw").send_keys("selenium")
#通过xphan 方式定位
browser.find_element_by_xpath("//*[@id='kw']").send_keys("selenium")
############################################
browser.find_element_by_id("su").click()
time.sleep(10)
browser.quit()