package com.evol.nmsg.mapper;
import com.evol.nmsg.domain.User;
import org.apache.ibatis.annotations.*;
import java.util.UUID;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User find(@Param("id") UUID id);


}
