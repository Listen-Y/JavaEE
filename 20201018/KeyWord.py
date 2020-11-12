from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time

driver = webdriver.Chrome()
driver.get("http://www.baidu.com")
# send_keys表示输入什么
driver.find_element_by_id("kw").send_keys("詹姆斯")
time.sleep(2)
# click表示鼠标点击一下
driver.find_element_by_id("su").click()
# clear表示清空输入的
driver.find_element_by_id("kw").clear()
time.sleep(2)
# submit表示一个表单的提交
driver.find_element_by_id("kw").send_keys("库里")
# 智能等待 就是只要加载好就执行下面 不像sleep是必须等待时间到
# 设置时间表示最大等待设置的那个时间
driver.implicitly_wait(10)
driver.find_element_by_id("su").submit()
# text表示获取元素文本的内容
text = driver.find_element_by_xpath("//*[@id='con-ar']/div/div/div/table/tbody[1]/tr[1]/td[1]/a").text
print(text)

# 打印title和url
title = driver.title
url = driver.current_url
print(title + " " + url)

# 键盘按键的使用
# 使用组合键将输入框删除再输入新的东西 最后使用enter键表示查找
# 使用ctrl + a全选
driver.find_element_by_id("kw").send_keys(Keys.CONTROL, 'a')
time.sleep(5)
# 使用退格键删除
driver.find_element_by_id("kw").send_keys(Keys.BACK_SPACE)
time.sleep(2)
# 再次输入东西
driver.find_element_by_id("kw").send_keys("李白")
time.sleep(2)
# 使用enter查找
driver.find_element_by_id("kw").send_keys(Keys.ENTER)


