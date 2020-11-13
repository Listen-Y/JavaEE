import os
import time
from selenium import webdriver

driver = webdriver.Chrome()
file_path = 'file:///' + os.path.abspath("D:/Tool/%E6%B5%8B%E8%AF%95%E7%AE%A1%E7%90%86%E5%B7%A5%E5%85%B71/selenium2html/drop_down.html")
driver.get(file_path)
time.sleep(2)
# 先定位到下拉框
m = driver.find_element_by_id("ShippingMethod")

# 再点击下拉框下的选项
# m.find_element_by_xpath("//option[@value='10.69']").click()

# 通过获取一组元素按数组中的位置去选择下拉框
options = driver.find_elements_by_tag_name("option")
options[2].click()
time.sleep(3)
driver.quit()