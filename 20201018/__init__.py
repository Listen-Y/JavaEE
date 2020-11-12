from selenium import webdriver
import time

# 开启驱动
dirver = webdriver.Chrome()
dirver.get("http://www.baidu.com")
# 通过id定位
dirver.find_element_by_id("kw").send_keys("詹姆斯")
# 等待俩秒
time.sleep(2)
# 清空
dirver.find_element_by_id("kw").clear()
# 通过name定位
dirver.find_element_by_name("wd").send_keys("勒布朗")
time.sleep(2)
dirver.find_element_by_name("wd").clear()
# 通过tag name定位 也就是标签名 一般不成功 因为一个页面还有多个这样的标签
# dirver.find_element_by_tag_name("input").send_keys("斯蒂芬")
# 通过class name定位
dirver.find_element_by_class_name("s_ipt").send_keys("库里")
time.sleep(2)
dirver.find_element_by_class_name("s_ipt").clear()
# 通过css定位
dirver.find_element_by_css_selector("#kw").send_keys("凯文")
time.sleep(2)
dirver.find_element_by_css_selector("#kw").clear()
# 通过xpath定位 也就是这个元素在页面的路径
dirver.find_element_by_xpath("//*[@id='kw']").send_keys("杜兰特")
# 点击
dirver.find_element_by_id("su").click()
time.sleep(5)

