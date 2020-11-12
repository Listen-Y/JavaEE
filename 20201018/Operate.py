from selenium import webdriver
import time

driver = webdriver.Firefox()
driver.get("http://www.baidu.com")
# 浏览器操作
# 最大化
driver.maximize_window()
time.sleep(2)
# 最下化
driver.minimize_window()
time.sleep(2)
# 设置高和宽
driver.set_window_size(500, 500)
time.sleep(2)
# 前进和后退
# 再访问百度的基础上再去访问搜狗
driver.get("http://www.sogou.com")
time.sleep(2)
# 后退
driver.back()
time.sleep(2)
# 前进
driver.forward()

# 滚动条的控制
# 将滚动条到底部
js = "var q=document.documentElement.scrollTop=10000"
driver.execute_script(js)
time.sleep(2)
# 将滚动条到顶部
js = "var q=document.documentElement.scrollTop=0"
driver.execute_script(js)
