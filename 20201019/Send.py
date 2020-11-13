from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.common.exceptions import NoSuchElementException,UnexpectedTagNameException
from selenium.webdriver.support.ui import Select
from selenium.webdriver.common.alert import Alert
from time import sleep
import os

driver=webdriver.Chrome()
driver.implicitly_wait(30)
file_path = 'file:///' + os.path.abspath("D:/Tool/%E6%B5%8B%E8%AF%95%E7%AE%A1%E7%90%86%E5%B7%A5%E5%85%B71/selenium2html/send.html")
driver.get(file_path)
# 点击“请点击”
driver.find_element_by_xpath("html/body/input").click()
sleep(2)
# 输入内容
driver.switch_to.alert().send_keys('webdriver')
driver.switch_to.alert().accept()
sleep(5)
driver.quit()