package com.hstba.jingzheng.mapper;

import com.hstba.jingzheng.entity.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {

    @Select("SELECT * FROM user where openid=#{openid}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "openid", column = "openid"),
            @Result(property = "avatarUrl", column = "avatarUrl"),
            @Result(property = "city", column = "city"),
            @Result(property = "country", column = "country"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "language", column = "language"),
            @Result(property = "nickName", column = "nickName"),
            @Result(property = "province", column = "province"),
            @Result(property = "remind", column = "remind"),
    })
    User getUserByOpenId(@Param("openid") String openid);

    @Update("UPDATE user SET avatarUrl=#{avatarUrl},city=#{city},country=#{country},gender=#{gender},language=#{language},nickName=#{nickName},province=#{province} WHERE openid =#{openid}")
    void update(User user);

    @Update({"UPDATE user SET remind=#{remind},formId=#{formId} WHERE openid =#{openid}"})
    void setRemind(@Param("remind") int remind, @Param("openid") String openid, @Param("formId") String formId);

}