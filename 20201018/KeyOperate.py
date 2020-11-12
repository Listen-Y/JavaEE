from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains
import time

driver = webdriver.Chrome()
driver.get("http://www.baidu.com")
# 鼠标起点
button = driver.find_element_by_link_text("更多")
time.sleep(2)
# 将鼠标移到这里
target = driver.find_element_by_xpath("//*[@id='s-top-more']/div[3]/a")
# 执行移动 移动和这类似使用的是move_to_element
ActionChains(driver).drag_and_drop(button, target).perform()
time.sleep(5)
# 鼠标双击
ActionChains(driver).double_click(target).perform()
time.sleep(3)
# 鼠标右击
kw = driver.find_element_by_id("kw")
ActionChains(driver).context_click(kw).perform()

