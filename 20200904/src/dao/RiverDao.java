package dao;

import exception.riverException;
import util.DBUtil;
import model.River;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RiverDao {

    //新增河流
    public void addRiver(River river) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql ="insert into river values (null,?,?,?,?,?)";
        connection= DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,river.getRiver_name());
            preparedStatement.setString(2,river.getRiver_length());
            preparedStatement.setString(3,river.getRiver_location());
            preparedStatement.setString(4,river.getRiver_class());
            preparedStatement.setString(5,river.getRiver_status());

            int ret = preparedStatement.executeUpdate();

            if(ret!= 1){
                throw new riverException("插入数据失败！");

            }


        } catch (SQLException e) {
            throw new riverException("插入数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }

    //由编号删除河流
    public void deleteRiverByNum(int num) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "delete from river where river_num = ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,num);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new riverException("删除数据失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("删除数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }

    //由名字删除河流
    public void deleteRiverByName(String name) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "delete from river where river_name = ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new riverException("删除数据失败！");
            }
        } catch (SQLException e) {
            throw new riverException("删除数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }

    //查找所有河流
    public List<River> SelectAll() throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from river ";
        connection = DBUtil.getConnect();

        List<River> riverList = new ArrayList();
        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                River river = new River() ;
                river.setRiver_num(resultSet.getInt("river_num"));
                river.setRiver_name(resultSet.getString("river_name"));
                river.setRiver_length(resultSet.getString("river_length"));
                river.setRiver_location(resultSet.getString("river_location"));
                river.setRiver_class(resultSet.getString("river_class"));
                river.setRiver_status(resultSet.getString("river_status"));
                riverList.add(river);


            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("查询所有河流信息失败！");

        }finally {
            DBUtil.getClose(connection,preparedStatement,resultSet);
        }
        return riverList;

    }

    //由编号查找河流
    public River selectByNum(int num) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from river where river_num = ?";
        connection = DBUtil.getConnect();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,num);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                River river = new River() ;
                river.setRiver_num(resultSet.getInt("river_num"));
                river.setRiver_name(resultSet.getString("river_name"));
                river.setRiver_length(resultSet.getString("river_length"));
                river.setRiver_location(resultSet.getString("river_location"));
                river.setRiver_class(resultSet.getString("river_class"));
                river.setRiver_status(resultSet.getString("river_status"));
                return  river;

            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("按照num查找河流失败！");

        }finally {
            DBUtil.getClose(connection,preparedStatement,resultSet);
        }
        return null;
    }


    //由名字查找具体的河流的信息
    public River selectByName(String name) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from river where river_name = ?";
        connection = DBUtil.getConnect();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                River river = new River() ;
                river.setRiver_num(resultSet.getInt("river_num"));
                river.setRiver_name(resultSet.getString("river_name"));
                river.setRiver_length(resultSet.getString("river_length"));
                river.setRiver_location(resultSet.getString("river_location"));
                river.setRiver_class(resultSet.getString("river_class"));
                river.setRiver_status(resultSet.getString("river_status"));
                return  river;

            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("按照名字查找河流失败！");

        }finally {
            DBUtil.getClose(connection,preparedStatement,resultSet);
        }
        return null;
    }


    //由名字更改河流的地理位置
    public void updateRiverLocationByName(String name, String location) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "update  river set  river_location = ? where river_name = ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,location);
            preparedStatement.setString(2,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new riverException("修改数据失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("修改数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }

    //由名字更改河流的长度
    public void updateRiverLengthByName(String name, String length) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "update  river set  river_length = ? where river_name = ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,length);
            preparedStatement.setString(2,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new riverException("修改数据失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("修改数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }

    //由旧名字改新名字
    public void updateRiverNewNameByName(String name, String newName) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "update  river set  river_name = ? where river_name = ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,newName);
            preparedStatement.setString(2,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new riverException("修改数据失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("修改数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }

    //由名字更改河流的类型
    public void updateRiverClassByName(String name, String riverClass) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "update  river set  river_class = ? where river_name = ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,riverClass);
            preparedStatement.setString(2,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new riverException("修改数据失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("修改数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }


    //由名字更改河流的整治情况
    public void updateRiverStatusByName(String name, String status) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "update  river set  river_status = ? where river_name = ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,status);
            preparedStatement.setString(2,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new riverException("修改数据失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("修改数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }

    //模糊查询
    public List<River> selectByNameList(String name) throws riverException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<River> riverList = new ArrayList<>();
        String sql ="select * from river where river_name like " + "'%" + name.trim() + "%'";
        System.out.println(sql);
        connection = DBUtil.getConnect();

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                River river = new River() ;
                river.setRiver_num(resultSet.getInt("river_num"));
                river.setRiver_name(resultSet.getString("river_name"));
                river.setRiver_length(resultSet.getString("river_length"));
                river.setRiver_location(resultSet.getString("river_location"));
                river.setRiver_class(resultSet.getString("river_class"));
                river.setRiver_status(resultSet.getString("river_status"));
                riverList.add(river);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new riverException("按照名字查找河流失败！");

        }finally {
            DBUtil.getClose(connection,preparedStatement,resultSet);
        }
        return riverList;
    }

}
/*class Test{
    public static void main(String[] args) throws riverException {
        RiverDao riverDao = new RiverDao();
        River river = new River();
        *//*river.setRiver_name("黄河");
        river.setRiver_location("青藏高原");
        river.setRiver_length("5464");
        river.setRiver_class("黄河水系");
        river.setRiver_status("泥沙严重");
        riverDao.addRiver(river);*//*
        //riverDao.updateRiverLocationByName("黄河","四川");
       *//* riverDao.updateRiverClassByName("黄河","泥沙");
        riverDao.updateRiverLengthByName("黄河","151615");
        riverDao.updateRiverStatusByName("黄河","奔腾");*//*
        //river = riverDao.selectByName("黄河");
       // river = riverDao.selectByNum(1);
        //System.out.println(river);
        //riverDao.deleteRiverByName("黄河");
       // riverDao.deleteRiverByNum(2);

    }
}*/
