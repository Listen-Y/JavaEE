package com.itheima.book;
//专门用于读取文件

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	//1.读取文件的所有内容
	public static List<Book> readAll(){
		//1.定义一个集合
		List<Book> bookList = new ArrayList<>();
		//2.判断文件是否存在
		File file = new File("book.txt");
		if(!file.exists()){
			//创建文件
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return bookList;//返回一个空集合
		
		}
		//3.如果文件存在，读取文件
		try(BufferedReader bufIn = new BufferedReader(new FileReader(file))){
			String row = null;
			while((row = bufIn.readLine()) != null){
				String[] arr = row.split(",");
				//创建一个Book对象
				Book book = new Book();
				book.setId(Integer.parseInt(arr[0]));
				book.setTitle(arr[1]);
				book.setAuthor(arr[2]);
				book.setPublishing(arr[3]);
				book.setPrice(Double.parseDouble(arr[4]));
				book.setPublicationDate(arr[5]);
				
				//将book对象存储到集合
				bookList.add(book);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bookList;
	}
	//2.覆盖写入一个集合的所有内容
	public static void writeAll(List<Book> books){
		try(BufferedWriter butOut = new BufferedWriter(new FileWriter("book.txt"))){
			//遍历集合
			for(int i = 0;i < books.size() ; i++){
				Book book = books.get(i);
				butOut.write(book.getId() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getPublishing() + "," + book.getPrice() + "," + book.getPublicationDate());
				if(i < books.size() - 1){
					butOut.write("\r\n");
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
