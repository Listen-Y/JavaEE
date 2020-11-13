from selenium import webdriver
from selenium.webdriver.support.ui import webDriverwait
import time
import os

dr = webdriver.Chrome()
file_path = 'file:///' + os.path.abspath('level_locate.html')
dr.get(file_path)
# 点击Link1链接（弹出下拉列表)
dr.find_element_by_link_text('Link1').click()
# 找到id 为dropdown1的父元素
webDriverwait(dr,10).until(lambda the_driver:
the_driver.find_element_by_id('dropdown1 ').is_displayed())
# 在父亲元件下找到link为Action的子元素
menu = dr.find_element_by_id('dropdown1').find_element_by_link_text('Action')
# 鼠标定位到子元素上
webdriver.ActionChains(dr).move_to_element(menu) .perform()
time.sleep(2)
dr.quit()