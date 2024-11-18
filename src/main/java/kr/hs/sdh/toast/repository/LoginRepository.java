package kr.hs.sdh.toast.repository;

import kr.hs.sdh.toast.entity.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginRepository {
    @Select("SELECT * FROM customer WHERE c_id = #{id}")
    Customer findId(String id);

    @Select("SELECT * FROM customer WHERE c_spassword = #{password}")
    Customer findPassword(String password);
    @Insert("""
        INSERT INTO customer(c_id, c_password, c_name, c_identity, c_email, c_contact, c_address)
        VALUES (#{id},#{password},#{name},#{identity},#{email},#{contact},#{address})
    """)
    void UserInfo (Customer customer);



}
