package com.evol.nmsg.mapper;
import com.evol.nmsg.domain.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.UUID;

@Mapper
public interface MessageMapper {



    /**
     * 根据id获取留言
     * **/
    @Select("SELECT * FROM message WHERE id = #{id}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    Message find(@Param("id") UUID id);

    /**
     * 根据主题和正文关键字检索
     * **/
    @Select("SELECT * FROM message WHERE subject LIKE #{key} OR content LIKE #{key}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    List<Message> selectBySubOrContent(@Param("key") String key);

    /**
     * 查询所有
     * **/
    @Select("SELECT * FROM message")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    List<Message> selectAll();



    /**
     * 插入留言
     * **/
    @Insert("INSERT INTO message(id, user_id, subject, content, model, create_time, update_time) VALUES(#{id}, #{userId}, #{subject}, #{content}, #{model}, #{createTime}, #{updateTime})")
    int insert(Message message);

    /**
     *
     * **/
    @Update("UPDATE message SET subject = #{subject}, content = #{content}, updateTime = #{update_time} WHERE id = #{id}")
    int update(Message message);


    @Delete("DELETE FROM message WHERE id = #{id}")
    int delete(@Param("id") UUID id);




}
