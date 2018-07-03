package org.lots.candy.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lots.candy.entity.TwitterProfile;
import org.lots.candy.entity.User;

@Mapper
public interface UserMapper {
	
	@Update("update user set ${provider}Account = #{userProviderId} where userId =#{userId}")
	public void updateAccount(@Param("userId")String userId, @Param("provider")String provider, @Param("userProviderId")String userProviderId);
	
	@Select("select * from user s where s.email = #{email} and s.password = md5(#{password}) and status='1'")
	public User findUserByEmailAndPwd(@Param("email") String email, @Param("password") String password);
	
//	@Select("select * from user where email = #{email}")
//	public User findUserByEmail(@Param("email") String email);
//	
	@Select("select * from user where ${column} = #{value} and status='1'")
	public User findUserByElement(@Param("column") String column, @Param("value") String value);
	
	@Select("select count(*) from user where inviteCode=#{superInviteCode} and status='1'")
	public int findInviteCode(@Param("superInviteCode") String superInviteCode);
	
	@Insert("insert into user(userId,username,password,email,inviteCode,superInviteCode,status) values(#{userId},#{username},md5(#{password}),#{email},#{inviteCode},#{superInviteCode},#{status})")
	public void save(@Param("userId") String userId, @Param("username") String username, @Param("password") 
	String password, @Param("email") String email, @Param("inviteCode")String inviteCode, @Param("superInviteCode") String superInviteCode, @Param("status") String status);
	
	@Update("update user set status = '1' where userId = #{userId}")
	public void updateUserStatus(@Param("userId") String userId);
	
	@Update("update user set password = md5(#{password}) where userId=#{userId}")
	public void resetPassword(@Param("userId") String userId, @Param("password") String password);
	
	@Update("update user set wallet = #{wallet} where userId=#{userId}")
	public void addWallet(@Param("wallet") String wallet, @Param("userId") String userId);
	
	@Select("select * from user where superInviteCode=#{inviteCode} and status='1'")
	public List<User> findUserBySuperInviteCode(@Param("inviteCode") String inviteCode);
	
	@Select("select count(*) from user where superInviteCode=#{superInviteCode}")
	public int findCodeTotalNum(@Param("superInviteCode") String superInviteCode);
	
	@Select("select * from influence_point order by level")
	public List<HashMap> findInfluencePoint();
	
}
