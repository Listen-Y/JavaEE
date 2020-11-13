from selenium import webdriver
import time
import os

dr = webdriver.Firefox()
file_path = 'file:///' + os.path.abspath("D:/Tool/%E6%B5%8B%E8%AF%95%E7%AE%A1%E7%90%86%E5%B7%A5%E5%85%B71/selenium2html/alert.html#")
dr.get(file_path)
# 点击链接弹出alert
dr.find_element_by_link_text("hover to see tooltip").click()
time.sleep(3)
# 接受警告信息
alert = dr.switch_to.alert()
alert.accept()
# 得到文本信息打印
print(alert.text)

time.sleep(2)
dr.quit()