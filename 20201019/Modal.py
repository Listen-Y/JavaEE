
from selenium import webdriver
from time import sleep
import os


dr = webdriver.Chrome()
file_path = "file:///D:/Tool/%E6%B5%8B%E8%AF%95%E7%AE%A1%E7%90%86%E5%B7%A5%E5%85%B71/selenium2html/modal.html"
dr.get(file_path)
# 打开对话框
dr.find_element_by_id('show_modal').click()
sleep(3)
# 点击对话框中的链接
link = dr.find_element_by_id('myModal').find_element_by_id('click')
link.click()
sleep(4)
# 关闭对话框
buttons = dr.find_element_by_class_name('modal-footer').find_elements_by_tag_name('button')
buttons[0].click()
sleep(2)
dr.quit()