from selenium import webdriver
import os, time

driver = webdriver.Chrome()
file_path = 'file:///' + os.path.abspath("D:/Tool/%E6%B5%8B%E8%AF%95%E7%AE%A1%E7%90%86%E5%B7%A5%E5%85%B71/selenium2html/upload.html")
driver.get(file_path)
# 定位上传按钮，添加本地文件
driver.implicitly_wait(30)
driver.find_element_by_name("file").send_keys("D:/test/object.txt")
time.sleep(10)
driver.quit()